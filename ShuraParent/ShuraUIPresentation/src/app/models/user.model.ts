import { Menu } from './menu.model';
import { Permission } from './permission.model';
import { Group } from './group.model';
export class User {
    userId: string;
    username: string;
    avatarUrl: string;
    email: string;
    password: string;
    groups: Group[];
    menus: Menu[];
    permissions: Permission[];

    constructor(userId: string, username: string, avatarUrl: string, email: string, password: string,
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
