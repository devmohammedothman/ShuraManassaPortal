import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GroupPermComponent } from './group-perm.component';

describe('GroupPermComponent', () => {
  let component: GroupPermComponent;
  let fixture: ComponentFixture<GroupPermComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GroupPermComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GroupPermComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
