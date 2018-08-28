import { Menu } from './menu.model';
import { Permission } from './permission.model';
import { Group } from './group.model';
import { MemberExperience } from './memberExperience';
export class User {
    userId: number;
    username: string;
    avatarUrl: string;
    email: string;
    password: string;
    groups: Group[];
    menus: Menu[];
    permissions: Permission[];
    memberExperiences: MemberExperience[];

    constructor(userId: number, username: string, avatarUrl: string, email: string, password: string,

    groups: Group[], menus: Menu[], permissions: Permission[]) {
        this.userId = userId;
        this.username = username;
        this.avatarUrl = avatarUrl;
        this.email = email;
        this.password = password;
        this.groups = groups;
        this.menus = menus;
        this.permissions = permissions;
    }
}
