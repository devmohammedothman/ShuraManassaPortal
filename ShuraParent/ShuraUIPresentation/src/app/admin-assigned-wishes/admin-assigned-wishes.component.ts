import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { map, startWith } from 'rxjs/operators';

@Component({
  selector: 'app-admin-assigned-wishes',
  templateUrl: './admin-assigned-wishes.component.html',
  styleUrls: ['./admin-assigned-wishes.component.scss']
})
export class AdminAssignedWishesComponent implements OnInit {
  
  adminAssignWishesForm = FormGroup;
  username: FormControl = new FormControl('', [Validators.required]);
  wish1: FormControl = new FormControl('', [Validators.required]);
  wish2: FormControl = new FormControl('', [Validators.required]);
  wish3: FormControl = new FormControl('', [Validators.required]);
  
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

  filteredUsers: Observable<string[]>;
  constructor() { }

  ngOnInit() {
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

  getErrorMessage() {
    return  this.username.hasError('required') ? 'You must enter a value' :
            this.wish1.hasError('required') ? 'You must enter a value' :
            this.wish2.hasError('required') ? 'You must enter a value' :
            this.wish3.hasError('required') ? 'You must enter a value' :
            '';
  }

}
