import { Component, OnInit, Injectable } from '@angular/core';
import { MatDialog } from '@angular/material';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserService } from '../../services/user.service';
import { Group } from '../../models/group.model';

import { takeUntil } from 'rxjs/operators';
import { Subject } from 'rxjs';
import { RegisterParam } from '../../models/register.model';

@Component({
  selector: 'app-add-edit-users',
  templateUrl: './add-edit-users.component.html',
  styleUrls: ['./add-edit-users.component.scss']
})
export class AddEditUsersComponent implements OnInit {

  group: Group[];
  groups: any;
  errorMessage: string;
  groupname: string;
  private _unsubscribeAll: Subject<any>;
  userForm: FormGroup;
  userFormErrors: any;
  registerParam = new RegisterParam();

  constructor(public dialog: MatDialog,
    private userService: UserService,
    private _formBuilder: FormBuilder) {
    console.log('Intialize');
    // Set the defaults
    this.userFormErrors = {
      email: {},
      password: {},
      username: {}
    };

    // Set the private defaults
    this._unsubscribeAll = new Subject();
  }

  public openDialog(): void {
    this.dialog.open(AddEditUsersComponent);
  }

  ngOnInit() {
    this.getGroups();
    this.userForm = this._formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required],
      username: ['', Validators.required]
    });

    this.userForm.valueChanges
      .pipe(takeUntil(this._unsubscribeAll))
      .subscribe(() => {
        this.onUserFormValuesChanged();
      });
  }

  onUserFormValuesChanged(): void {
    for (const field in this.userFormErrors) {
      if (!this.userFormErrors.hasOwnProperty(field)) {
        continue;
      }

      // Clear previous errors
      this.userFormErrors[field] = {};

      // Get the control
      const control = this.userForm.get(field);

      if (control && control.dirty && !control.valid) {
        this.userFormErrors[field] = control.errors;
      }
    }
  }

  onGroupSelect(changeEvent) {
    if (changeEvent) {
      console.log('Group Selected is: ' + this.groupname);
      this.registerParam.groupName = this.groupname;
    }
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

  register(): void {
    this.userService.register(this.registerParam)
        .subscribe(user => {
                let other = []; // your other array...
                user.groups.map(item => {
                    return {
                        group: item.nameEn
                    }
                }).forEach(item => other.push(item));
                this.dialog.closeAll();
                alert('Done!!');
        },
        error => this.errorMessage = <any>error);
}

}


@Component({
  selector: 'add-edit-users-form',
  templateUrl: 'add-edit-users-form.html',
})
export class addEditUsersForm {
  foods = [
    { value: 'steak-0', viewValue: 'Steak' },
    { value: 'pizza-1', viewValue: 'Pizza' },
    { value: 'tacos-2', viewValue: 'Tacos' }
  ];
}
