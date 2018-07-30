import { Http,Response, Headers,RequestOptions } from "@angular/http";
import { Observable } from "rxjs";
import { ServiceUtils } from "./serviceUtils";
import { StorageService } from './storage.service';
import { Injectable } from '@angular/core';
import { MemberAssignedWishes } from "app/models/member-assigned-wishes";
import { HttpParams } from "../../../node_modules/@angular/common/http";

@Injectable()
export class NominationService {

  constructor (private http:Http,private storageService: StorageService) {}

  private baseUrl = ServiceUtils.baseUrl+'nomination/';
  private token = 'bearer '+this.storageService.getFromLocal('token');

  assignUserWishesService()
  {

    const params = new HttpParams();
    params.set('userid','52');
    params.set('committeeid','3');
    params.set('wishOrder','1');

    // let headers = new Headers({ 'Content-Type': 'application/json',
    // 'authorization': this.token,
    // 'Access-Control': 'Allow-Origin' });

    // let options = new RequestOptions({ headers: headers });

    console.log('call service'+this.baseUrl+'addwish');

     this.http.post(this.baseUrl + 'addwish',params);
  }

  private extractData(res: Response) {
    let body = res.json();
    return body || {};
  }

  private handleErrorObservable(error: Response | any) {
    console.error(error.message || error);
    return Observable.throw(error.message || error);
}
}
