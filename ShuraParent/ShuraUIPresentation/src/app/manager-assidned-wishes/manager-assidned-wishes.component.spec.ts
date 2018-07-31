import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerAssidnedWishesComponent } from './manager-assidned-wishes.component';

describe('ManagerAssidnedWishesComponent', () => {
  let component: ManagerAssidnedWishesComponent;
  let fixture: ComponentFixture<ManagerAssidnedWishesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagerAssidnedWishesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerAssidnedWishesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
