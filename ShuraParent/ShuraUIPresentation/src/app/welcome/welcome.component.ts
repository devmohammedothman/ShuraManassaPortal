import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { LocalStorage } from '@ngx-pwa/local-storage';
import { StorageService } from '../services/storage.service';
import { fuseAnimations } from '@fuse/animations';
import { User } from '../models/user.model';

@Component({
    selector: 'welcome',
    templateUrl: './welcome.component.html',
    styleUrls: ['./welcome.component.scss'],
    encapsulation: ViewEncapsulation.None,
    animations: fuseAnimations
})
export class WelcomeComponent implements OnInit {


    token: string;
    user: User;
    group: any;
    groupstr; string;
    userStr: string;
    constructor() {
      //private storageService: StorageService
        /*this.token = this.StorageService.getStorageListValue('token');
        console.log('key:' + this.token );
        alert('key:' + this.token);*/
    }

    ngOnInit() {
        //debugger;
        // this.token = this.storageService.getFromLocal('token');
        // this.user = JSON.parse(this.storageService.getFromLocal('user'));
        // this.group = JSON.parse(this.storageService.getFromLocal('group'));
        // this.userStr = this.storageService.getFromLocal('user');
        // this.groupstr = this.storageService.getFromLocal('group');
        // console.log('key:' + this.token);
        // console.log('user:' + this.userStr);
        // console.log('group:' + this.groupstr);
        // console.log('username:' + this.user.username);
    }

}
