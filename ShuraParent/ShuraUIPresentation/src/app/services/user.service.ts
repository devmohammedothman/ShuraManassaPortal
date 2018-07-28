import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';
import { URLSearchParams } from '@angular/http';
import { AssignParam } from '../models/assign-user-group-param.model';
//import {Base64} from 'angular-base64/angular-base64'; 
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/toPromise';

import { User } from '../models/user.model';
import { Auth } from '../models/auth.model';
import { LoginParam } from '../models/login.model';
import { StorageService } from './storage.service';
import { ServiceUtils } from './serviceUtils';
import { RegisterParam } from '../models/register.model';

@Injectable()
export class UserService {

    constructor(private http: Http,
        private storageService: StorageService) { }

    private baseUrl = ServiceUtils.baseUrl+'user/';
    private authUrl = 'http://localhost:8080/ShuraIntegrationAPI/api/oauth/token';
    private loginUrl = 'http://localhost:8080/ShuraIntegrationAPI/api/user/login';
    private token = 'bearer '+this.storageService.getFromLocal('token');
    authValue;
    loginValue;

    authorize(param: Auth): Observable<Auth> {
        // let authData = Base64.encode('spring-security-oauth2-read-write-client' + ':' + 'spring-security-oauth2-read-write-client-password1234');
        let headers = new Headers({
            'Content-Type': 'application/x-www-form-urlencoded',
            'Access-Control': 'Allow-Origin',
            'Authorization': 'Basic ' + 'c3ByaW5nLXNlY3VyaXR5LW9hdXRoMi1yZWFkLXdyaXRlLWNsaWVudDpzcHJpbmctc2VjdXJpdHktb2F1dGgyLXJlYWQtd3JpdGUtY2xpZW50LXBhc3N3b3JkMTIzNA=='
        });
        let options = new RequestOptions({ headers: headers });
        let params = new URLSearchParams();
        params.set('username', param.username);
        params.set('password', param.password);
        params.set('grant_type', param.grant_type);
        params.set('client_id', param.client_id);
        this.authValue = this.http.post(this.authUrl, params, options)
            .map(this.extractData)
            .catch(this.handleErrorObservable);
        return this.authValue;
    }

    login(param: LoginParam): Observable<User> {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        this.loginValue = this.http.post(this.loginUrl , param, options)
            .map(this.extractData)
            .catch(this.handleErrorObservable);
        return this.loginValue;
    }

    isLoggedIn() {
        console.log("logged in value " + this.storageService.getFromLocal('user') != null);
        return this.storageService.getFromLocal('user') != null;
    }
    register(param: RegisterParam): Observable<User> {
        let headers = new Headers({ 'Content-Type': 'application/json',
        'authorization': this.token,
        'Access-Control': 'Allow-Origin' });
        let options = new RequestOptions({ headers: headers });
        return this.http.post(this.baseUrl + 'register', param, options)
            .map(this.extractData)
            .catch(this.handleErrorObservable);
    }

    //tttttttttttttttttttttt
    getGroups(): Observable<any> {
        console.log('Service log : '+ this.token);
        let headers = new Headers({ 'Content-Type': 'application/json',
        'authorization': this.token,
        'Access-Control': 'Allow-Origin' });
        let options = new RequestOptions({ headers: headers });
        return this.http.get(this.baseUrl + 'getgroups', options)
            .map(data => data.json());
    }

    getPermissionsByMenu(menuId: string): Observable<any> {
        let headers = new Headers({ 'Content-Type': 'application/json',
        'authorization': this.token,
        'Access-Control': 'Allow-Origin' });
        let options = new RequestOptions({ headers: headers });
        return this.http.get(this.baseUrl + 'getpermissionsbymenu' + menuId, options)
            .map(data => data.json());
    }

    getUsers(): Observable<any> {
        let headers = new Headers({ 'Content-Type': 'application/json',
        'authorization': this.token,
        'Access-Control': 'Allow-Origin' });
        let options = new RequestOptions({ headers: headers });
        return this.http.get(this.baseUrl + 'getusers', options)
            .map(data => data.json());
    }

    assignUserToGroup(param: AssignParam): Observable<User> {
        let headers = new Headers({ 'Content-Type': 'application/json',
        'authorization': this.token,
        'Access-Control': 'Allow-Origin' });
        let options = new RequestOptions({ headers: headers });
        return this.http.post(this.baseUrl + 'assigngroup', param, options)
            .map(this.extractData)
            .catch(this.handleErrorObservable);
    }
    //tttttttttttttttttttttt

    private extractData(res: Response) {
        let body = res.json();
        return body || {};
    }
    private handleErrorObservable(error: Response | any) {
        console.error(error.message || error);
        return Observable.throw(error.message || error);
    }

}
