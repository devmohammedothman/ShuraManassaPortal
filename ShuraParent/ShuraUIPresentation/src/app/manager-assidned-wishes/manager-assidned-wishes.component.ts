import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material';
import { Observable } from 'rxjs';
import { startWith, map } from 'rxjs/operators';
import { StorageService } from '../services/storage.service';
import { Committee } from '../models/committee.model';
import { NominationService } from '../services/nomination.service';
import { UserWish } from '../models/user-wish.model';
import { User } from '../models/user.model';

@Component({
  selector: 'app-manager-assidned-wishes',
  templateUrl: './manager-assidned-wishes.component.html',
  styleUrls: ['./manager-assidned-wishes.component.scss']
})
export class ManagerAssidnedWishesComponent implements OnInit {

  adminAssignWishesForm: FormGroup;
  username: FormControl;
  firstWish: FormControl;
  secondWish: FormControl;
  thirdWish: FormControl;
  notesControl : FormControl;
  filteredUsers: Observable<string[]>;

  //  users = [
  //   'Abdullah Abolwafa',
  //   'Ahmad Saa\'d',
  //   'Mohammad Othman',
  //   'Mahmoud Hejazy',
  //   'Ahmad Majdy',
  //   'Mohammad Farraj',
  //   'Esam Tqreq',
  //   'Mohammad Ali'
  // ];

  users: string[] = [];

  // wishes = [
  //   {value: 'health-0', viewValue: 'Health'},
  //   {value: 'security-1', viewValue: 'Security'},
  //   {value: 'defense-2', viewValue: 'Defense'}
  // ];
  wishes: Committee[] = [];
  wishes2: Committee[] = [];
  wishes3: Committee[] = [];
  wish1: Committee;
  wish2: Committee;
  wish3: Committee;
  userList: User[];
  user: User;
  memberNotes : string;

  selectedUsername: string;
  constructor(public snackBar: MatSnackBar,
    private storageService: StorageService,
    private nominationService: NominationService) {
    this.populateUserArray();
    this.populateCommittes();
  }

  populateUserArray(): void {
    this.userList = JSON.parse(this.storageService.getFromLocal('usersList'));
    for (let results of this.userList) {
      this.users.push(results.username);
    }
  }

  getSelectedUsername(username: string) {
    this.selectedUsername = username;
    console.log(username);
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
    this.username = new FormControl('', Validators.required);
    this.firstWish = new FormControl('', Validators.required);
    this.secondWish = new FormControl('', Validators.required);
    this.thirdWish = new FormControl('', Validators.required);
    this.notesControl = new FormControl('');
  }
  createFrom(): void {
    this.adminAssignWishesForm = new FormGroup({
      username: this.username,
      firstWish: this.firstWish,
      secondWish: this.secondWish,
      thirdWish: this.thirdWish,
      notesControl:this.notesControl
    });
  }
  getErrorMessage(): string {
    return this.username.hasError('required') ? 'You must enter a value' :
      this.firstWish.hasError('required') ? 'You must enter a value' :
        this.secondWish.hasError('required') ? 'You must enter a value' :
          this.secondWish.hasError('required') ? 'You must enter a value' :
            '';
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
    this.assignWishes();
  }

  onWishOne(changeEvent) {
    if (changeEvent) {
      this.wishes2 = this.wishes2.filter(wish => wish.id !== this.wish1.id);
      this.wishes3 = this.wishes3.filter(wish => wish.id !== this.wish1.id);
      console.log('Group Selected is: ' + this.wish1.nameEn);
    }
  }

  onWishTwo(changeEvent) {
    if (changeEvent) {
      this.wishes3 = this.wishes3.filter(wish => wish.id !== this.wish2.id);
      console.log('Group Selected is: ' + this.wish2.nameEn);
    }
  }

  onWishThree(changeEvent) {
    if (changeEvent) {
      console.log('Group Selected is: ' + this.wish3.nameEn);
    }
  }

  assignWishes(): void {
    let userWishes: UserWish[] = [];
    let itemIndex = this.userList.findIndex(item => item.username == this.selectedUsername);
    //debugger;
    this.user = this.userList[itemIndex];
    console.log('fetchedUser : '+ this.user.username)
    userWishes.push(new UserWish(this.user, this.wish1, 1,this.memberNotes));
    userWishes.push(new UserWish(this.user, this.wish2, 2,this.memberNotes));
    userWishes.push(new UserWish(this.user, this.wish3, 3,this.memberNotes));
    this.nominationService.managerAssignWish(userWishes)
      .subscribe(result => {
        alert(result);
      },
        // error => this.errorMessage = <any>error);
        error => alert("There is an error "));
  }

}
