import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrivatePixArea } from './private-pix-area';

describe('PrivatePixArea', () => {
  let component: PrivatePixArea;
  let fixture: ComponentFixture<PrivatePixArea>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PrivatePixArea],
    }).compileComponents();

    fixture = TestBed.createComponent(PrivatePixArea);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
