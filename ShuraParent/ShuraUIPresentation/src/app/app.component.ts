import { Component, OnDestroy, OnInit } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';

import { FuseConfigService } from '@fuse/services/config.service';
import { FuseNavigationService } from '@fuse/components/navigation/navigation.service';
import { FuseSidebarService } from '@fuse/components/sidebar/sidebar.service';
import { FuseSplashScreenService } from '@fuse/services/splash-screen.service';
import { FuseTranslationLoaderService } from '@fuse/services/translation-loader.service';

import { navigation } from 'app/navigation/navigation';
import { locale as navigationEnglish } from 'app/navigation/i18n/en';
import { locale as navigationArabic } from 'app/navigation/i18n/ar';
import { UserService } from './services/user.service';
import { Group } from './models/group.model';
import { User } from './models/user.model';
import { StorageService } from './services/storage.service';
import { CommitteeService } from './services/committee.service';

@Component({
    selector   : 'app',
    templateUrl: './app.component.html',
    styleUrls  : ['./app.component.scss']
})
export class AppComponent implements OnInit, OnDestroy
{
    navigation: any;
    fuseConfig: any;
    users: User[];
    groups: Group[];
    committes: any;
    errorMessage: string;

    // Private
    private _unsubscribeAll: Subject<any>;

    /**
     * Constructor
     *
     * @param {FuseConfigService} _fuseConfigService
     * @param {FuseNavigationService} _fuseNavigationService
     * @param {FuseSidebarService} _fuseSidebarService
     * @param {FuseSplashScreenService} _fuseSplashScreenService
     * @param {FuseTranslationLoaderService} _fuseTranslationLoaderService
     * @param {TranslateService} _translateService
     */
    constructor(
        private _fuseConfigService: FuseConfigService,
        private _fuseNavigationService: FuseNavigationService,
        private _fuseSidebarService: FuseSidebarService,
        private _fuseSplashScreenService: FuseSplashScreenService,
        private _fuseTranslationLoaderService: FuseTranslationLoaderService,
        private _translateService: TranslateService,
        public userService: UserService,
        private committeeService: CommitteeService,
        private storageService: StorageService
    )
    {
        // Get default navigation
        this.navigation = navigation;

        // Register the navigation to the service
        this._fuseNavigationService.register('main', this.navigation);

        // Set the main navigation as our current navigation
        this._fuseNavigationService.setCurrentNavigation('main');

        // Add languages
        this._translateService.addLangs(['en', 'ar']);

        // Set the default language
        this._translateService.setDefaultLang('ar');
        document.getElementById('generalHTML').lang = 'ar';
        

        // Set the navigation translations
        this._fuseTranslationLoaderService.loadTranslations(navigationEnglish, navigationArabic);

        // Use a language
        this._translateService.use('ar');

        // Set the private defaults
        this._unsubscribeAll = new Subject();
    }

    // -----------------------------------------------------------------------------------------------------
    // @ Lifecycle hooks
    // -----------------------------------------------------------------------------------------------------

    /**
     * On init
     */
    ngOnInit(): void
    {
        // Subscribe to config changes
        this._fuseConfigService.config
            .pipe(takeUntil(this._unsubscribeAll))
            .subscribe((config) => {
                this.fuseConfig = config;
            });
            this.getGroups();
            this.getUsers();
            this.getCommittes();
    }

    /**
     * On destroy
     */
    ngOnDestroy(): void
    {
        // Unsubscribe from all subscriptions
        this._unsubscribeAll.next();
        this._unsubscribeAll.complete();
    }

    // -----------------------------------------------------------------------------------------------------
    // @ Public methods
    // -----------------------------------------------------------------------------------------------------

    /**
     * Toggle sidebar open
     *
     * @param key
     */
    toggleSidebarOpen(key): void
    {
        this._fuseSidebarService.getSidebar(key).toggleOpen();
    }

    // Load data
    getGroups(): void {
        this.userService.getGroups()
            .subscribe(group => {
                this.groups = group;
                console.log(JSON.stringify(this.groups));
                this.storageService.saveInLocal('groupsList', JSON.stringify(this.groups));
            },
            error => this.errorMessage = <any>error);
    }

    getUsers(): void {
        this.userService.getUsers()
            .subscribe(user => {
                this.users = user;
                console.log(JSON.stringify(this.users));
                this.storageService.saveInLocal('usersList', JSON.stringify(this.users));
            },
            error => this.errorMessage = <any>error);
    }

    getCommittes(): void {
        this.committeeService.getAllCommitteeList()
            .subscribe(comm => {
                this.committes = comm;
                this.storageService.saveInLocal('committesList', JSON.stringify(this.committes));
            },
            error => this.errorMessage = <any>error);
    }
}
