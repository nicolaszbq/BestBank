import { ChangeDetectorRef, Component } from '@angular/core';
import { LastPix } from './last-pix/last-pix';
import { Router } from '@angular/router';
import { LastPixResponse, PixService } from '../../services/pix-service';

@Component({
  selector: 'app-pix-area',
  imports: [
    LastPix
  ],
  templateUrl: './pix-area.html',
  styleUrl: './pix-area.scss',
})
export class PixArea {
  lastpixes:LastPixResponse[] = [];

  page:string = "/initial";
  constructor(
    private router:Router,
    private pixservice: PixService,
    private cdr: ChangeDetectorRef
  ){}

  ngOnInit():void{
    this.pixservice.getLastPixes().subscribe({
      next: (pixes) =>{

        this.lastpixes = pixes;
        this.cdr.detectChanges();
      },
      error: (error) =>{
        console.log("Erro ao fazer a requisição: "+ error);
      }
         
    })
    
  }
  navigateToPage(){
    this.router.navigate([this.page]);
  }

  navigateToTransfer(){
    this.router.navigate(["/newTransfer"])
  }
}
