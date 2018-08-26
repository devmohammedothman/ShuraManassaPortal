import { FuseNavigation } from '@fuse/types';

export const navigation: FuseNavigation[] = [
    {
        id       : 'home',
        title    : 'Home',
        translate: 'NAV.HOME',
        type     : 'item',
        icon     : 'home',
        image    : 'logos/shura.svg',
        url      : '/home'
    },
    {
        id       : 'dashboard',
        title    : 'Dashboard',
        translate: 'NAV.DASHBOARD',
        type     : 'item',
        icon     : 'face',
        image    : 'nav-items/stats.png',
        url      : '/apps/dashboards/project'
    },
    {
        id       : 'settings',
        title    : 'Settings',
        translate: 'NAV.SETTING',
        type     : 'group',                
        icon     : 'settings',
        image    : 'nav-items/adv-search.png',
        children : [
            {
                id       : 'Permission',
                title    : 'Permission',
                translate: 'NAV.PERMISSION',
                type     : 'item',
                icon     : 'flag',
                image    : 'nav-items/adv-search.png',
                url      : '/perm'
            },
            {
                id       : 'GroupUserAssign',
                title    : 'Assign User To Group',
                translate: 'NAV.GroupUserAssign',
                type     : 'item',
                icon     : 'flag',
                image    : 'nav-items/adv-search.png',
                url      : '/gua'
            },
            {
                id       : 'ManageUser',
                title    : 'Manage User',
                translate: 'NAV.MANAGEUSER',
                type     : 'item',
                icon     : 'flag',
                image    : 'nav-items/adv-search.png',
                url      : '/manage-users'
            },
            {
                id       : 'ManageCommittee',
                title    : 'Manage Committee',
                translate: 'NAV.MANAGECOMMITTEE',
                type     : 'item',
                icon     : 'flag',
                image    : 'nav-items/adv-search.png',
                url      : '/manage-committee/list'
            },
        ]
        
    },
    {
        id       : 'nominationProgram',
        title    : 'Member Nomination Program',
        translate: 'NAV.MEMNOMINATION',
        type     : 'group',
        icon     : '',
        image    : 'nav-items/comm-board.png',
        children : [
            {
                id       : 'AddWishes',
                title : 'add wishes',
                translate: 'NAV.ADDWISHES',
                type     : 'item',
                icon     : 'flag',
                image    : 'nav-items/adv-search.png',
                url      : '/nomination/addmemberwish'
            },
            {
                id       : 'ManagerWishes',
                title : 'Manager wishes',
                translate: 'NAV.ADDWISHES',
                type     : 'item',
                icon     : 'flag',
                image    : 'nav-items/adv-search.png',
                url      : '/maw'
            },
            {
                id       : 'EditMemberWishes',
                title : 'Edit Member Wishes',
                translate: 'NAV.EditMemWish',
                type     : 'item',
                icon     : 'flag',
                image    : 'nav-items/adv-search.png',
                url      : '/nomination/edit-member-wish'
            },
        ]
    },

];
