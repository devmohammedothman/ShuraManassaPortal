import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material';
import { StorageService } from '../services/storage.service';
import { Committee } from '../models/committee.model';
import { NominationService } from '../services/nomination.service';
import { CommitteeService } from '../services/committee.service';
import { MemberAssignedWishes } from 'app/models/member-assigned-wishes';
import { Wish } from '../models/wish.model';
import { UserWish } from 'app/models/user-wish.model';
import { User } from 'app/models/user.model';


@Component({
  selector: 'app-member-wishes',
  templateUrl: './member-wishes.component.html',
  styleUrls: ['./member-wishes.component.scss']
})
export class MemberWishesComponent implements OnInit {

 memberWishFormGroup: FormGroup;
 firstWish: FormControl;
 secondWish: FormControl;
 thirdWish: FormControl;


 wishes: Committee[] = [];
  wishes2: Committee[] = [];
  wishes3: Committee[] = [];
  wish1: Committee;
  wish2: Committee;
  wish3: Committee;
  user: User;
    
  constructor(public snackBar: MatSnackBar,private commServiceObj:CommitteeService,private nominateServiceObj:NominationService,
     private storageService: StorageService) {

    this.populateCommittes();    
   }

   populateCommittes(): void {
    this.wishes = [];
    this.wishes2 = [];
    this.wishes3 = [];
    for (let results of JSON.parse(this.storageService.getFromLocal('committesList'))) {
      this.wishes.push(results);
      this.wishes2.push(results);
      this.wishes3.push(results);
    }
  }

  createFormControls(): void {
    this.firstWish = new FormControl('', Validators.required);
    this.secondWish = new FormControl('', Validators.required);
    this.thirdWish = new FormControl('', Validators.required);
  }
  createFrom(): void {
    this.memberWishFormGroup = new FormGroup({
        firstWish: this.firstWish,
        secondWish: this.secondWish,
        thirdWish: this.thirdWish
    });
  }

  ngOnInit(): void {
    this.createFormControls();
    this.createFrom();
  }

  // Form Submit Function
  onFormSubmit(): void {

    debugger;
    this.user = JSON.parse(this.storageService.getFromLocal('user'));
    

    let userWishes: UserWish[] = [];
    userWishes.push(new UserWish(this.user, this.wish1, 1));
    userWishes.push(new UserWish(this.user, this.wish2, 2));
    userWishes.push(new UserWish(this.user, this.wish3, 3));
    
   this.nominateServiceObj.assignUserWishesService(userWishes).subscribe((data:any) => { 
     this.openSnackBar('Added Successfully','Close');
   },
   error => this.openSnackBar('Error Happened while Adding','Close')
    );
    this.memberWishFormGroup.reset;
  }

  openSnackBar(message: string, action: string): any {
    this.snackBar.open(message, action, {
      duration: 5000,
      horizontalPosition: 'center',
      verticalPosition: 'top'
    });
  }

  onWishOne(changeEvent) {
    if (changeEvent) {
      
      this.wishes2 = this.wishes2.filter(wish => wish.id !== this.wish1.id);
      this.wishes3 = this.wishes3.filter(wish => wish.id !== this.wish1.id);
      //debugger;
      //  const firstwishSentObj = new Wish();
      // firstwishSentObj.wishedCommitee = this.wish1;
      // firstwishSentObj.wishOrder = 1;
      // this.userWishesObject.wishesList.push(firstwishSentObj);
            
    }
  }

  onWishTwo(changeEvent) {
    if (changeEvent) {
      this.wishes3 = this.wishes3.filter(wish => wish.id !== this.wish2.id);
      

      // const secondwishSentObj = new Wish();
      // secondwishSentObj.wishedCommitee = this.wish2;
      // secondwishSentObj.wishOrder = 2;
      // this.userWishesObject.wishesList.push(secondwishSentObj);

    }
  }

  onWishThree(changeEvent) {
    // if (changeEvent) {
    //   const thirdwishSentObj = new Wish();
    //   thirdwishSentObj.wishedCommitee = this.wish3;
    //   thirdwishSentObj.wishOrder = 3;
    //   this.userWishesObject.wishesList.push(thirdwishSentObj);
    // }
  }
}
