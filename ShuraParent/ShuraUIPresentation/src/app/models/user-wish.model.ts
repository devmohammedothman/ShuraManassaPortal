import { Committee } from "./committee.model";
import { User } from "./user.model";

export class UserWish {
    id: number;
    nominatedUser: User;
    wishedCommitee: Committee;
    wishOrder: number;
    memberNotes? : string;



    constructor(nominatedUser: User, wishedCommitee: Committee, wishOrder: number,memberNotes : string){
        this.nominatedUser = nominatedUser;
        this.wishedCommitee = wishedCommitee;
        this.wishOrder = wishOrder;
        this.memberNotes = memberNotes;
    }
}