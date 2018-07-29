import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminAssignedWishesComponent } from './admin-assigned-wishes.component';

describe('AdminAssignedWishesComponent', () => {
  let component: AdminAssignedWishesComponent;
  let fixture: ComponentFixture<AdminAssignedWishesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminAssignedWishesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminAssignedWishesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
