import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor(private httpClient: HttpClient){}

  getBalance(): Observable<number> {
    const token = sessionStorage.getItem('auth-token');
    if (!token) {
      throw new Error('Token não encontrado no sessionStorage');
    }

    const headers = new HttpHeaders({
      Authorization: `Bearer ${token}`
    });

    return this.httpClient.get<number>(
      'http://localhost:8080/account/getAmountByToken',
      { headers }
    );
  }

  private getAuthHeaders(): HttpHeaders {
      const token = sessionStorage.getItem("auth-token")
      if (!token) {
        // Você pode lançar um erro ou retornar headers vazios – depende da sua política de tratamento de sessão.
        throw new Error('Token não encontrado no localStorage');
      }
      return new HttpHeaders({
        Authorization: `Bearer ${token}`
      });
    }
}


