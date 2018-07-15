import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { FuseSharedModule } from '@fuse/shared.module';
 
import { MaterialModule } from '../main/angular-material-elements/material.module';
import { GroupPermComponent } from './group-perm.component';

/*const routes = [
  {
      path        : 'auth/perm',
      component   : GroupPermComponent
  }
];*/

@NgModule({
  declarations: [
    GroupPermComponent
  ],
  imports: [
    //RouterModule.forChild(routes),

    MaterialModule,

    FuseSharedModule
  ]
})
export class GroupPermModule { }
