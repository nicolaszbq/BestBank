import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, switchMap, tap } from 'rxjs';

export interface LastPixResponse{
  id: string;
  recipientName: string;
}
export interface PixResponse{
  id: string;
  fromAccountId: string;
  toAccountId: string;
  amount: number;
  transactionType: string;
  transactionStatus: string;
  timeOfTransaction: string;
}
@Injectable({
  providedIn: 'root',
})
export class PixService {
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

  getLastPixes(): Observable<LastPixResponse[]>{
    const token = sessionStorage.getItem("auth-token");
    if(!token){
        throw new Error("Token inexistente ou invalida!");
    }
    const headers = new HttpHeaders({
      Authorization: `Bearer ${token}`
    });
    return this.httpClient.get<LastPixResponse[]>(
      'http://localhost:8080/lastpix/get',
      { headers }
    );
  }

  process(amount:number,usercode:string): Observable<PixResponse>{
    return this.httpClient.post<PixResponse>(
      "http://localhost:8080/pix/process",
      {amount,usercode},
      {
        headers: this.getAuthHeaders(),
      });
  }

  makepix(amount:number, usercode:string, confirmpassword:string):Observable<PixResponse>{
    return this.checkPass(confirmpassword).pipe(
      switchMap(() => this.process(amount, usercode))
    );
  }

}
