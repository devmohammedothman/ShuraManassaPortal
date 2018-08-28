import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MemberNominationsComponent } from './member-nominations.component';

describe('MemberNominationsComponent', () => {
  let component: MemberNominationsComponent;
  let fixture: ComponentFixture<MemberNominationsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MemberNominationsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MemberNominationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
