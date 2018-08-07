import { Component, OnInit, ViewChild } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material';
import { StorageService } from '../services/storage.service';
import { MatPaginator, MatSort, MatTableDataSource } from '@angular/material';

@Component({
  selector: 'app-nomination-poll',
  templateUrl: './nomination-poll.component.html',
  styleUrls: ['./nomination-poll.component.scss']
})
export class NominationPollComponent implements OnInit {

  nominationPollForm: FormGroup;
  memberCountSelect: FormControl;
  memberCount: number;
  hideTable: boolean = true;

  displayedColumns = ['Committe name', 'First Wish', 'Second wish', 'Third wish',
   'sum', 'Nomination result'];
  dataSource: MatTableDataSource<any>;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(public snackBar: MatSnackBar,
    private storageService: StorageService) { 
      this.dataSource = new MatTableDataSource();
    }

  ngOnInit() {
    this.createFormControls();
    this.createFrom();

    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  createFrom(): void {
    this.nominationPollForm = new FormGroup({
      memberCountSelect: this.memberCountSelect
    });
  }
  
  createFormControls(): void {
    this.memberCountSelect = new FormControl('', Validators.required);
  }

  openSnackBar(message: string, action: string): any {
    this.snackBar.open(message, action, {
      duration: 5000,
      horizontalPosition: 'center',
      verticalPosition: 'top'
    });
  }

  onMemberCountEve(changeEvent) {
    if (changeEvent) {
      this.openSnackBar('Member count is '+ this.memberCount,'Close')
    }
  }

  getDevisionResult(): void{
    this.hideTable = false;
  }

}
