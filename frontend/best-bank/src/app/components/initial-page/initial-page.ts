import { Component } from '@angular/core';
import { Balance } from '../usercomponents/balance/balance';
import { Limit } from '../usercomponents/limit/limit';

@Component({
  selector: 'app-initial-page',
  imports: [
    Balance,
    Limit
  ],
  templateUrl: './initial-page.html',
  styleUrl: './initial-page.scss',
})
export class InitialPage {}
