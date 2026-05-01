import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-last-pix',
  imports: [],
  templateUrl: './last-pix.html',
  styleUrl: './last-pix.scss',
})
export class LastPix {
  @Input() name:string = '';
}
