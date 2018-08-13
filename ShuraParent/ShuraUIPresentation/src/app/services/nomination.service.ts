import { Http, Response, Headers, RequestOptions } from "@angular/http";
import { Observable } from "rxjs";
import { ServiceUtils } from "./serviceUtils";
import { StorageService } from './storage.service';
import { Injectable } from '@angular/core';
import { MemberAssignedWishes } from "app/models/member-assigned-wishes";
import { HttpParams } from "@angular/common/http";
import { UserWish } from "../models/user-wish.model";
import { NominationPollParam } from "../models/nomination-poll-param.model";
import { CommitteMembers } from "../models/committe-members.model";
import { NominationPollResult } from "../models/nomination-poll-result.model";
import { CommitteMember } from "../models/commitee-member.model";


@Injectable()
export class NominationService {

  constructor(private http: Http, private storageService: StorageService) { }

  private baseUrl = ServiceUtils.baseUrl + 'nomination/';
  private token = 'bearer ' + this.storageService.getFromLocal('token');

  
  assignUserWishesService(userWishList: UserWish[]): Observable<string> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      'authorization': this.token,
      'Access-Control': 'Allow-Origin'
    });
    let options = new RequestOptions({ headers: headers });
    return this.http.post(this.baseUrl + 'addwish', userWishList, options)
      .map(this.extractData)
      .catch(this.handleErrorObservable);
  }
  
  managerAssignWish(userWishList: UserWish[]): Observable<string> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      'authorization': this.token,
      'Access-Control': 'Allow-Origin'
    });
    let options = new RequestOptions({ headers: headers });
    return this.http.post(this.baseUrl + 'managerassignwish', userWishList, options)
      .map(this.extractData)
      .catch(this.handleErrorObservable);
  }

  runPollProcess(nominationPollParam: NominationPollParam): Observable<NominationPollResult> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      'authorization': this.token,
      'Access-Control': 'Allow-Origin'
    });
    let options = new RequestOptions({ headers: headers });
    return this.http.post(this.baseUrl + 'runpollprocess', nominationPollParam, options)
      .map(data => data.json().data)
      .catch(this.handleErrorObservable);
  }

  confirmPollProcess(nominationPollResult: NominationPollResult): Observable<CommitteMembers[]> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      'authorization': this.token,
      'Access-Control': 'Allow-Origin'
    });
    let options = new RequestOptions({ headers: headers });
    return this.http.post(this.baseUrl + 'confirmpollprocess', nominationPollResult, options)
      .map(data => data.json().data)
      .catch(this.handleErrorObservable);
  }

  getCommitteeMembers(committeeId: number): Observable<CommitteMember[]> {
    console.log('Service log : '+ this.token);
    const headers = new Headers({ 'Content-Type': 'application/json',
    'authorization': this.token,
    'Access-Control': 'Allow-Origin' });
    const options = new RequestOptions({ headers: headers });
    return this.http.get(this.baseUrl + 'getcommitteemembers/'+committeeId, options)
        .map(data => data.json().data);
}

getCurrentCommitteeMembers():Observable<CommitteMember[]>
{
    const headers = new Headers({ 'Content-Type': 'application/json',
    'authorization': this.token,
    'Access-Control': 'Allow-Origin' });
    const options = new RequestOptions({ headers: headers });
    return this.http.get(this.baseUrl + 'getallcommitteemembers/', options)
        .map(data => data.json().data);
}

updateMemberAssignedCommittee(updatedComMember : CommitteMember ):Observable<string>
{
  
    const headers = new Headers({ 'Content-Type': 'application/json',
    'authorization': this.token,
    'Access-Control': 'Allow-Origin' });
    const options = new RequestOptions({ headers: headers });
     return this.http.post(this.baseUrl + 'updatememberassignedcommittee',updatedComMember, options)
     .map(this.extractData)
     .catch(this.handleErrorObservable);;
}

  private extractData(res: Response) {
    let body = res.json().data;
    return body || {};
  }

  private handleErrorObservable(error: Response | any) {
    console.error(error.message || error);
    return Observable.throw(error.message || error);
  }
}
