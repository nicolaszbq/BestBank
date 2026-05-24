import { Component, EventEmitter, inject, Input, Output } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { InputComponent } from '../../input-component/input-component';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { PixService } from '../../../services/pix-service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-new-transfer',
  standalone:true,
  imports: [
    InputComponent,
    RouterModule,
    InputComponent,
    ReactiveFormsModule
  ],
  templateUrl: './new-transfer.html',
  styleUrl: './new-transfer.scss',
})
export class NewTransfer {
  
  toastrService = inject(ToastrService);
  @Output("submit") onSubmit = new EventEmitter();
  newTransferGroup !: FormGroup;

  constructor(
    private router:Router,
    private pixservice:PixService
  ){
    this.newTransferGroup = new FormGroup({
      amount: new FormControl('',[Validators.required]),
      userCode: new FormControl('',[Validators.required]),
      password: new FormControl('', [Validators.required, Validators.minLength(6)])

    });
  }
  submit(){
    console.log(this.newTransferGroup.value);
    if (this.newTransferGroup.invalid) {
      return;
    }
    const { amount, userCode, password } = this.newTransferGroup.value;
    this.pixservice.makepix(Number(amount), userCode, password).subscribe({
      next: (response) => {
        console.log('Pix realizado com sucesso:', response);
        this.toastrService.success("Transação efetuada com sucesso!");
        this.router.navigate(['/afterservice']);
      },
      error: (error) => {
        this.toastrService.error("Não foi possível efetuar a transação!");
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
