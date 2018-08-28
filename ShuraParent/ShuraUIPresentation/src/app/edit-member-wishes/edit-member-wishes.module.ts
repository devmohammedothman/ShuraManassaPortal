import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EditMemberWishesComponent } from './edit-member-wishes.component';
import { RouterModule, Routes } from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule} from '@angular/forms';

import { MaterialModule } from '../main/angular-material-elements/material.module';
import { FuseModule } from '@fuse/fuse.module';
import { FuseSharedModule } from '@fuse/shared.module';
import { FuseSidebarModule, FuseThemeOptionsModule } from '@fuse/components';
import { fuseConfig } from 'app/fuse-config';
import { AuthGuard } from '../auth.guard';
import { TranslateModule } from '@ngx-translate/core';

const route:Routes = [
  {
    path:'nomination/edit-member-wish',
    // canActivate:[AuthGuard],
    component:EditMemberWishesComponent
  }
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(route),

    TranslateModule,

    BrowserModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,

    // Fuse modules
    FuseModule.forRoot(fuseConfig),
    FuseSharedModule,
    FuseSidebarModule,
    FuseThemeOptionsModule,

    // material
    MaterialModule,
  ],
  exports: [EditMemberWishesComponent],
  declarations: [EditMemberWishesComponent]
})
export class EditMemberWishesModule { }
