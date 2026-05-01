import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PixArea } from './pix-area';

describe('PixArea', () => {
  let component: PixArea;
  let fixture: ComponentFixture<PixArea>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PixArea],
    }).compileComponents();

    fixture = TestBed.createComponent(PixArea);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
