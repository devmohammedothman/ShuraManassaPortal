import { Injectable } from "@angular/core";
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { StorageService } from './storage.service';
import { ServiceUtils } from "./serviceUtils";
import { Observable } from 'rxjs';

@Injectable()
export class HelperServices {

    private baseUrl = ServiceUtils.baseUrl+'/util/';

    constructor(private http: Http,
        private storageService: StorageService) { }

        getCurrentHijriiDate(): Observable<any> {
            const headers = new Headers({ 'Content-Type': 'application/json' });
            const options = new RequestOptions({ headers: headers });
             return this.http.get(this.baseUrl+'getHijriDate/', options)
            .map(data => data.json().data);
            
        }

}