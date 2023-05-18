import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CardService {

  private API_SERVER = "http://localhost:8080/card/register";

  constructor(private httpClient: HttpClient) { }

  public saveCard(card: any): Observable<any> {
    return this.httpClient.post(this.API_SERVER , card);
  }
}
