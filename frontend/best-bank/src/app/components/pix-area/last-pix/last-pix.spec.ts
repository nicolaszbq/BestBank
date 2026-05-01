import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LastPix } from './last-pix';

describe('LastPix', () => {
  let component: LastPix;
  let fixture: ComponentFixture<LastPix>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LastPix],
    }).compileComponents();

    fixture = TestBed.createComponent(LastPix);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
