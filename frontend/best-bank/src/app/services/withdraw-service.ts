import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, switchMap } from 'rxjs';

export interface SakeResponse{
  amount:number;
}

@Injectable({
  providedIn: 'root',
})
export class WithdrawService {
  constructor(private httpClient:HttpClient){}

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

  private sake(amount:number): Observable<String>{
    return this.httpClient.post(
      'http://localhost:8080/withdraw/sake',
      {amount},
      {
        headers: this.getAuthHeaders(),
        responseType: 'text',
      }
    );
  }

  makesake(amount:number, password:string): Observable<String>{
    return this.checkPass(password).pipe(
      switchMap(() => this.sake(amount))
    );
  }
}
