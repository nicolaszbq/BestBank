import { Component } from '@angular/core';
import { LastPix } from './last-pix/last-pix';
import { Router } from '@angular/router';

@Component({
  selector: 'app-pix-area',
  imports: [
    LastPix
  ],
  templateUrl: './pix-area.html',
  styleUrl: './pix-area.scss',
})
export class PixArea {
  page:string = "/initial";
  constructor(private router:Router){}
  navigateToPage(){
    this.router.navigate([this.page]);
  }

  navigateToTransfer(){
    this.router.navigate(["/newTransfer"])
  }
}
