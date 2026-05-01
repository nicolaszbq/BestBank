import { Component, EventEmitter, inject, Output } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { InputComponent } from '../input-component/input-component';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { email } from '@angular/forms/signals';
import { LoginService } from '../../services/login-service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    RouterModule,
    InputComponent,
    ReactiveFormsModule
  ],
  providers:[
    LoginService
  ],
  templateUrl: './login.html',
  styleUrl: './login.scss',
})
export class Login {
  toastrService = inject(ToastrService);
  @Output("submit") onSubmit = new EventEmitter();
  loginForm !: FormGroup;
  private router = inject(Router);
  constructor( private loginService: LoginService){
    this.loginForm = new FormGroup({
      email: new FormControl('',[Validators.required, Validators.email]),
      password: new FormControl('', [Validators.required, Validators.minLength(6)])
    });
  }
  submit(){
    this.loginService.login(this.loginForm.value.email, this.loginForm.value.password).subscribe({
      next: ()=> {
        this.toastrService.success("Login efetuado com sucesso!")
        this.navigateToInitialPage();
      },
      error: ()=> this.toastrService.error("Login errado!")
    })
    console.log(this.loginForm.value);
    //essa parte deve ser alterada depois, para só ir para a pagina de login caso o login na API for concluido com sucesso
    
  }
  navigateToSignup(){
    this.router.navigate(['/signup']);
  }
  navigateToInitialPage(){
    this.router.navigate(['/initial']);
  }
}
