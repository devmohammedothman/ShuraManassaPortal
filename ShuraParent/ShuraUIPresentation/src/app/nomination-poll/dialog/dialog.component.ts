import { Component, OnInit } from '@angular/core';
import { MatTableDataSource, MatDialog } from '@angular/material';
import { NominationService } from '../../services/nomination.service';
import { CommitteMember } from '../../models/commitee-member.model';
import { StorageService } from '../../services/storage.service';


@Component({
  selector: 'app-dialog',
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.scss']
})
export class DialogComponent implements OnInit {

  committeeMembers: CommitteMember[];
  errorMessage: string;
  displayedColumns = ['Username', 'WishOrder'];
  dataSource: MatTableDataSource<CommitteMember>;
  //  @ViewChild(MatPaginator) paginator: MatPaginator;
  //  @ViewChild(MatSort) sort: MatSort;

  constructor(public dialog: MatDialog,
    public storageService: StorageService) {
    //this.committeeMembers = JSON.parse(this.storageService.getFromLocal('dlgMember'));
    this.dataSource = new MatTableDataSource(this.committeeMembers);
    //this.dataSource.data = this.committeeMembers;
  }

  ngOnInit() {
    this.committeeMembers = JSON.parse(this.storageService.getFromLocal('dlgMember'));
    this.dataSource.data = this.committeeMembers;
  }

  public openDialog(): void {
    this.dialog.open(DialogComponent);
  }

}
