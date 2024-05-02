import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {catchError, Observable, throwError} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class UrlShortService {

  serviceUrl: string='';
  constructor(private http: HttpClient) {
    this.serviceUrl = "http://localhost:8080/minu/shorten"
  }

  getShortUrl(url: string): Observable<string> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'text/plain'
      }),
      responseType: 'text' as 'json' // Set responseType as 'text' for handling plain text response
    };

    return this.http.post<string>(this.serviceUrl, url, httpOptions)
      .pipe(
        catchError((error: any) => {
          // Implement error handling as needed
          return throwError(error); // Rethrow the error for further handling
        })
      );
  }

}
