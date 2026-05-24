import { Component, inject, signal } from '@angular/core';
import { Router, RouterModule, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-home-component',
  imports: [
    RouterOutlet,
    RouterModule],
  templateUrl: './home-component.html',
  styleUrl: './home-component.scss',
})
export class HomeComponent {
  
  intlinetext:string = "";
  text = signal<string | null>(null);
  isnull = signal<boolean | null>(true);
  ngOnInit(): void{
    if(sessionStorage.getItem("auth-token") != null){
        this.text.set("User Area");
        this.isnull.set(false);
    }else{
      this.isnull.set(true)
      this.text.set("Login/SignUp");
    }
  }
  private router = inject(Router);
  navigate(){
    this.router.navigate(['/login']);
  }
}
