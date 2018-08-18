import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material';
import { StorageService } from '../services/storage.service';
import { Committee } from '../models/committee.model';
import { NominationService } from '../services/nomination.service';
import { CommitteeService } from '../services/committee.service';
import { UserWish } from 'app/models/user-wish.model';
import { User } from 'app/models/user.model';
import { MemberExperience } from 'app/models/memberExperience';
import { ExperienceList } from '../models/experienceList';


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
 notesControl : FormControl;
 memberNotes : string;

 wishes: Committee[] = [];
  wishes2: Committee[] = [];
  wishes3: Committee[] = [];
  wish1: Committee;
  wish2: Committee;
  wish3: Committee;
  user: User;
  formNotValid:boolean = false;
  memberHasNOExp:boolean = false;
    
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
    this.notesControl = new FormControl('');
  }
  createFrom(): void {
    this.memberWishFormGroup = new FormGroup({
        firstWish: this.firstWish,
        secondWish: this.secondWish,
        thirdWish: this.thirdWish,
        notesControl:this.notesControl
    });
  }

  ngOnInit(): void {
    this.user = JSON.parse(this.storageService.getFromLocal('user'));
    this.createFormControls();
    this.createFrom();
  }

  // Form Submit Function
  onFormSubmit(): void {
    if(this.user.memberExperiences != null &&this.user.memberExperiences.length === 0)
    {
      this.memberHasNOExp = true;
      this.openSnackBar('This Member has no assigned Experiences or Specializations','Close');
      
    }else
    {
      if(this.validateUserWishWithExperience())
      {
        let userWishes: UserWish[] = [];
        userWishes.push(new UserWish(this.user, this.wish1, 1,this.memberNotes));
        userWishes.push(new UserWish(this.user, this.wish2, 2,this.memberNotes));
        userWishes.push(new UserWish(this.user, this.wish3, 3,this.memberNotes));
        
      this.nominateServiceObj.assignUserWishesService(userWishes).subscribe((data:any) => { 
        this.openSnackBar('Added Successfully','Close');
        this.formNotValid = false;
      },
      error => this.openSnackBar('Error Happened while Adding','Close')
        );
        this.populateCommittes();    
      }
      else{
        this.formNotValid = true;
        this.openSnackBar('Member Experience Must Match with At least one Committee Experience','Close');
      }
    }
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
    }
  }

  onWishTwo(changeEvent) {
    if (changeEvent) {
      this.wishes3 = this.wishes3.filter(wish => wish.id !== this.wish2.id);
    }
  }

  onWishThree(changeEvent) { }

  validateUserWishWithExperience():boolean
  {
    let isValid = false;
    //get User Experience
    let memberExperience:MemberExperience[] = [];
    memberExperience = this.user.memberExperiences;

    //get all wished committees experiences 
    let committeeExpList:ExperienceList = new ExperienceList();

    this.wish1.committeeExperiences.map(ex => committeeExpList.add(ex.experience));
    this.wish2.committeeExperiences.map(ex => committeeExpList.add(ex.experience));
    this.wish3.committeeExperiences.map(ex => committeeExpList.add(ex.experience));
    
    //compare member experiences with committee experiences to find at least one matching result
    let found = memberExperience.map(memEx =>  committeeExpList.exists(memEx.experience));

    if(found.find(f => f === true))
      isValid = true;

    return isValid;
  }
}
