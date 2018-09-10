import { Component, OnInit, ViewChild } from '@angular/core';
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';
import { Committee } from '../models/committee.model';
import { CommitteeService } from '../services/committee.service';
import { AddEditCommitteeComponent } from './add-edit-committee/add-edit-committee.component';

@Component({
  selector: 'app-manage-committee',
  templateUrl: './manage-committee.component.html',
  styleUrls: ['./manage-committee.component.scss']
})
export class ManageCommitteeComponent implements OnInit {

  committeeColumns = ['id', 'name', 'edit'];
  dataSource: MatTableDataSource<Committee>;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  public committeeList: Committee [] ;
  public errorMessage;

  constructor( private commService: CommitteeService, public addEditComm: AddEditCommitteeComponent ) { 

   this.populateCommitteeList();
  }

  ngOnInit(): void {
    console.log('init committee list component');
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  applyFilter(filterValue: string): void {
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // Datasource defaults to lowercase matches
    this.dataSource.filter = filterValue;
  }

  populateCommitteeList(): void {
    console.log('call get all committee list service');
      this.commService.getAllCommitteeList().subscribe(committeeItem => {
        this.committeeList = committeeItem;
        this.dataSource.data = this.committeeList;
        console.log(JSON.stringify(this.committeeList));
      },
      error => this.errorMessage = error
    );
      
      // Assign the data to the data source for the table to render
      this.dataSource = new MatTableDataSource(this.committeeList);
    }

}

