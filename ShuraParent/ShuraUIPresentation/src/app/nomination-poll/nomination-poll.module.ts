import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TranslateModule } from '@ngx-translate/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuard } from '../auth.guard';

import { MaterialModule } from '../main/angular-material-elements/material.module';
import { FuseModule } from '@fuse/fuse.module';
import { FuseSharedModule } from '@fuse/shared.module';
import { FuseSidebarModule, FuseThemeOptionsModule } from '@fuse/components';
import { fuseConfig } from 'app/fuse-config';
import { ReactiveFormsModule } from '@angular/forms';
import { MatSnackBarModule, MatDialogModule } from '../../../node_modules/@angular/material';
import { NominationPollComponent } from './nomination-poll.component';
import { DialogComponent } from './dialog/dialog.component';

const routes: Routes = [
  {
      path: 'nomination/nomination-poll',
      canActivate: [AuthGuard],
      component: NominationPollComponent
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
      ReactiveFormsModule,
      MatDialogModule
  ],
  exports: [NominationPollComponent],
  declarations: [NominationPollComponent, DialogComponent],
  providers: [DialogComponent],
  entryComponents: [DialogComponent]
})
export class NominationPollModule { }
