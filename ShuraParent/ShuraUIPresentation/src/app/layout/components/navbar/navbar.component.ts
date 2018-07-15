import { Component, Input, OnDestroy, OnInit, ViewChild, ViewEncapsulation } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';
import { Subject } from 'rxjs';
import { filter, takeUntil } from 'rxjs/operators';

import { FuseNavigationService } from '@fuse/components/navigation/navigation.service';
import { FusePerfectScrollbarDirective } from '@fuse/directives/fuse-perfect-scrollbar/fuse-perfect-scrollbar.directive';
import { FuseSidebarService } from '@fuse/components/sidebar/sidebar.service';

import { StorageService } from 'app/services/storage.service';
import { User } from 'app/models/user.model';
import { userNavigation } from 'app/navigation/user-navigation';
import { navigation } from 'app/navigation/navigation';

@Component({
    selector: 'navbar',
    templateUrl: './navbar.component.html',
    styleUrls: ['./navbar.component.scss'],
    encapsulation: ViewEncapsulation.None
})
export class NavbarComponent implements OnInit, OnDestroy {
    // Layout
    @Input()
    layout;

    fusePerfectScrollbarUpdateTimeout: any;
    navigation: any;
    user: User;
    group: any;

    // Private
    private _fusePerfectScrollbar: FusePerfectScrollbarDirective;
    private _unsubscribeAll: Subject<any>;

    /**
     * Constructor
     *
     * @param {FuseNavigationService} _fuseNavigationService
     * @param {FuseSidebarService} _fuseSidebarService
     * @param {Router} _router
     */
    constructor(
        private _fuseNavigationService: FuseNavigationService,
        private _fuseSidebarService: FuseSidebarService,
        private _router: Router,
        private storageService: StorageService
    ) {
        // Set the defaults
        this.layout = 'vertical';

        // Set the private defaults
        this._unsubscribeAll = new Subject();
    }

    // -----------------------------------------------------------------------------------------------------
    // @ Accessors
    // -----------------------------------------------------------------------------------------------------

    // Directive
    @ViewChild(FusePerfectScrollbarDirective)
    set directive(theDirective: FusePerfectScrollbarDirective) {
        if (!theDirective) {
            return;
        }

        this._fusePerfectScrollbar = theDirective;

        this._fuseNavigationService.onItemCollapseToggled
            .pipe(takeUntil(this._unsubscribeAll))
            .subscribe(() => {
                this.fusePerfectScrollbarUpdateTimeout = setTimeout(() => {
                    this._fusePerfectScrollbar.update();
                }, 310);
            });
    }

    // -----------------------------------------------------------------------------------------------------
    // @ Lifecycle hooks
    // -----------------------------------------------------------------------------------------------------

    /**
     * On init
     */
    ngOnInit(): void {
        this._router.events
            .pipe(
            filter((event) => event instanceof NavigationEnd),
            takeUntil(this._unsubscribeAll)
            )
            .subscribe(() => {
                if (this._fuseSidebarService.getSidebar('navbar')) {
                    this._fuseSidebarService.getSidebar('navbar').close();
                }
            }
            );

        // Get current navigation
        this.user = JSON.parse(this.storageService.getFromLocal('user'));
        this.group = JSON.parse(this.storageService.getFromLocal('group'));
        // Set the defaults
        if (this.group) {
            for (let obj of this.group) {
                console.log("nav group:", obj);
                for (let key in obj) {
                    //console.log('1name in first check: '+this.group);
                    if (obj[key] === 'ADMIN' || obj[key] === 'ADMIN1') {
                        console.log('nav app com group admin : ' + obj[key]);
                        this.navigation = navigation;
                    } else {
                        console.log('nav com group key : ' + key);
                        console.log('nav com group user : ' + obj[key]);
                        this.navigation = userNavigation;
                    }
                }
            }
        } else {
            console.log('4name in first check: ' + this.group.group);
            this.navigation = navigation;
        }

        /* this._fuseNavigationService.onNavigationChanged
             .pipe(filter(value => value !== null))
             .subscribe(() => {
                 this.navigation = this._fuseNavigationService.getCurrentNavigation();
             });*/
    }

    /**
     * On destroy
     */
    ngOnDestroy(): void {
        if (this.fusePerfectScrollbarUpdateTimeout) {
            clearTimeout(this.fusePerfectScrollbarUpdateTimeout);
        }

        // Unsubscribe from all subscriptions
        this._unsubscribeAll.next();
        this._unsubscribeAll.complete();
    }

    // -----------------------------------------------------------------------------------------------------
    // @ Public methods
    // -----------------------------------------------------------------------------------------------------

    /**
     * Toggle sidebar opened status
     */
    toggleSidebarOpened(): void {
        this._fuseSidebarService.getSidebar('navbar').toggleOpen();
    }

    /**
     * Toggle sidebar folded status
     */
    toggleSidebarFolded(): void {
        this._fuseSidebarService.getSidebar('navbar').toggleFold();
    }
}
