import { Component, inject, Input } from '@angular/core';
import { SharedModuleModule } from '../../../modules/shared-module/shared-module-module';

@Component({
  selector: 'app-transfer-option',
  
  imports: [
    SharedModuleModule
  ],
  templateUrl: './transfer-option.html',
  styleUrl: './transfer-option.scss',
})
export class TransferOption {
  
  private router = inject(SharedModuleModule);
  @Input() name: string = "";
  @Input() page: string = "";
}
