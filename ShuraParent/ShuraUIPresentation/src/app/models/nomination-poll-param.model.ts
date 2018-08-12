import { User } from "./user.model";

export class NominationPollParam {
    noOfMembers: number;
    actionNo: string;
    isApproved: boolean;
    actionUser: User;
    
    constructor(noOfMembers: number, actionNo: string, isApproved: boolean, actionUser: User) { 
        this.noOfMembers = noOfMembers;
        this.actionNo = actionNo;
        this.isApproved = isApproved;
        this.actionUser = actionUser;
   }
}