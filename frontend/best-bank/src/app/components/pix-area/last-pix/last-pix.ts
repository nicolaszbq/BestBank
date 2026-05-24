import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-last-pix',
  imports: [],
  templateUrl: './last-pix.html',
  styleUrl: './last-pix.scss',
})
export class LastPix {
  constructor(private router:Router){}
  @Input() name:string = '';
  @Input() id: string='';

  sendPixCall(){
    console.log(this.id)
    sessionStorage.setItem("atual_id_cached",this.id);
    this.router.navigate(['/privatepix']);
  }
}
