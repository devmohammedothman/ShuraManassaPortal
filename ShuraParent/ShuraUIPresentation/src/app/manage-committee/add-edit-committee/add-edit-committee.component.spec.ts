import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddEditCommitteeComponent } from './add-edit-committee.component';

describe('AddEditCommitteeComponent', () => {
  let component: AddEditCommitteeComponent;
  let fixture: ComponentFixture<AddEditCommitteeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddEditCommitteeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddEditCommitteeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
