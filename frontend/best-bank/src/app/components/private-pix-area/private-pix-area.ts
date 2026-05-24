import { Component, EventEmitter, inject, Output } from '@angular/core';
import { InputComponent } from '../input-component/input-component';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';
import { PixService } from '../../services/pix-service';
import { TransactionService } from '../../services/transaction-service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-private-pix-area',
  imports: [
    InputComponent,
    ReactiveFormsModule
  ],
  templateUrl: './private-pix-area.html',
  styleUrl: './private-pix-area.scss',
})
export class PrivatePixArea {

  toastrService = inject(ToastrService);
  depositGroup !: FormGroup;
  @Output("submit") onSubmit = new EventEmitter();

  
  constructor(
    private router:Router,
    private pixService:PixService,
    private transactionService: TransactionService
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
    const transactionId: string = sessionStorage.getItem("atual_id_cached")!;
    console.log("TRANSCATION ID: "+ transactionId);
    const {password, amount} = this.depositGroup.value;
    this.transactionService.getUserIdByTransactionId(transactionId).subscribe({
      next: (user_id) =>{
            console.log("USER ID: "+ user_id);
            this.pixService.makepix(Number(amount), user_id,password).subscribe({
          next: (response) => {
            this.toastrService.success("Deposito feito com sucesso!");
            this.router.navigate(['/afterservice'])
          },
          error: (error) => {
            this.toastrService.error("Erro ao fazer o deposito!");
            console.log("Erro: "+ error);
          }
        });
      },
      error: (error) => {
        console.log("❌ ERRO COMPLETO:", error);  // ← Adicione isso
        console.log("Status:", error.status);    // ← Status HTTP
        console.log("Message:", error.message);  // ← Mensagem
        console.log("Body:", error.error);
        this.toastrService.error("Erro ao obter ID do usuário!");
      }
    })
  }
  navigateToInitialPage(){
    this.router.navigate(['/initial']);
  }
}
