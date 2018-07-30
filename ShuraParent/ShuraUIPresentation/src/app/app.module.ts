import { NgModule, Component } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RouterModule, Routes } from '@angular/router';
import { MatMomentDateModule } from '@angular/material-moment-adapter';
import { MatButtonModule, MatIconModule } from '@angular/material';

import { InMemoryWebApiModule } from 'angular-in-memory-web-api';
import { TranslateModule } from '@ngx-translate/core';
import 'hammerjs';
import { HttpModule } from '@angular/http';
import { FuseModule } from '@fuse/fuse.module';
import { FuseSharedModule } from '@fuse/shared.module';
import { FuseSidebarModule, FuseThemeOptionsModule } from '@fuse/components';

import { fuseConfig } from 'app/fuse-config';

import { FakeDbService } from 'app/fake-db/fake-db.service';
import { AppComponent } from 'app/app.component';
import { AppStoreModule } from 'app/store/store.module';
import { LayoutModule } from 'app/layout/layout.module';
import { WelcomeModule } from './welcome/welcome.module';
import { GroupPermModule } from './group-perm/group-perm.module';
import { MaterialModule } from './main/angular-material-elements/material.module';
import { GroupUserAssignModule } from './group-user-assign/group-user-assign.module';
import { LoginModule } from './login/login.module';
import { AuthGuard } from './auth.guard';
import { StorageService } from './services/storage.service';
import { StorageServiceModule } from '../../node_modules/angular-webstorage-service';
import { ManageUsersModule } from './manage-users/manage-users.module';
import { ManageCommitteeModule } from './manage-committee/manage-committee.module';
import { UserService } from './services/user.service';
import { CommitteeService } from './services/committee.service';
import { MemberWishesModule } from './member-wishes/member-wishes.module';


const appRoutes: Routes = [
    {
        path        : 'apps',
        loadChildren: './main/apps/apps.module#AppsModule'
    },
    {
        path        : 'pages',
        loadChildren: './main/pages/pages.module#PagesModule'
    },
    {
        path        : 'ui',
        loadChildren: './main/ui/ui.module#UIModule'
    },
    {
        path        : 'documentation',
        loadChildren: './main/documentation/documentation.module#DocumentationModule'
    },
    {
        path        : 'angular-material-elements',
        loadChildren: './main/angular-material-elements/angular-material-elements.module#AngularMaterialElementsModule'
    },
    {
        path      : '**',
        canActivate: [AuthGuard],
        redirectTo: 'apps/dashboards/analytics'
    }
];

@NgModule({
    declarations: [
        AppComponent
    ],
    imports     : [
        BrowserModule,
        BrowserAnimationsModule,
        HttpClientModule,
        //, {enableTracing:true}
        RouterModule.forRoot(appRoutes ),

        TranslateModule.forRoot(),
        InMemoryWebApiModule.forRoot(FakeDbService, {
            delay             : 0,
            passThruUnknownUrl: true
        }),

        // Material moment date module
        MatMomentDateModule,

        // Material
        MatButtonModule,
        MatIconModule,
        MaterialModule,

        // Fuse modules
        FuseModule.forRoot(fuseConfig),
        FuseSharedModule,
        FuseSidebarModule,
        FuseThemeOptionsModule,
        HttpModule,
        
        // App modules
        LayoutModule,
        AppStoreModule,
        WelcomeModule,
        GroupPermModule,
        GroupUserAssignModule,
        LoginModule,
        ManageUsersModule,
        ManageCommitteeModule,

        StorageServiceModule,

        MemberWishesModule
    ],
    bootstrap   : [
        AppComponent
    ],
    providers : [UserService,StorageService,CommitteeService]
})
export class AppModule
{
}
