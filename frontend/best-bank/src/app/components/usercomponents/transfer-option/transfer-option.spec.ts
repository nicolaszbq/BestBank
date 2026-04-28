import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TransferOption } from './transfer-option';

describe('TransferOption', () => {
  let component: TransferOption;
  let fixture: ComponentFixture<TransferOption>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TransferOption],
    }).compileComponents();

    fixture = TestBed.createComponent(TransferOption);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
