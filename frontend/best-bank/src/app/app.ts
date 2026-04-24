import { Component, EventEmitter, inject, Output, signal } from '@angular/core';
import { Router, RouterLink, RouterOutlet, RouterLinkWithHref } from '@angular/router';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-root',
  imports: [
    RouterOutlet,
    RouterModule
],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  private router = inject(Router);
  protected readonly title = signal('best-bank');

  
}
