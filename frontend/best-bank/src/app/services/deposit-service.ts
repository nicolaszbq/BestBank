import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, switchMap } from 'rxjs';


export interface DepositResponse{
  amount:number;
}
@Injectable({
  providedIn: 'root',
})
export class DepositService {
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
    console.log("PASS: " + password)
    return this.httpClient.post(
      'http://localhost:8080/account/checkpass',
      { password },
      {
        headers: this.getAuthHeaders(),
        responseType: 'text',
      }
    );
    console.log("Passou do CHECK")
  }

  deposit(amount:number): Observable<String>{
    return this.httpClient.post(
      'http://localhost:8080/deposit/make',
      {amount},
      {
        headers: this.getAuthHeaders(),
        responseType: 'text',
      }
    );
    console.log("PASSOU PELO DEPOSIT")
  }
  makedeposit(password:string, amount:number): Observable<String>{
    return this.checkPass(password).pipe(
          switchMap(() => this.deposit(amount))
        );
  }
}
