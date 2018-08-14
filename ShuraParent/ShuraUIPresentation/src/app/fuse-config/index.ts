import { FuseConfig } from '@fuse/types';

/**
 * Default Fuse Configuration
 *
 * You can edit these options to change the default options. All these options also can be changed per component
 * basis. See `app/main/pages/authentication/login/login.component.ts` constructor method to learn more
 * about changing these options per component basis.
 */

export const fuseConfig: FuseConfig = {
    layout          : {
        style         : 'horizontal-layout-1',
        width         : 'fullwidth',
        navbar        : {
            hidden    : false,
            position  : 'right',
            folded    : false,
            background: 'mat-fuse-dark-700-bg'
        },
        toolbar       : {
            hidden    : false,
            position  : 'above',
            background: ''
        },
        footer        : {
            hidden    : false,
            position  : 'above',
            background: 'mat-fuse-dark-900-bg'
        }
    },
    customScrollbars: true
};
