import { User } from "./user.model";
import { CommitteeExperience } from "./committeeExperience";

export class Committee
{
    
     id? : number;
     nameAr : string;
     nameEn : string;
     commManager? : User;
     comm?: Committee;
     committeeExperiences?:CommitteeExperience[];
    constructor(committee: Committee){
        this.comm = committee;
    }
    
    // constructor(id : number , nameAr : string , nameEn : string , commManager : User)
    // {
    //     this.id = id;
    //     this.nameAr = nameAr;
    //     this.nameEn = nameEn;
    //     this.commManager = commManager;
    // }
}