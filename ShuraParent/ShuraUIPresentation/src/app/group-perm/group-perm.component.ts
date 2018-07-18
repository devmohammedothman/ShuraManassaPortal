import { Component, OnInit } from '@angular/core';
import { Group } from '../models/group.model';
import { Permission } from '../models/permission.model';
import { PermissionService } from '../services/permission.service';

@Component({
  selector: 'app-group-perm',
  templateUrl: './group-perm.component.html',
  styleUrls: ['./group-perm.component.scss']
})
export class GroupPermComponent implements OnInit {

  checked = false;
  group: Group[];
    groups: any;
    permessions: any;
    permission: Permission;
    errorMessage: string;
    groupname: string;
    selectedPerm: string;
  constructor(private permissionService: PermissionService) { }

  ngOnInit() {
    this.getGroups();
    this.getPermissionsByMenu();
  }

  onGroupSelect(changeEvent) {
    if (changeEvent) {
        console.log('Group Selected is: ' + this.groupname);
    }
}

onCheckSelect(changeEvent) {
  if (changeEvent) {
      console.log('Perm Selected is: ' + this.selectedPerm);
  }
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

getPermissionsByMenu(): void {
  this.permissionService.getPermissionsByMenu('5')
        .subscribe(permession => {
            this.permessions = permession;
            console.log(JSON.stringify(this.permessions));
            //this.StorageService.saveInLocal('group', JSON.stringify(this.groups));
        },
        error => this.errorMessage = <any>error);
}

}
