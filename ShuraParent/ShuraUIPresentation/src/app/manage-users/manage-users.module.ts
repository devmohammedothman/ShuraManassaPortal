import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';

import { MatButtonModule, MatFormFieldModule, MatIconModule, MatInputModule,
   MatSelectModule, MatStepperModule, MatTableModule, MatPaginatorModule, MatDialogModule } from '@angular/material';
import { FuseSharedModule } from '@fuse/shared.module';

import { ManageUsersComponent } from './manage-users.component';

import { AddEditUsersComponent, addEditUsersForm } from './add-edit-users/add-edit-users.component';



const routes = [
  {
      path     : 'manage-users',
      component: ManageUsersComponent
  }
];

@NgModule({
  imports: [
    CommonModule,

    MatButtonModule,
    MatFormFieldModule,
    MatIconModule,
    MatInputModule,
    MatSelectModule,
    MatStepperModule,
    MatTableModule,
    MatPaginatorModule,

    FuseSharedModule,
    MatDialogModule,

    RouterModule.forChild(routes),

  ],
  declarations: [
    ManageUsersComponent ,
    AddEditUsersComponent,
    addEditUsersForm
  ],
  providers: [AddEditUsersComponent],
  entryComponents: [addEditUsersForm]
})
export class ManageUsersModule { }