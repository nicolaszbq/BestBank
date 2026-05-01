import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { InputComponent } from '../../input-component/input-component';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

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
  @Output("submit") onSubmit = new EventEmitter();
  newTransferGroup !: FormGroup;

  constructor(private router:Router){
    this.newTransferGroup = new FormGroup({
      amount: new FormControl('',[Validators.required]),
      userCode: new FormControl('',[Validators.required]),
      password: new FormControl('', [Validators.required, Validators.minLength(6)])

    });
  }
  submit(){
    console.log(this.newTransferGroup.value);
    //essa parte deve ser alterada depois, para só ir para a pagina de login caso o login na API for concluido com sucesso
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
