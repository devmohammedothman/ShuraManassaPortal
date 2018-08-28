import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { MemberNominationsComponent } from './member-nominations.component';
import { MaterialModule } from '../main/angular-material-elements/material.module';
import { FuseSharedModule } from '@fuse/shared.module';
import { TranslateModule } from '@ngx-translate/core';
import { MatTabsModule } from '@angular/material';
import { MemberWishesModule } from '../member-wishes/member-wishes.module';
import { NominationPollModule } from '../nomination-poll/nomination-poll.module';
import { EditMemberWishesModule } from '../edit-member-wishes/edit-member-wishes.module';

const routes = [
  {
      path     : 'member-nominations',
      component: MemberNominationsComponent
  }
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes),

    TranslateModule,

    // material
    MaterialModule,
    MatTabsModule,

    FuseSharedModule,
    TranslateModule,

    // Included Modules
    MemberWishesModule,
    NominationPollModule,
    EditMemberWishesModule

  ],
  declarations: [MemberNominationsComponent]
})
export class MemberNominationsModule { }
