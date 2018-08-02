import { Menu } from './menu.model';
import { Permission } from './permission.model';
import { Group } from './group.model';
export class User {
    userId: number;
    username: string;
    avatarUrl: string;
    email: string;
    password: string;
    groups: Group[];
    menus: Menu[];
    permissions: Permission[];

<<<<<<< HEAD
    constructor(userId: string, username: string, avatarUrl: string, email: string, password: string,
=======
    constructor(userId: number, username: string, email: string, password: string,
>>>>>>> bb8e480b458f8baf607d8f224542c55fd1e31871
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
