import { User } from "./user.model";
import { CommitteMembers } from "./committe-members.model";

export class NominationPollResult {
    committeeMembers: CommitteMembers[];
    processId: number;
    constructor(){}
}