import { Component, Input, OnInit, ViewEncapsulation } from '@angular/core';
import { Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';

import { FuseNavigationService } from '@fuse/components/navigation/navigation.service';

import { StorageService } from 'app/services/storage.service';
import { User } from 'app/models/user.model';
import { userNavigation } from 'app/navigation/user-navigation';
import { navigation } from 'app/navigation/navigation';

@Component({
    selector     : 'fuse-navigation',
    templateUrl  : './navigation.component.html',
    styleUrls    : ['./navigation.component.scss'],
    encapsulation: ViewEncapsulation.None
})
export class FuseNavigationComponent implements OnInit
{
    @Input()
    layout = 'vertical';

    @Input()
    navigation: any;

    user: User;

    group: any;


    // Private
    private _unsubscribeAll: Subject<any>;

    /**
     * Constructor
     */
    constructor(
        private _fuseNavigationService: FuseNavigationService,
        private storageService: StorageService
    )
    {
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
         // Load the navigation either from the input or from the service
         this.user = JSON.parse(this.storageService.getFromLocal('user'));
         this.group = JSON.parse(this.storageService.getFromLocal('group'));
         // Set the defaults
         if (this.group) {
             for (let obj of this.group) {
                 console.log("group:", obj);
                 for (let key in obj) {
                     //console.log('1name in first check: '+this.group);
                     if (obj[key] === 'ADMIN' || obj[key] === 'ADMIN1') {
                         console.log('navigation com group admin : ' + obj[key]);
                         this.storageService.saveInLocal('currentGroup', obj[key]);
                         this.navigation = navigation;
                     } else {
                         console.log('navigation com group key : ' + key);
                         console.log('navigation com group user : ' + obj[key]);
                         this.storageService.saveInLocal('currentGroup', obj[key]);
                         this.navigation = userNavigation;
                     }
                 }
             }
         } else {
             console.log('4name in first check: ' + this.group.group);
             this.navigation = navigation;
         }
        // Load the navigation either from the input or from the service
        // this.navigation = this.navigation || this._fuseNavigationService.getCurrentNavigation();

        // // Subscribe to the current navigation changes
        // this._fuseNavigationService.onNavigationChanged
        //     .pipe(takeUntil(this._unsubscribeAll))
        //     .subscribe(() => {
        //         this.navigation = this._fuseNavigationService.getCurrentNavigation();
        //     });
    }
}
