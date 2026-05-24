import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AfterServicesArea } from './after-services-area';

describe('AfterServicesArea', () => {
  let component: AfterServicesArea;
  let fixture: ComponentFixture<AfterServicesArea>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AfterServicesArea],
    }).compileComponents();

    fixture = TestBed.createComponent(AfterServicesArea);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
