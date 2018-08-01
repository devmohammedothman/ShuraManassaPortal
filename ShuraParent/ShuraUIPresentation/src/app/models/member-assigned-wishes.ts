import { User } from "./user.model";
import { Wish } from "app/models/wish.model";

export class MemberAssignedWishes {
    nominatedUser:User;
    wishesList :Wish [] = [];

}

