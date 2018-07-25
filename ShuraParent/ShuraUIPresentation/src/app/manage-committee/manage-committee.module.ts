import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ManageCommitteeComponent } from './manage-committee.component';
import { RouterModule, Routes } from '@angular/router';

import { MaterialModule } from '../main/angular-material-elements/material.module';
import { FuseModule } from '@fuse/fuse.module';
import { FuseSharedModule } from '@fuse/shared.module';
import { FuseSidebarModule, FuseThemeOptionsModule } from '@fuse/components';
import { fuseConfig } from 'app/fuse-config';
import { AuthGuard } from '../auth.guard';

const routes : Routes= [
  {
      path     : 'manage-committee',
      canActivate : [AuthGuard],
      component: ManageCommitteeComponent
  }
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes),

     // Fuse modules
     FuseModule.forRoot(fuseConfig),
     FuseSharedModule,
     FuseSidebarModule,
     FuseThemeOptionsModule,
 
     //material
       MaterialModule
  ],
  declarations: [ManageCommitteeComponent]
})
export class ManageCommitteeModule { }
