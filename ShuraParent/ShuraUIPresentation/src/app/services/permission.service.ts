import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions  } from '@angular/http';
import { Observable } from 'rxjs';
import { URLSearchParams } from '@angular/http';
//import {Base64} from 'angular-base64/angular-base64'; 
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/toPromise';
import { AssignParam } from '../models/assign-user-group-param.model';
import { User } from '../models/user.model';
import { Group } from '../models/group.model';

@Injectable({
    providedIn: 'root'
})
export class PermissionService {

    constructor(private http: Http) { }

    private baseUrl = 'http://localhost:8080/ShuraIntegrationAPI/api/';

    getGroups(): Observable<any> {
         let headers = new Headers({ 'Content-Type': 'application/json' });
         let options = new RequestOptions({ headers: headers });
        return this.http.get(this.baseUrl+'perm/getgroups',options)
            .map(data => data.json());
    }

    getPermissionsByMenu(menuId: string): Observable<any> {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
       return this.http.get(this.baseUrl+'perm/getpermissionsbymenu/'+menuId,options)
           .map(data => data.json());
   }
    
    getUsers(): Observable<any> {
         let headers = new Headers({ 'Content-Type': 'application/json' });
         let options = new RequestOptions({ headers: headers });
        return this.http.get(this.baseUrl+'user/getusers',options)
            .map(data => data.json());
    }
    
    assignUserToGroup(param: AssignParam): Observable<User> {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        return this.http.post(this.baseUrl + 'user/assigngroup', param, options)
            .map(this.extractData)
            .catch(this.handleErrorObservable);
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

