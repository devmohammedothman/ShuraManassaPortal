import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { FuseSharedModule } from '@fuse/shared.module';

import { LoginComponent } from './login.component';
import { MaterialModule }  from '../main/angular-material-elements/material.module';

const routes = [
    {
        path     : 'login',
        component: LoginComponent
    }
];

@NgModule({
    declarations: [
        LoginComponent
    ],
    imports     : [
        RouterModule.forChild(routes),
        ReactiveFormsModule,

        FuseSharedModule,
        MaterialModule
    ],
     exports: [
    FormsModule,
    ReactiveFormsModule,
    MaterialModule
  ]
})
export class LoginModule
{
}
