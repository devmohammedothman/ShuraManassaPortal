import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TranslateModule } from '@ngx-translate/core';
import { MemberWishesComponent } from './member-wishes.component';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuard } from '../auth.guard';

import { MaterialModule } from '../main/angular-material-elements/material.module';
import { FuseModule } from '@fuse/fuse.module';
import { FuseSharedModule } from '@fuse/shared.module';
import { FuseSidebarModule, FuseThemeOptionsModule } from '@fuse/components';
import { fuseConfig } from 'app/fuse-config';
import { ReactiveFormsModule } from '@angular/forms';
import { MatSnackBarModule } from '../../../node_modules/@angular/material';

const routes: Routes = [
  {
      path: 'nomination/addmemberwish',
      // canActivate: [AuthGuard],
      component: MemberWishesComponent
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

    // material
      MaterialModule,
      MatSnackBarModule,

      ReactiveFormsModule 
  ],
  exports: [MemberWishesComponent],
  declarations: [MemberWishesComponent]
})
export class MemberWishesModule { }
