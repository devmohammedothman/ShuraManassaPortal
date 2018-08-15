import { User } from "./user.model";
import { CommitteMembers } from "./committe-members.model";

export class NominationPollResult {
    committeeMembers: CommitteMembers[];
    processId: number;
    isApproved: boolean;
    constructor(){}

    get getIsApproved(): boolean {
        return this.isApproved;
    }

    set setIsApproved(isApproved: boolean) {
        this.isApproved = isApproved;
    }

}