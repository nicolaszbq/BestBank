import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Limit } from './limit';

describe('Limit', () => {
  let component: Limit;
  let fixture: ComponentFixture<Limit>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Limit],
    }).compileComponents();

    fixture = TestBed.createComponent(Limit);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
