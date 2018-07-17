import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { WelcomeComponent } from './welcome.component';
import { MaterialModule } from '../main/angular-material-elements/material.module';
import { AuthGuard } from '../auth.guard';

const routes = [
  {
      path     : '',
      canActivate: [AuthGuard],
      component: WelcomeComponent
  }
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes),
//material
    MaterialModule
  ],
  declarations: [WelcomeComponent]
})
export class WelcomeModule { }
