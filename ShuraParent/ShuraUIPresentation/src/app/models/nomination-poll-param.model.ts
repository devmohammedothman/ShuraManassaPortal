import { User } from "./user.model";

export class NominationPollParam {
    noOfMembers: string;
    actionNo: string;
    isApproved: boolean;
    actionUser: User;
    
    constructor(noOfMembers: string, actionNo: string, isApproved: boolean, actionUser: User) { 
        this.noOfMembers = noOfMembers;
        this.actionNo = actionNo;
        this.isApproved = isApproved;
        this.actionUser = actionUser;
   }
}