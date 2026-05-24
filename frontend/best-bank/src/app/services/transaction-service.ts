import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class TransactionService {
  constructor(private httpClient: HttpClient) {}
  private getAuthHeaders(): HttpHeaders {
    const token = sessionStorage.getItem("auth-token");

    if (!token) {
      throw new Error("Token inexistente ou inválido!");
    }

    return new HttpHeaders({
      Authorization: `Bearer ${token}`,
    });
  }

  checkPass(password: string): Observable<string> {
    return this.httpClient.post(
      'http://localhost:8080/account/checkpass',
      { password },
      {
        headers: this.getAuthHeaders(),
        responseType: 'text',
      }
    );
  }

  getUserIdByTransactionId(transactionId:string): Observable<string>{
      const token = sessionStorage.getItem("auth-token");
      if(!token){
          throw new Error("Token inexistente ou invalida!");
      }
      const headers = new HttpHeaders({
        Authorization: `Bearer ${token}`,
        'Content-Type': 'application/json'
      });
      return this.httpClient.post<string>(
        'http://localhost:8080/transactions/getUserIdByTransactionId',
        { transactionId },
        { headers,
          responseType: 'text' as 'json'
        }
      );
    }
}
