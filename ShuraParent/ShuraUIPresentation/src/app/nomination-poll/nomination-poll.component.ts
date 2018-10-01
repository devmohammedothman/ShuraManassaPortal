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
import { NominationPollResult } from '../models/nomination-poll-result.model';
import { DialogComponent } from './dialog/dialog.component';
import { CommitteMember } from '../models/commitee-member.model';

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
  currentCommitteeMembers: CommitteMembers[];
  sumCount: number = 0;
  errorMessage: string;
  nominationPollResult: NominationPollResult = new NominationPollResult();
  runProcessCount : number = 0;

  displayedColumns = ['Committe name', 'First Wish', 'Second wish', 'Third wish',
    'sum', 'Nomination result'];
  dataSource: MatTableDataSource<PollResult>;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(public snackBar: MatSnackBar,
    private storageService: StorageService, private nominationService: NominationService,
    private dialog: DialogComponent) {
    this.dataSource = new MatTableDataSource(this.poolResult);

    this.getLastNominationPoll();
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
    this.runProcessCount ++;
    this.pollParam = new NominationPollParam(this.memberCount, this.runProcessCount, false, JSON.parse(this.storageService.getFromLocal('user')));
    this.nominationService.runPollProcess(this.pollParam)
      .subscribe(result => {
        this.nominationPollResult = result;
        this.pollData = result.committeeMembers;
        this.storageService.saveInLocal('processId',result.processId);
        if (this.committeList) {
          this.committeList.splice(0, this.committeList.length);
          this.poolResult.splice(0, this.poolResult.length);
          this.currentCommitteeMembers.splice(0, this.currentCommitteeMembers.length);
          this.sumCount = 0;
        }
        // console.log('before'+ JSON.stringify(this.pollData));
        this.populateTableData();
      },
        // error => this.errorMessage = <any>error);
        error => alert("There is an error "));
  }

  confirmPollProcess(): void {
    this.nominationPollResult.approved = true;
    this.nominationPollResult.processId = Number(this.storageService.getFromLocal('processId'));
    this.nominationService.confirmPollProcess(this.nominationPollResult)
      .subscribe(result => {
        this.openSnackBar('Done!', 'Close');
        
      },
        // error => this.errorMessage = <any>error);
        this.openSnackBar('There is an error', 'Close')
      );
      console.log('confirm! '+JSON.stringify((this.nominationPollResult)));
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
      console.log('after filteration ------' + JSON.stringify(filteredData));
    filteredData.forEach(element => {
      
      let wish1Count = 0;
      let wish2Count = 0;
      let wish3Count = 0;
      let comTotalCount = 0;
      console.log('start loop with element ' + JSON.stringify(element));
      this.currentCommitteeMembers = (this.pollData.filter(data => data.committee.id === element.comm.id
        && data.wishOrder === 1));
        console.log("ssss value "+JSON.stringify(this.currentCommitteeMembers));
        if(this.currentCommitteeMembers && this.currentCommitteeMembers.length > 0)
        {
          //loop over members who select this committee as first wish
          for(var i = 0 ; i < this.currentCommitteeMembers.length; i++)
          {
            wish1Count ++;
            comTotalCount ++;
          }
        }
      
      this.currentCommitteeMembers = (this.pollData.filter(data => data.committee.id === element.comm.id
        && data.wishOrder === 2));
        console.log("ssss value with order 2 "+JSON.stringify(this.currentCommitteeMembers));
        console.log("poolresult with order 2"+JSON.stringify(this.poolResult));

        let commId;

        if(this.currentCommitteeMembers && this.currentCommitteeMembers.length > 0)
        {
          //loop over members who select this committee as first wish
          for(var i = 0 ; i < this.currentCommitteeMembers.length; i++)
          {
            wish2Count ++;
            comTotalCount ++;
          }
          // wish1Count = this.currentCommitteeMembers.length;        
          // commId = this.poolResult.find(x => x.committeId == element.comm.id);
          // let itemIndex = this.poolResult.findIndex(x => x.committeId == element.comm.id);
          // console.log('comm id value is '+JSON.stringify(commId));
          // if (!commId)
          //  {
          //     this.poolResultObj = new PollResult(this.currentCommitteeMembers[0].committee.id, this.currentCommitteeMembers[0].committee.nameEn,
          //     this.currentCommitteeMembers[0].committee.nameAr, 0, wish2Count, 0, 0);
          //     this.poolResult.push(this.poolResultObj);
          // } 
          // else 
          // {
          //   console.log('inside first else');
          //   commId.wish2Count = this.currentCommitteeMembers.length;
          //   this.sumCount = this.sumCount + this.currentCommitteeMembers.length;
          //   this.poolResult[itemIndex] = commId;
          // }
        }
           
      this.currentCommitteeMembers = (this.pollData.filter(data => data.committee.id === element.comm.id
        && data.wishOrder === 3));
        console.log("ssss value with order 3 "+JSON.stringify(this.currentCommitteeMembers));
        console.log("poolresult with order 3 "+JSON.stringify(this.poolResult));
        if(this.currentCommitteeMembers && this.currentCommitteeMembers.length > 0)
        {
          //loop over members who select this committee as first wish
          for(var i = 0 ; i < this.currentCommitteeMembers.length; i++)
          {
            wish3Count ++;
            comTotalCount ++;
          }
        //   let commId2 = this.poolResult.find(x => x.committeId == element.comm.id);
        //   let itemIndex2 = this.poolResult.findIndex(x => x.committeId == element.comm.id);
        //   if (!commId2) {
        //     this.poolResultObj = new PollResult(this.currentCommitteeMembers[0].committee.id, this.currentCommitteeMembers[0].committee.nameEn,
        //       this.currentCommitteeMembers[0].committee.nameAr, 0, 0, this.currentCommitteeMembers.length, 0);
        //     this.poolResult.push(this.poolResultObj);
        // } 
        // else 
        //   {
        //     console.log('inside last else');
        //     commId2.wish3Count = this.currentCommitteeMembers.length;
        //     commId2.sum = this.sumCount + this.currentCommitteeMembers.length;
        //     this.poolResult[itemIndex2] = commId;
        //   }
      }
      
      this.poolResultObj = new PollResult(element.comm.id, element.comm.nameEn,
        element.comm.nameAr, wish1Count, wish2Count, wish3Count, comTotalCount);
        this.poolResult.push(this.poolResultObj);
      console.log('end loop');
    });
    this.dataSource.data = this.poolResult;
    //console.log('source------' + JSON.stringify(this.poolResult));
    //console.log('source22------' + JSON.stringify(filteredData));
  }

  openDialog(commId: number): void{
    this.getCommitteeMembers(commId);
    this.dialog.openDialog();
    this.dialog.dialog.closeAll();
    setTimeout(()=>{ this.dialog.openDialog(); }, 200);
  }

  getLastNominationPoll(): void{
    this.nominationService.getCurrentCommitteeMembers().subscribe(result =>{
      this.pollData = result;
      this.nominationPollResult.committeeMembers = result;
      console.log('first log');
      if(this.pollData){
        console.log('poll data is not null');
        this.populateTableData();
        this.hideTable = false;
      }
      if (this.committeList) {
        this.committeList.splice(0, this.committeList.length);
        this.poolResult.splice(0, this.poolResult.length);
        this.currentCommitteeMembers.splice(0, this.currentCommitteeMembers.length);
        this.sumCount = 0;
      }
    },
    error => this.openSnackBar('There is an error', 'Close'));
  }

  getCommitteeMembers(committeeId: number): void {
    this.nominationService.getCommitteeMembers(committeeId)
      .subscribe(comm => {
        this.storageService.removeFromLocal('dlgMember');
        this.storageService.saveInLocal('dlgMember', JSON.stringify(comm));
      },
        error => this.errorMessage = <any>error);
  }
  
}
