import { Component, inject } from '@angular/core';
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
  private router = inject(Router);
  navigate(){
    this.router.navigate(['/login']);
  }
}
