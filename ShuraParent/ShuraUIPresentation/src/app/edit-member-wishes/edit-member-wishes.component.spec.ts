import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditMemberWishesComponent } from './edit-member-wishes.component';

describe('EditMemberWishesComponent', () => {
  let component: EditMemberWishesComponent;
  let fixture: ComponentFixture<EditMemberWishesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditMemberWishesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditMemberWishesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
