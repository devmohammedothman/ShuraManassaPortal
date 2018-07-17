import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GroupUserAssignComponent } from './group-user-assign.component';

describe('GroupUserAssignComponent', () => {
  let component: GroupUserAssignComponent;
  let fixture: ComponentFixture<GroupUserAssignComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GroupUserAssignComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GroupUserAssignComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
