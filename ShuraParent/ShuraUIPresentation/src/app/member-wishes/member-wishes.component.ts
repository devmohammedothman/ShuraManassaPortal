import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material';


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

  wishes = [
    {value: 'health-0', viewValue: 'Health'},
    {value: 'security-1', viewValue: 'Security'},
    {value: 'defense-2', viewValue: 'Defense'}
  ];
  
  constructor(public snackBar: MatSnackBar) { }

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
  getErrorMessage(): string {
    return  this.firstWish.hasError('required') ? 'You must enter a value' :
            this.secondWish.hasError('required') ? 'You must enter a value' :
            this.secondWish.hasError('required') ? 'You must enter a value' :
            '';
  }


  ngOnInit(): void {
    this.createFormControls();
    this.createFrom();
  }

  // Form Submit Function
  onFormSubmit(): void {
  }

  openSnackBar(message: string, action: string): any {
    this.snackBar.open(message, action, {
      duration: 5000,
      horizontalPosition: 'center',
      verticalPosition: 'top'
    });
  }
}
