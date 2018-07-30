import { Component, OnInit, Injectable } from '@angular/core';
import { MatDialog } from '@angular/material';
import { FormControl, FormGroup, Validators, FormBuilder } from '@angular/forms';
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

  addUser: FormGroup;
  email = new FormControl('', [Validators.required, Validators.email]);
  username = new FormControl('', [Validators.required]);
  password = new FormControl('', [Validators.required]);
  groupselect = new FormControl('', [Validators.required]);
  hide = true;

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

  ngOnInit(): void {
    this.getGroups();

    this.addUser = this._formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required],
      username: ['', Validators.required],
      groupselect: ['', Validators.required]
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

  onGroupSelect(changeEvent): void {
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
        // this.StorageService.saveInLocal('group', JSON.stringify(this.groups));
      },
        error => this.errorMessage = <any>error);
  }

  register(): void {
    this.userService.register(this.registerParam)
        .subscribe(user => {
                const other = []; // your other array...
                user.groups.map(item => {
                    return {
                        group: item.nameEn
                    };
                }).forEach(item => other.push(item));
                this.dialog.closeAll();
                alert('Done!!');
        },
        error => this.errorMessage = <any>error);
}
getErrorMessage(): string {
    return  this.email.hasError('required') ? 'You must enter a value' :
            this.email.hasError('email') ? 'Not a valid email' :
            this.username.hasError('required') ? 'You must enter a value' :
            this.password.hasError('required') ? 'You must enter a value' :
            this.groupselect.hasError('required') ? 'You must enter a value' :
            '';
  }

}


@Component({
  selector: 'add-edit-users-form',
  templateUrl: 'add-edit-users-form.html',
})
export class addEditUsersFormComponent {
  foods = [
    { value: 'steak-0', viewValue: 'Steak' },
    { value: 'pizza-1', viewValue: 'Pizza' },
    { value: 'tacos-2', viewValue: 'Tacos' }
  ];
}
