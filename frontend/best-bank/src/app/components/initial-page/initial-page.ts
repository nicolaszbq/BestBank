import { Component } from '@angular/core';
import { Balance } from '../usercomponents/balance/balance';
import { Limit } from '../usercomponents/limit/limit';
import { TransferOption } from '../usercomponents/transfer-option/transfer-option';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

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
export class InitialPage {
  constructor(private router:Router, private httpClient: HttpClient){}
  navigateToPage(){
    this.router.navigate([""]);
  }
  logout(){
    sessionStorage.removeItem("auth-token");
    sessionStorage.removeItem("name");
    this.router.navigate(["/login"]);
  }
}
