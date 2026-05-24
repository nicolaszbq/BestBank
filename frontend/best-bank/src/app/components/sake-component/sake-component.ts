import { Component, EventEmitter, inject, Output } from '@angular/core';
import { InputComponent } from '../input-component/input-component';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { PixService } from '../../services/pix-service';
import { ToastrService } from 'ngx-toastr';
import { DepositService } from '../../services/deposit-service';
import { WithdrawService } from '../../services/withdraw-service';

@Component({
  selector: 'app-sake-component',
  imports: [
    InputComponent,
    RouterModule,
    ReactiveFormsModule
  ],
  templateUrl: './sake-component.html',
  styleUrl: './sake-component.scss',
})
export class SakeComponent {
  toastrService = inject(ToastrService);
  @Output("submit") onSubmit = new EventEmitter();
  sakeGroup !: FormGroup;
  constructor(
    private router:Router,
    private withdrawService:WithdrawService
  ){
    this.sakeGroup = new FormGroup({
      amount: new FormControl('',[Validators.required]),
      password: new FormControl('', [Validators.required, Validators.minLength(6)])

    });
  }

  submit(){
    console.log(this.sakeGroup.value);
    if (this.sakeGroup.invalid) {
      this.toastrService.error("todos os campos devem ser preenchidos!");
      return;
    }
    const {password, amount} = this.sakeGroup.value;
    this.withdrawService.makesake(Number(amount), password).subscribe({
      next: (response) => {
        this.toastrService.success("Saque feito com sucesso!");
        this.router.navigate(['/afterservice'])
      },
      error: (error) => {
        this.toastrService.error("Erro ao fazer o saque!");
        console.log("Erro: "+ error);
      }
    });
  }

  navigateToInitialPage(){
    this.router.navigate(['/initial']);
  }
}
