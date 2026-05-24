import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KnownTransfer } from './known-transfer';

describe('KnownTransfer', () => {
  let component: KnownTransfer;
  let fixture: ComponentFixture<KnownTransfer>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [KnownTransfer],
    }).compileComponents();

    fixture = TestBed.createComponent(KnownTransfer);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
