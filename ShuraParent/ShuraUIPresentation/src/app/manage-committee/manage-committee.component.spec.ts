import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManageCommitteeComponent } from './manage-committee.component';

describe('ManageCommitteeComponent', () => {
  let component: ManageCommitteeComponent;
  let fixture: ComponentFixture<ManageCommitteeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManageCommitteeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManageCommitteeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
