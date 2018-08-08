import { Component, OnInit, ViewChild } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material';
import { StorageService } from '../services/storage.service';
import { MatPaginator, MatSort, MatTableDataSource } from '@angular/material';
import { NominationService } from '../services/nomination.service';
import { NominationPollParam } from '../models/nomination-poll-param.model';
import { PollResult } from '../models/poll-result.model';
import { CommitteMembers } from '../models/committe-members.model';
import { Committee } from '../models/committee.model';
import { Observable } from 'rxjs/Rx';
import { element } from '../../../node_modules/protractor';



@Component({
  selector: 'app-nomination-poll',
  templateUrl: './nomination-poll.component.html',
  styleUrls: ['./nomination-poll.component.scss']
})
export class NominationPollComponent implements OnInit {

  nominationPollForm: FormGroup;
  memberCountSelect: FormControl;
  memberCount: number;
  hideTable: boolean = true;
  pollParam: NominationPollParam;
  poolResult: PollResult[] = [];
  poolResultObj: PollResult;
  pollData: CommitteMembers[];
  committeList: Committee[];
  ssss: CommitteMembers[];
  sumCount: number = 0;

  displayedColumns = ['Committe name', 'First Wish', 'Second wish', 'Third wish',
    'sum', 'Nomination result'];
  dataSource: MatTableDataSource<PollResult>;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(public snackBar: MatSnackBar,
    private storageService: StorageService, private nominationService: NominationService) {
    this.dataSource = new MatTableDataSource(this.poolResult);
  }

  ngOnInit() {
    this.createFormControls();
    this.createFrom();

    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  createFrom(): void {
    this.nominationPollForm = new FormGroup({
      memberCountSelect: this.memberCountSelect
    });
  }

  createFormControls(): void {
    this.memberCountSelect = new FormControl('', Validators.required);
  }

  openSnackBar(message: string, action: string): any {
    this.snackBar.open(message, action, {
      duration: 5000,
      horizontalPosition: 'center',
      verticalPosition: 'top'
    });
  }

  onMemberCountEve(changeEvent) {
    if (changeEvent) {
      this.openSnackBar('Member count is ' + this.memberCount, 'Close')
    }
  }

  getDevisionResult(): void {
    this.hideTable = false;
  }

  runPollProcess(): void {
    this.pollParam = new NominationPollParam('5', '1', false, JSON.parse(this.storageService.getFromLocal('user')));
    this.nominationService.runPollProcess(this.pollParam)
      .subscribe(result => {
        this.pollData = result;
        // console.log('before'+ JSON.stringify(this.pollData));
        this.populateTableData();
      },
        // error => this.errorMessage = <any>error);
        error => alert("There is an error "));
  }

  populateTableData(): void {
    console.log('before source------' + JSON.stringify(this.pollData));
    this.committeList = this.pollData.map(data => new Committee(data.committee));
    let filteredData = [];
    Observable.merge(this.committeList)
      .distinct((x) => x.comm.id)
      .subscribe(y => {
        filteredData.push(y);
      });

      filteredData.forEach(element => {
      console.log('commID ' + element.comm.id);
      this.ssss = (this.pollData.filter(data => data.committee.id === element.comm.id 
        && data.wishOrder === 1));
          this.poolResultObj = new PollResult(this.ssss[0].committee.id, this.ssss[0].committee.nameEn,
            this.ssss[0].committee.nameAr, this.ssss.length, 0 , 0,0); 
            this.poolResult.push(this.poolResultObj);
            this.sumCount = this.ssss.length;
    });
    filteredData.forEach(element => {
      console.log('commID ' + element.comm.id);
      this.ssss = (this.pollData.filter(data => data.committee.id === element.comm.id 
        && data.wishOrder === 2));
        let commId = this.poolResult.find(x => x.committeId == element.comm.id);
        let itemIndex = this.poolResult.findIndex(x => x.committeId == element.comm.id);
        if(!commId){
          this.poolResultObj = new PollResult(this.ssss[0].committee.id, this.ssss[0].committee.nameEn,
            this.ssss[0].committee.nameAr, this.ssss.length, 0 , 0,0); 
            this.poolResult.push(this.poolResultObj);
        } else {
          commId.wish2Count = this.ssss.length;
          this.sumCount = this.sumCount + this.ssss.length;
          this.poolResult[itemIndex] = commId;
        }
    });
    filteredData.forEach(element => {
      console.log('commID ' + element.comm.id);
      this.ssss = (this.pollData.filter(data => data.committee.id === element.comm.id 
        && data.wishOrder === 3));
        let commId = this.poolResult.find(x => x.committeId == element.comm.id);
        let itemIndex = this.poolResult.findIndex(x => x.committeId == element.comm.id);
        if(!commId){
          this.poolResultObj = new PollResult(this.ssss[0].committee.id, this.ssss[0].committee.nameEn,
            this.ssss[0].committee.nameAr, this.ssss.length, 0 , 0,0); 
            this.poolResult.push(this.poolResultObj);
        } else {
          commId.wish3Count = this.ssss.length;
          commId.sum = (this.sumCount + this.ssss.length)-1;
          this.poolResult[itemIndex] = commId;
        }
    });
    this.dataSource.data = this.poolResult;
    console.log('source------' + JSON.stringify(this.poolResult));
    //console.log('source22------' + JSON.stringify(filteredData));
  }
}
