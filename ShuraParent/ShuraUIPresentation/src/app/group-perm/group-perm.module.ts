import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { GroupPermComponent } from './group-perm.component';
import { RouterModule, Routes } from '@angular/router';

import { MaterialModule } from '../main/angular-material-elements/material.module';
import { FuseModule } from '@fuse/fuse.module';
import { FuseSharedModule } from '@fuse/shared.module';
import { FuseSidebarModule, FuseThemeOptionsModule } from '@fuse/components';
import { fuseConfig } from 'app/fuse-config';
import { AuthGuard } from '../auth.guard';
import { TranslateModule } from '@ngx-translate/core';
import { ReactiveFormsModule } from '@angular/forms';

const routes: Routes = [
  {
      path        : 'perm',
      canActivate: [AuthGuard],
      component   : GroupPermComponent
  }
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes),
    TranslateModule,

  // Fuse modules
    FuseModule.forRoot(fuseConfig),
    FuseSharedModule,
    FuseSidebarModule,
    FuseThemeOptionsModule,

    ReactiveFormsModule,

    // material
    MaterialModule
  ],
  declarations: [GroupPermComponent]
})
export class GroupPermModule { }
