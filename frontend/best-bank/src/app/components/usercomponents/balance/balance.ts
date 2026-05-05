import { Component, Input, OnInit, signal, Signal } from '@angular/core';
import { UserService } from '../../../services/user-service';
import { Observable } from 'rxjs';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-balance',
  imports: [
    CommonModule
  ],
  templateUrl: './balance.html',
  styleUrl: './balance.scss',
})
export class Balance implements OnInit {
  balance = signal<number | null>(null);
  errorMessage = signal<string | null>(null);
  isLoading = signal<boolean>(true);

  constructor(private userService: UserService){}

  ngOnInit(): void {
    try {
      this.userService.getBalance().subscribe({
        next: (value) => {
          this.balance.set(value);
          this.isLoading.set(false);
        },
        error: (error) => {
          console.error('Erro ao buscar saldo:', error);
          this.errorMessage.set('Erro ao buscar saldo');
          this.isLoading.set(false);
        }
      });
    } catch (e) {
      this.errorMessage.set("e as Error");
    }
  }
}
  
