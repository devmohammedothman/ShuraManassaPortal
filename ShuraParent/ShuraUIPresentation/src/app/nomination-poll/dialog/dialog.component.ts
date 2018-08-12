import { Component, OnInit, ViewChild, AfterViewInit } from '@angular/core';
import { MatPaginator, MatSort, MatTableDataSource, MatDialog } from '@angular/material';
import { NominationService } from '../../services/nomination.service';
import { CommitteMember } from '../../models/commitee-member.model';

@Component({
  selector: 'app-dialog',
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.scss']
})
export class DialogComponent implements OnInit, AfterViewInit {

  committeeMembers: CommitteMember[];
  errorMessage: string;
  displayedColumns = ['Username', 'WishOrder'];
  dataSource: MatTableDataSource<CommitteMember>;
  //  @ViewChild(MatPaginator) paginator: MatPaginator;
  //  @ViewChild(MatSort) sort: MatSort;

  constructor(public dialog: MatDialog,
    public nominationService: NominationService) {
    this.dataSource = new MatTableDataSource(this.committeeMembers);
  }

  ngOnInit() {
    //  this.dataSource.paginator = this.paginator;
    //  this.dataSource.sort = this.sort;
  }

  ngAfterViewInit(){
    this.dataSource.data = this.committeeMembers;
    // this.dataSource.paginator = this.paginator;
    // this.dataSource.sort = this.sort;
  }

  public openDialog(committeeId: number): void {
    console.log('commId is: ' + committeeId);
    this.getCommitteeMembers(committeeId);
    this.dialog.open(DialogComponent);
  }

  getCommitteeMembers(committeeId: number): void {
    this.nominationService.getCommitteeMembers(committeeId)
      .subscribe(comm => {
        this.committeeMembers = comm;
        //console.log(JSON.stringify(this.committeeMembers));
        this.dataSource.data = this.committeeMembers;
        //console.log(JSON.stringify(this.dataSource.data));
      },
        error => this.errorMessage = <any>error);
  }

}
