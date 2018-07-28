import { Http, Headers,RequestOptions } from "@angular/http";
import { Observable } from "rxjs";
import { ServiceUtils } from "./serviceUtils";
import { StorageService } from './storage.service';
import { Injectable } from '@angular/core';
import { Committee } from "../models/committee.model";

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

    //Add CommitteeService
    addCommittee(commObject : Committee)
    {
        const sentCommObjBody :Committee = {
            id : 0,
            nameAr:commObject.nameAr,
            nameEn:commObject.nameEn,
            commManager : null,
        }
        console.log('call Add Committee BE Service');
        return this.http.post(this.baseUrl + 'addcomm',sentCommObjBody);
    }
}