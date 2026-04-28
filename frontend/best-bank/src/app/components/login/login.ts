import { Component, EventEmitter, inject, Output } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { InputComponent } from '../input-component/input-component';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { email } from '@angular/forms/signals';
@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    RouterModule,
    InputComponent,
    ReactiveFormsModule
  ],
  templateUrl: './login.html',
  styleUrl: './login.scss',
})
export class Login {
  @Output("submit") onSubmit = new EventEmitter();
  loginForm !: FormGroup;
  private router = inject(Router);
  constructor(){
    
    this.loginForm = new FormGroup({
      email: new FormControl('',[Validators.required, Validators.email]),
      password: new FormControl('', [Validators.required, Validators.minLength(6)])

    });
  }
  submit(){
    console.log(this.loginForm.value);
    //essa parte deve ser alterada depois, para só ir para a pagina de login caso o login na API for concluido com sucesso
    this.navigateToInitialPage();
  }
  navigateToSignup(){
    this.router.navigate(['/signup']);
  }
  navigateToInitialPage(){
    this.router.navigate(['/initial']);
  }
}
