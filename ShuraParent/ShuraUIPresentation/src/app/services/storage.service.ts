import { Injectable, Inject } from '@angular/core';
import { LocalStorage } from '@ngx-pwa/local-storage'
import { User } from '../models/user.model';;
import { StorageServiceModule, LOCAL_STORAGE, WebStorageService} from 'angular-webstorage-service';

@Injectable({
    providedIn: 'root'
})
export class StorageService {

    constructor(@Inject(LOCAL_STORAGE) private storage: WebStorageService) { }


    saveInLocal(key, val): void {
        this.storage.set(key, val);
    }

    getFromLocal(key): string {
        return this.storage.get(key);
    }
    
    getFromUserLocal(key): User {
        return this.storage.get(key);
    }
    
    removeFromLocal(key): void {
      this.storage.remove(key); 
    }

    /*setStorageValue(key, val) {
        console.log('ser val : '+ val);
        this.localStorage.setItem(key, val).subscribe(() => { });
    }

    getStorageListValue(key){
        return this.localStorage.getItem(key).subscribe((token: string) => {
            token;
        }, () => { });
    }*/
}
