import { Component, OnInit } from '@angular/core';
import { PermissionService } from '../services/permission.service';
import { Group } from '../models/group.model';
import { User } from '../models/user.model';
import { AssignParam } from '../models/assign-user-group-param.model';

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

    constructor(private permissionService: PermissionService) { }

    ngOnInit(): void {
        this.getGroups();
        this.getUsers();
    }


    getGroups(): void {
        this.permissionService.getGroups()
            .subscribe(group => {
                this.groups = group;
                console.log(JSON.stringify(this.groups));
                //this.StorageService.saveInLocal('group', JSON.stringify(this.groups));
            },
            error => this.errorMessage = <any>error);
    }

    getUsers(): void {
        this.permissionService.getUsers()
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
        this.permissionService.assignUserToGroup(this.assignParam)
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
