import { Component, OnInit, ViewChild, Input, Output, EventEmitter } from '@angular/core';
import { MatTableDataSource, MatPaginator, MatSort, MatSnackBar } from '@angular/material';
import { Committee } from 'app/models/committee.model';
import { StorageService } from 'app/services/storage.service';
import { CommitteMember } from 'app/models/commitee-member.model';
import { NominationService } from 'app/services/nomination.service';

@Component({
  selector: 'app-edit-member-wishes',
  templateUrl: './edit-member-wishes.component.html',
  styleUrls: ['./edit-member-wishes.component.scss']
})
export class EditMemberWishesComponent implements OnInit {

  @Input() committeeList: Committee[] = [];
  @Output() committeeListChange = new EventEmitter<Committee[]>();


  currentCommitteeMemberList: CommitteMember[] = [];
  committeeMemberTableCoulmns = ['id', 'memberName', 'currentCommittee', 'wishedCommittee', 'edit'];
  dataSource: MatTableDataSource<CommitteMember>;
  isEditable: boolean = false;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;



  constructor(private nominationService: NominationService, private storageService: StorageService,
    public snackBar: MatSnackBar) {
    this.dataSource = new MatTableDataSource(this.currentCommitteeMemberList);
    this.populateCommitteeList();
    this.populateCommitteeMemberList();
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

  populateCommitteeList() {
    //get List of Committee from storage service
    for (let results of JSON.parse(this.storageService.getFromLocal('committesList'))) {
      this.committeeList.push(results);
    }
  }

  populateCommitteeMemberList() {
    //call service of get current Committee Member List
    this.nominationService.getCurrentCommitteeMembers().subscribe(
      comMemberItem => {
        console.log('List : '+JSON.stringify(comMemberItem));
        this.dataSource.data = comMemberItem;
      }
    );
  }

  updateRow(row) {
    let updatedValue: CommitteMember;
    updatedValue = row;
    console.log('Row clicked: ', updatedValue);
    this.nominationService.updateMemberAssignedCommittee(updatedValue).subscribe((data: any) => {
      this.openSnackBar('Added Successfully', 'Close');
      this.populateCommitteeMemberList();
    },
      error => this.openSnackBar('Error Happened while Adding', 'Close')
    );
    this.isEditable = false;
    

  }

  enableEditMode() {
    this.isEditable = true;
  }

  // deleteRow(row)
  // {}

  openSnackBar(message: string, action: string): any {
    this.snackBar.open(message, action, {
      duration: 5000,
      horizontalPosition: 'center',
      verticalPosition: 'top'
    });
  }

}
