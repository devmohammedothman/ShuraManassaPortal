import { User } from "./user.model";

export class NominationPollParam {
    noOfMembers: number;
    actionNo: number;
    isApproved: boolean;
    actionUser: User;
    
    constructor(noOfMembers: number, actionNo: number, isApproved: boolean, actionUser: User) { 
        this.noOfMembers = noOfMembers;
        this.actionNo = actionNo;
        this.isApproved = isApproved;
        this.actionUser = actionUser;
   }
}