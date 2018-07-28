import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ManageCommitteeComponent } from './manage-committee.component';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule} from '@angular/forms';

import { MaterialModule } from '../main/angular-material-elements/material.module';
import { FuseModule } from '@fuse/fuse.module';
import { FuseSharedModule } from '@fuse/shared.module';
import { FuseSidebarModule, FuseThemeOptionsModule } from '@fuse/components';
import { fuseConfig } from 'app/fuse-config';
import { AuthGuard } from '../auth.guard';
import { AddEditCommitteeComponent } from './add-edit-committee/add-edit-committee.component';

const routes : Routes= [
  {
      path     : 'manage-committee/list',
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
       MaterialModule,
       FormsModule
  ],
  declarations: [ManageCommitteeComponent, AddEditCommitteeComponent],
  providers:[AddEditCommitteeComponent],
  entryComponents : [AddEditCommitteeComponent]
})
export class ManageCommitteeModule { }
