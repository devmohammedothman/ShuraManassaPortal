import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MemberWishesComponent } from './member-wishes.component';

describe('MemberWishesComponent', () => {
  let component: MemberWishesComponent;
  let fixture: ComponentFixture<MemberWishesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MemberWishesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MemberWishesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
