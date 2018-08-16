import { FuseNavigation } from '@fuse/types';

export const navigation: FuseNavigation[] = [
    {
        id       : 'welcome',
        title    : 'Welcome',
        translate: 'NAV.WELCOME',
        type     : 'group',
        icon     : 'apps',
        
        children : [
            {
                id       : 'dashboard',
                title    : 'Dashboard',
                translate: 'NAV.DASHBOARD',
                type     : 'item',
                icon     : 'face',
                url      : '/apps/dashboards/project'
            },
            {
                id       : 'settings',
                title    : 'Settings',
                translate: 'NAV.SETTING',
                type     : 'collapsable',                
                icon     : 'settings',
                children : [
                    {
                        id       : 'Permission',
                        title    : 'Permission',
                        translate: 'NAV.PERMISSION',
                        type     : 'item',
                        icon     : 'flag',
                        url      : '/perm'
                    },
                    {
                        id       : 'GroupUserAssign',
                        title    : 'Assign User To Group',
                        translate: 'NAV.GroupUserAssign',
                        type     : 'item',
                        icon     : 'flag',
                        url      : '/gua'
                    },
                    {
                        id       : 'ManageUser',
                        title    : 'Manage User',
                        translate: 'NAV.MANAGEUSER',
                        type     : 'item',
                        icon     : 'flag',
                        url      : '/manage-users'
                    },
                    {
                        id       : 'ManageCommittee',
                        title    : 'Manage Committee',
                        translate: 'NAV.MANAGECOMMITTEE',
                        type     : 'item',
                        icon     : 'flag',
                        url      : '/manage-committee/list'
                    },
                ]
                
            },
            {
                id       : 'nominationProgram',
                title    : 'Member Nomination Program',
                translate: 'NAV.MEMNOMINATION',
                type     : 'collapsable',
                icon     : '',
                children : [
                    {
                        id       : 'AddWishes',
                        title : 'add wishes',
                        translate: 'NAV.ADDWISHES',
                        type     : 'item',
                        icon     : 'flag',
                        url      : '/nomination/addmemberwish'
                    },
                    {
                        id       : 'ManagerWishes',
                        title : 'Manager wishes',
                        translate: 'NAV.ADDWISHESSG',
                        type     : 'item',
                        icon     : 'flag',
                        url      : '/nomination/addmemberwishbySG'
                    },
                    {
                        id       : 'EditMemberWishes',
                        title : 'Edit Member Wishes',
                        translate: 'NAV.EditMemWish',
                        type     : 'item',
                        icon     : 'flag',
                        url      : '/nomination/edit-member-wish'
                    },
                ]
            },
        ]
    }

];
