import { Component, OnInit } from '@angular/core';
import { FormGroup,FormControl, Validators } from '@angular/forms';


@Component({
  selector: 'app-member-wishes',
  templateUrl: './member-wishes.component.html',
  styleUrls: ['./member-wishes.component.scss']
})
export class MemberWishesComponent implements OnInit {

 memberWishFormGroup : FormGroup ;
 firstWish : FormControl;
 secondWish : FormControl;
 thirdWish : FormControl;

  wishes = [
    {value: 'health-0', viewValue: 'Health'},
    {value: 'security-1', viewValue: 'Security'},
    {value: 'defense-2', viewValue: 'Defense'}
  ];
  
  constructor() { }

  createFormControls()
  {
    this.firstWish = new FormControl("",Validators.required);
    this.secondWish = new FormControl("",Validators.required);
    this.thirdWish = new FormControl("",Validators.required);
  }

  createFrom()
  {
    this.memberWishFormGroup = new FormGroup(
        {
              firstWish : this.firstWish ,
              secondWish : this.secondWish,
              thirdWish : this.thirdWish
          });
  }


  ngOnInit() {
    this.createFormControls();
    this.createFrom();
  }


  getErrorMessage() {
    return  this.firstWish.hasError('required') ? 'You must enter a value' :
            this.secondWish.hasError('required') ? 'You must enter a value' :
            this.secondWish.hasError('required') ? 'You must enter a value' :
            '';
  }

  //Form Submit Function
  onFormSubmit()
{}

}
