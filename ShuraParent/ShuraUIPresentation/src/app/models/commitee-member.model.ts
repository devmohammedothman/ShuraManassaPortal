import { User } from "./user.model";
import { Committee } from "./committee.model";

export class CommitteMember {
    member: User;
    committee: Committee;
    wishOrder: number;
    id: number;

    constructor(member: User, committee: Committee, wishOrder: number, id: number) {
        this.member = member;
        this.committee = committee;
        this.wishOrder = wishOrder;
        this.id = id;
    }
}