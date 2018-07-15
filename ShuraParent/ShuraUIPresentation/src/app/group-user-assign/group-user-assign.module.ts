import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FuseSharedModule } from '@fuse/shared.module';
import { MaterialModule } from '../main/angular-material-elements/material.module';


import { GroupUserAssignComponent } from './group-user-assign.component';

const routes = [
  {
      path        : 'gua',
      component   : GroupUserAssignComponent
  }
];

@NgModule({
  imports: [
    CommonModule,
    
    RouterModule.forChild(routes),

    MaterialModule,

    FuseSharedModule
  ],
  declarations: [GroupUserAssignComponent]
})
export class GroupUserAssignModule { }
