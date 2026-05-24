import { Component, OnInit, signal } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { UserService } from '../../services/user-service';

@Component({
  selector: 'app-after-services-area',
  imports: [
    RouterModule
  ],
  templateUrl: './after-services-area.html',
  styleUrl: './after-services-area.scss',
})
export class AfterServicesArea implements OnInit {

  balance = signal<number | null>(null);
  errorMessage = signal<string | null>(null);
  isLoading = signal<boolean>(true);

  constructor(
    private router:Router,
    private userService: UserService
  ){}
  navigateToInitialPage(){
    this.router.navigate(['/initial']);
  }
  navigateToTransferPage(){
    this.router.navigate(['/newTransfer'])
  }

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
