import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Committee } from '../models/committee.model';
import { CommitteeService } from '../services/committee.service';
import { NominationService } from '../services/nomination.service';
import { MemberAssignedWishes } from 'app/models/member-assigned-wishes';


@Component({
  selector: 'app-member-wishes',
  templateUrl: './member-wishes.component.html',
  styleUrls: ['./member-wishes.component.scss']
})
export class MemberWishesComponent implements OnInit {

  memberAssignWishesForm = FormGroup;
  username: FormControl = new FormControl('', [Validators.required]);
  wish1: FormControl = new FormControl('', [Validators.required]);
  wish2: FormControl = new FormControl('', [Validators.required]);
  wish3: FormControl = new FormControl('', [Validators.required]);
  
  memberWish:MemberAssignedWishes = new MemberAssignedWishes();
  wishes : Committee [];
  
  constructor(private commService:CommitteeService, private nominateService:NominationService) { }

  ngOnInit() {
   this.populateWishesList();
  }

  populateWishesList() 
  {
      this.commService.getAllCommitteeList().subscribe(committeeItem => {
        this.wishes = committeeItem;
      });
    }

  getErrorMessage() {
    return  this.wish1.hasError('required') ? 'You must enter a value' :
            this.wish2.hasError('required') ? 'You must enter a value' :
            this.wish3.hasError('required') ? 'You must enter a value' :
            '';
  }
  assignUserWishes()
  {
    console.log('button click assign user wishes');
    // this.memberWish.userid = 52;
    // this.memberWish.committeeid = this.wish1.value;
    // this.memberWish.wishOrder = 1;
    this.nominateService.assignUserWishesService();
  }

}
