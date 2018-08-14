import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';

import { FuseConfigService } from '@fuse/services/config.service';
import { fuseAnimations } from '@fuse/animations';

import { UserService } from '../services/user.service';
import { StorageService } from '../services/storage.service';
import { User } from '../models/user.model';
import { Group } from '../models/group.model';
import { Auth } from '../models/auth.model';
import { LoginParam } from '../models/login.model';
import { FuseNavigationService } from '@fuse/components/navigation/navigation.service';

@Component({
    selector: 'login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.scss'],
    animations: fuseAnimations
})
export class LoginComponent implements OnInit, OnDestroy {
    loginForm: FormGroup;
    loginFormErrors: any;

    // Private
    private _unsubscribeAll: Subject<any>;

    /**
     * Constructor
     *
     * @param {FuseConfigService} _fuseConfigService
     * @param {FormBuilder} _formBuilder
     */
    user: User[];
    group: Group[];
    authList: Auth[];
    errorMessage: string;
    logParam = new LoginParam();
    // param = new User();
    authParam = new Auth();
    userId: string;
    other: any[] = [];
    constructor(
        private router: Router,
        private userService: UserService,
        private StorageService: StorageService,
        private _fuseConfigService: FuseConfigService,
        private _formBuilder: FormBuilder,
        private _fuseNavigationService: FuseNavigationService
    ) {
        // Configure the layout
        this._fuseConfigService.config = {
            layout: {
                navbar: {
                    hidden: true
                },
                toolbar: {
                    hidden: true
                },
                footer: {
                    hidden: true
                }
            }
        };

        // Set the defaults
        this.loginFormErrors = {
            email: {},
            password: {}
        };

        // Set the private defaults
        this._unsubscribeAll = new Subject();
    }

    // -----------------------------------------------------------------------------------------------------
    // @ Lifecycle hooks
    // -----------------------------------------------------------------------------------------------------

    /**
     * On init
     */
    ngOnInit(): void {
        this.loginForm = this._formBuilder.group({
            email: ['', [Validators.required, Validators.email]],
            password: ['', Validators.required]
        });

        this.loginForm.valueChanges
            .pipe(takeUntil(this._unsubscribeAll))
            .subscribe(() => {
                this.onLoginFormValuesChanged();
            });
    }

    /**
     * On destroy
     */
    ngOnDestroy(): void {
        // Unsubscribe from all subscriptions
        this._unsubscribeAll.next();
        this._unsubscribeAll.complete();
    }

    // -----------------------------------------------------------------------------------------------------
    // @ Public methods
    // -----------------------------------------------------------------------------------------------------

    /**
     * On form values changed
     */
    onLoginFormValuesChanged(): void {
        for (const field in this.loginFormErrors) {
            if (!this.loginFormErrors.hasOwnProperty(field)) {
                continue;
            }

            // Clear previous errors
            this.loginFormErrors[field] = {};

            // Get the control
            const control = this.loginForm.get(field);

            if (control && control.dirty && !control.valid) {
                this.loginFormErrors[field] = control.errors;
            }
        }
    }

    auth(): void {
        document.getElementById('spinner').style.display = 'flex';
        this.authParam.username = this.logParam.email;
        this.authParam.password = this.logParam.password;
        this.authParam.client_id = 'spring-security-oauth2-read-write-client';
        this.authParam.grant_type = 'password';
        this.userService.authorize(this.authParam)
            .subscribe(authList => {
                this.authParam = authList;
                this.login();
            },
            // error => this.errorMessage = <any>error);
            error => {
                // alert('Email or password incorrect');
                document.getElementById('loginErr').style.display = 'block';
                document.getElementById('spinner').style.display = 'none';
        });
    }

    login(): void {
        this.userService.login(this.logParam)
            .subscribe(user => {
                this.other = []; // your other array...
                user.groups.map(item => {
                    return {
                        group: item.nameEn
                    };
                }).forEach(item => this.other.push(item));
                user.avatarUrl = '';
                console.log('b login key : ' + this.authParam.access_token);
                this.StorageService.saveInLocal('token', this.authParam.access_token);
                this.StorageService.saveInLocal('user', JSON.stringify(user));
                this.StorageService.saveInLocal('group', JSON.stringify(this.other));
                let groups = this.other.filter(data => data.group.includes('MANAGER'));
                console.log('man check'+ JSON.stringify(groups));
                if(JSON.stringify(groups) !== '[]'){
                    this.addNavItemWithCustomFunction();
                }
                setTimeout(() => {
                    this.router.navigate(['welcome']);
                }, 5000);
            },
            error => this.errorMessage = <any>error);
    }

    addNavItemWithCustomFunction() {
        // Prepare the new nav item
        const newNavItem = {
            id       : 'NomintaionPoll',
            title : 'Nomination Poll',
            translate: 'NAV.NOMINATION-POLL',
            type     : 'item',
            icon     : 'flag',
            url      : '/nomination/nomination-poll'
        };
        // Add the new nav item at the beginning of the navigation
        this._fuseNavigationService.addNavigationItem(newNavItem, 'nominationProgram');
      }
    
}
