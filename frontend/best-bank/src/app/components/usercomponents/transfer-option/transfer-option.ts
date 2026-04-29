import { Component, inject, Input } from '@angular/core';
import { SharedModuleModule } from '../../../modules/shared-module/shared-module-module';
import { Route, Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-transfer-option',
  standalone: true,
  imports: [
    RouterModule,
    SharedModuleModule
  ],
  templateUrl: './transfer-option.html',
  styleUrl: './transfer-option.scss',
})
export class TransferOption {
  @Input() name: string = "";
  @Input() page: string = "";

  constructor(private router:Router){}
  navigateToPage(){
    this.router.navigate([this.page]);
  }
}
