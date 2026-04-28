import { Component, EventEmitter, inject, Output } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { InputComponent } from '../input-component/input-component';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-signup',
  imports: [
    RouterModule,
    InputComponent,
    ReactiveFormsModule
  ],
  templateUrl: './signup.html',
  styleUrl: './signup.scss',
})
export class Signup {
  @Output("submit") onSubmit = new EventEmitter();
  private router = inject(Router);

  signupForm !: FormGroup;
  constructor(){
    this.signupForm = new FormGroup({
      name: new FormControl('', [Validators.required]),
      email: new FormControl('',[Validators.required, Validators.email]),
      birthDate: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required, Validators.minLength(6)]),
      confirmpassword: new FormControl('', [Validators.required, Validators.minLength(6)])

    });
  }

  submit(){
    console.log(this.signupForm.value);
  }
  navigateToLogin(){
    this.router.navigate(['/login']);
  }
}
