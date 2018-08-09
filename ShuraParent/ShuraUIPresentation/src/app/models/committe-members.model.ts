import { Committee } from "./committee.model";
import { User } from "./user.model";

export class CommitteMembers{
    committee: Committee;
    member: User;
    wishOrder: number;
    id: number;

    constructor(committee: Committee){
       this.committee = committee;
    }
}