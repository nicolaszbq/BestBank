import { Component } from '@angular/core';
import { Balance } from '../usercomponents/balance/balance';
import { Limit } from '../usercomponents/limit/limit';
import { TransferOption } from '../usercomponents/transfer-option/transfer-option';
import { Router } from '@angular/router';

@Component({
  selector: 'app-initial-page',
  imports: [
    Balance,
    Limit,
    TransferOption
  ],
  templateUrl: './initial-page.html',
  styleUrl: './initial-page.scss',
})
export class InitialPage {}
