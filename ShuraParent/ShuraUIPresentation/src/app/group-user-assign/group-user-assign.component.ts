import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { Group } from '../models/group.model';
import { User } from '../models/user.model';
import { AssignParam } from '../models/assign-user-group-param.model';
import { StorageService } from '../services/storage.service';

@Component({
    selector: 'app-group-user-assign',
    templateUrl: './group-user-assign.component.html',
    styleUrls: ['./group-user-assign.component.scss']
})
export class GroupUserAssignComponent implements OnInit {

    group: Group[];
    user: User[];
    users: any;
    groups: any;
    assignParam = new AssignParam();
    selectedGroup: any;
    selectedUser: any;
    errorMessage: string;
    localGroup: string;
    show: boolean;

    constructor(private userService: UserService,
        private storageService: StorageService,) { }

    ngOnInit(): void {
        this.getGroups();
        this.getUsers();
        this.localGroup = this.storageService.getFromLocal('currentGroup');
        this.show = (this.localGroup == 'ADMIN');
        console.log('current group obj: '+ this.localGroup);
        console.log('show '+ this.show);
    }


    getGroups(): void {
        this.userService.getGroups()
            .subscribe(group => {
                this.groups = group;
                console.log(JSON.stringify(this.groups));
                //this.StorageService.saveInLocal('group', JSON.stringify(this.groups));
            },
            error => this.errorMessage = <any>error);
    }

    getUsers(): void {
        this.userService.getUsers()
            .subscribe(user => {
                this.users = user;
                console.log(JSON.stringify(this.users));
                //this.StorageService.saveInLocal('group', JSON.stringify(this.groups));
            },
            error => this.errorMessage = <any>error);
    }

    onGroupSelect(changeEvent) {
        if (changeEvent) {
            console.log('Group Selected is: ' + this.assignParam.groupname);
        }
    }

    onUserSelect(changeEvent) {
        if (changeEvent) {
            console.log('User Selected is: ' + this.assignParam.email);
        }
    }
    
    assignUserToGroup(): void {
        this.userService.assignUserToGroup(this.assignParam)
            .subscribe(user => {
                if (user.userId == "-1") {
                    alert("Error");
                } else {
                    alert("Done!!!");
                }
            },
            error => this.errorMessage = <any>error);
    }

}
