import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material';
import { Observable } from 'rxjs';
import { startWith, map } from 'rxjs/operators';


@Component({
  selector: 'app-admin-assigned-wishes',
  templateUrl: './admin-assigned-wishes.component.html',
  styleUrls: ['./admin-assigned-wishes.component.scss']
})
export class AdminAssignedWishesComponent  implements OnInit {

  adminAssignWishesForm: FormGroup;
  username: FormControl;
  firstWish: FormControl;
  secondWish: FormControl;
  thirdWish: FormControl;

 filteredUsers: Observable<string[]>;

 users = [
  'Abdullah Abolwafa',
  'Ahmad Saa\'d',
  'Mohammad Othman',
  'Mahmoud Hejazy',
  'Ahmad Majdy',
  'Mohammad Farraj',
  'Esam Tqreq',
  'Mohammad Ali'
];

  wishes = [
    {value: 'health-0', viewValue: 'Health'},
    {value: 'security-1', viewValue: 'Security'},
    {value: 'defense-2', viewValue: 'Defense'}
  ];
  
  constructor(public snackBar: MatSnackBar) { }

  createFormControls(): void {
    this.username = new FormControl('', Validators.required);
    this.firstWish = new FormControl('', Validators.required);
    this.secondWish = new FormControl('', Validators.required);
    this.thirdWish = new FormControl('', Validators.required);
  }
  createFrom(): void {
    this.adminAssignWishesForm = new FormGroup({
      username: this.username,
      firstWish: this.firstWish,
      secondWish: this.secondWish,
      thirdWish: this.thirdWish
    });
  }
  
  ngOnInit(): void {
    this.createFormControls();
    this.createFrom();

    this.filteredUsers = this.username.valueChanges
      .pipe(
        startWith(''),
        map(val => this.filter(val))
      );
  }

  filter(val: string): string[] {
    return this.users.filter(user =>
      user.toLowerCase().includes(val.toLowerCase()));
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
