import { Component, EventEmitter, inject, Output } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { InputComponent } from '../input-component/input-component';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { LoginService } from '../../services/login-service';

@Component({
  selector: 'app-signup',
  imports: [
    RouterModule,
    InputComponent,
    ReactiveFormsModule
  ],
  providers:[
    LoginService
  ],
  templateUrl: './signup.html',
  styleUrl: './signup.scss',
})
export class Signup {
  toastrService = inject(ToastrService);
  @Output("submit") onSubmit = new EventEmitter();
  private router = inject(Router);

  signupForm !: FormGroup;
  constructor(private loginService: LoginService){
    this.signupForm = new FormGroup({
      name: new FormControl('', [Validators.required]),
      email: new FormControl('',[Validators.required, Validators.email]),
      birthDate: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required, Validators.minLength(6)]),
      confirmpassword: new FormControl('', [Validators.required, Validators.minLength(6)])

    });
  }

  submit(){
    this.loginService.signup(this.signupForm.value.name,this.signupForm.value.email, this.signupForm.value.birthDate ,this.signupForm.value.password).subscribe({
      next: ()=> {
        this.navigateToLogin();
      },
      error: ()=> console.log("error")
    })
    console.log(this.signupForm.value);
  }
  navigateToLogin(){
    this.router.navigate(['/login']);
  }
}
