import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';

@Component({
  selector: 'app-add-edit-users',
  templateUrl: './add-edit-users.component.html',
  styleUrls: ['./add-edit-users.component.scss']
})
export class AddEditUsersComponent implements OnInit {

  constructor(public dialog: MatDialog) { }

  public openDialog(): void {
    this.dialog.open(addEditUsersForm);
  }

  ngOnInit() {
  }

}


@Component({
  selector: 'add-edit-users-form',
  templateUrl: 'add-edit-users-form.html',
})
export class addEditUsersForm { }
