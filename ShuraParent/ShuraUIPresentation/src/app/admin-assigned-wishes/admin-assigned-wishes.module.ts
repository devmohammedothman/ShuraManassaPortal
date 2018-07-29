import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { AdminAssignedWishesComponent } from './admin-assigned-wishes.component';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatInputModule, MatButtonModule, MatAutocompleteModule, MatSelectModule } from '@angular/material';

const routes = [
  {
      path     : 'aaw',
      component: AdminAssignedWishesComponent
  }
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(routes),

    BrowserModule,
    BrowserAnimationsModule,

    FormsModule,
    ReactiveFormsModule,

    MatInputModule,
    MatAutocompleteModule,
    MatButtonModule,
    MatSelectModule
  ],
  declarations: [AdminAssignedWishesComponent]
})
export class AdminAssignedWishesModule { }
