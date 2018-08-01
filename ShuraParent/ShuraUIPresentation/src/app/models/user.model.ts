import { Menu } from './menu.model';
import { Permission } from './permission.model';
import { Group } from './group.model';
export class User {
    userId: number;
    username: string;
    email: string;
    password: string;
    groups: Group[];
    menus: Menu[];
    permissions: Permission[];

    constructor(userId: number, username: string, email: string, password: string,
    groups: Group[], menus: Menu[], permissions: Permission[]) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.groups = groups;
        this.menus = menus;
        this.permissions = permissions;
    }
}