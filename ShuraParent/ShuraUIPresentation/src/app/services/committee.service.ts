import { Http, Headers,RequestOptions } from "@angular/http";
import { Observable } from "rxjs";
import { ServiceUtils } from "./serviceUtils";
import { StorageService } from './storage.service';
import { Injectable } from '@angular/core';

@Injectable()
export class CommitteeService
{

    

    constructor (private http:Http,private storageService: StorageService) {}

    private baseUrl = ServiceUtils.baseUrl+'comm/';
    private token = 'bearer '+this.storageService.getFromLocal('token');

    getAllCommitteeList():Observable<any>
    {
        let header = new Headers({ 'Content-Type': 'application/json',
        'authorization': this.token,
        'Access-Control': 'Allow-Origin' });
        let options = new RequestOptions({headers : header });
        return this.http.get(this.baseUrl + 'getcommlist', options)
            .map(data => data.json());
    }
}