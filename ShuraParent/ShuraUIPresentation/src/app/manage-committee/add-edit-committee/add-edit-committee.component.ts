import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { NgForm } from '@angular/forms';
import { Committee } from '../../models/committee.model';
import { CommitteeService } from '../../services/committee.service';


@Component({
  selector: 'app-add-edit-committee',
  templateUrl: './add-edit-committee.component.html',
  styleUrls: ['./add-edit-committee.component.scss']
})
export class AddEditCommitteeComponent implements OnInit {

commObject:Committee = new Committee(null);


  constructor(public dialog: MatDialog, private commService : CommitteeService) { }

  ngOnInit() {
  }

  public openDialog():void
  {
    this.dialog.open(AddEditCommitteeComponent);
  }

  OnSubmit(form? :NgForm){
    this.commService.addCommittee(form.value).subscribe((data:any) => {
      console.log(data);
      // if (data != null) {}
        
    });

      this.dialog.closeAll();
  }

}
