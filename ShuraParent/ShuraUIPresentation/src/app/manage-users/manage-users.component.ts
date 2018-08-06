import { Component, OnInit, ViewChild } from '@angular/core';
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';
import { AddEditUsersComponent } from './add-edit-users/add-edit-users.component';
import { User } from '../models/user.model';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-manage-users',
  templateUrl: './manage-users.component.html',
  styleUrls: ['./manage-users.component.scss']
})
export class ManageUsersComponent implements OnInit {

  displayedColumns = ['username', 'email', 'edit'];
  dataSource: MatTableDataSource<User>;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  users: User[];
  errorMessage: string;

  constructor(private addEditUsersComponent: AddEditUsersComponent,
  private userService: UserService) { 
    addEditUsersComponent.dialog.afterAllClosed
    .subscribe(() => {
    // update a variable or call a function when the dialog closes
      this.getUsers();
    }
  );
    this.getUsers();
    // Assign the data to the data source for the table to render
    this.dataSource = new MatTableDataSource(this.users);
  }

  ngOnInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  applyFilter(filterValue: string) {
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // Datasource defaults to lowercase matches
    this.dataSource.filter = filterValue;
  }

  getUsers(): void {
    this.userService.getUsers()
        .subscribe(user => {
            this.users = user;
            this.dataSource.data = this.users;
            console.log(JSON.stringify(this.users));
        },
        error => this.errorMessage = <any>error);
}

}


