import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-add-edit-committee',
  templateUrl: './add-edit-committee.component.html',
  styleUrls: ['./add-edit-committee.component.scss']
})
export class AddEditCommitteeComponent implements OnInit {

  constructor(public dialog: MatDialog) { }

  ngOnInit() {
  }

  public openDialog():void
  {
    this.dialog.open(AddEditCommitteeComponent);
  }

}
