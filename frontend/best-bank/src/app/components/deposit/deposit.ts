import { Component, EventEmitter, inject, Output } from '@angular/core';
import { InputComponent } from '../input-component/input-component';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { PixService } from '../../services/pix-service';
import { ToastrService } from 'ngx-toastr';
import { DepositService } from '../../services/deposit-service';

@Component({
  selector: 'app-deposit',
  standalone: true,
  imports: [
    InputComponent,
    RouterModule,
    ReactiveFormsModule
  ],
  templateUrl: './deposit.html',
  styleUrl: './deposit.scss',
})
export class Deposit {
  
  toastrService = inject(ToastrService);
  @Output("submit") onSubmit = new EventEmitter();
  depositGroup !: FormGroup;
  constructor(
    private router:Router,
    private depositService:DepositService
  ){
    this.depositGroup = new FormGroup({
      amount: new FormControl('',[Validators.required]),
      password: new FormControl('', [Validators.required, Validators.minLength(6)])
    });
  }

  submit(){
    console.log(this.depositGroup.value);
    if (this.depositGroup.invalid) {
      this.toastrService.error("todos os campos devem ser preenchidos!");
      return;
    }
    const {password, amount} = this.depositGroup.value;
    this.depositService.makedeposit(password, Number(amount)).subscribe({
      next: (response) => {
        this.toastrService.success("Deposito feito com sucesso!");
        this.router.navigate(['/afterservice'])
      },
      error: (error) => {
        this.toastrService.error("Erro ao fazer o deposito!");
        console.log("Erro: "+ error);
      }
    });
  }
  navigateToInitialPage(){
    this.router.navigate(['/initial']);
  }
}
