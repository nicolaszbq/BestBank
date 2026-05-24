import { Component, EventEmitter, inject, Output } from '@angular/core';
import { InputComponent } from '../input-component/input-component';
import { Router, RouterModule } from '@angular/router';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { PixService } from '../../services/pix-service';

@Component({
  selector: 'app-known-transfer',
  standalone:true,
  imports: [
    InputComponent,
    RouterModule,
    ReactiveFormsModule
  ],
  templateUrl: './known-transfer.html',
  styleUrl: './known-transfer.scss',
})
export class KnownTransfer {
  toastrService = inject(ToastrService);
  @Output("submit") onSubmit = new EventEmitter();
  knownTransferGroup !: FormGroup;

  constructor(
    private router:Router,
    private pixservice:PixService
  ){
    this.knownTransferGroup = new FormGroup({
      amount: new FormControl('',[Validators.required]),
      userCode: new FormControl('',[Validators.required]),
      password: new FormControl('', [Validators.required, Validators.minLength(6)])
    });
  }
  submit(){
    console.log(this.knownTransferGroup.value);
    if (this.knownTransferGroup.invalid) {
      return;
    }
    const { amount, userCode, password } = this.knownTransferGroup.value;
    this.pixservice.makepix(Number(amount), userCode, password).subscribe({
      next: (response) => {
        console.log('Pix realizado com sucesso:', response);
        this.toastrService.success("Pix efetuado com sucesso!");
        this.router.navigate(['/afterservice']);
      },
      error: (error) => {
        this.toastrService.error("Não foi possível efetuar o Pix!");
        console.log('Erro ao realizar Pix:', error);
      }
    });
  }
  navigateToSignup(){
    this.router.navigate(['/signup']);
  }
  navigateToInitialPage(){
    this.router.navigate(['/initial']);
  }
  navigateToPage(){
    this.router.navigate(["/pixarea"]);
  }
}
