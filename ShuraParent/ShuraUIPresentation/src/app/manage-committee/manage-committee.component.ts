import { Component, OnInit, ViewChild } from '@angular/core';
import {MatPaginator, MatSort, MatTableDataSource,MatSnackBar} from '@angular/material';
import { Committee } from '../models/committee.model';
import { CommitteeService } from '../services/committee.service';
import { AddEditCommitteeComponent } from './add-edit-committee/add-edit-committee.component';

@Component({
  selector: 'app-manage-committee',
  templateUrl: './manage-committee.component.html',
  styleUrls: ['./manage-committee.component.scss']
})
export class ManageCommitteeComponent implements OnInit {

  committeeColumns = ['id', 'name','edit'];
  dataSource: MatTableDataSource<Committee>;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

   committeeList : Committee [] ;
  constructor( private commService :CommitteeService, public addEditComm:AddEditCommitteeComponent,
    public snackBar: MatSnackBar ) { 
    this.addEditComm.dialog.afterAllClosed.subscribe(()=> {
      this.populateCommitteeList();
      this.openSnackBar('Added Successfully','Close');
    });
    this.populateCommitteeList();
  }

  ngOnInit() {
    console.log('init committee list component');
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  applyFilter(filterValue: string) {
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // Datasource defaults to lowercase matches
    this.dataSource.filter = filterValue;
  }

  populateCommitteeList() 
  {
    console.log("call get all committee list service");
      this.commService.getAllCommitteeList().subscribe(committeeItem => {
        this.committeeList = committeeItem;
        this.dataSource.data = this.committeeList;
        console.log(JSON.stringify(this.committeeList));
      });

      // Assign the data to the data source for the table to render
    this.dataSource = new MatTableDataSource(this.committeeList);
    
    }

    openSnackBar(message: string, action: string): any {
      this.snackBar.open(message, action, {
        duration: 5000,
        horizontalPosition: 'center',
        verticalPosition: 'top'
      });
    }

}

