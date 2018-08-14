import { User } from './user.model';

export class Committee
{
    
     id: number;
     nameAr: string;
     nameEn: string;
     commManager: User;
    constructor(){}
    
    // constructor(id : number , nameAr : string , nameEn : string , commManager : User)
    // {
    //     this.id = id;
    //     this.nameAr = nameAr;
    //     this.nameEn = nameEn;
    //     this.commManager = commManager;
    // }
}
