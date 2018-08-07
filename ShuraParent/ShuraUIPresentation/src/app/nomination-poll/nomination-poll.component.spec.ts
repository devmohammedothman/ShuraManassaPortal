import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NominationPollComponent } from './nomination-poll.component';

describe('NominationPollComponent', () => {
  let component: NominationPollComponent;
  let fixture: ComponentFixture<NominationPollComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NominationPollComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NominationPollComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
