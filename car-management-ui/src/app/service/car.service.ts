import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import {  Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

import { Car } from '../model/car';

@Injectable({
  providedIn: 'root'
})
export class CarService {

  private apiURL = "http://localhost:8080"

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  constructor(private httpClient: HttpClient) { }

  /**
   * Write code on Method
   *
   * @return response()
   */
  getAll(): Observable<Car[]> {
  
    return this.httpClient.get<Car[]>(this.apiURL + '/car')
  
    .pipe(
      catchError(this.errorHandler)
    )
  }

  getById(id: string): Observable<Car> {
    return this.httpClient.get<Car>(this.apiURL + '/car/' + id);
  }

  deleteCarById(id: string): Observable<any> {
    return this.httpClient.put(this.apiURL + '/car', {params: {"carId": id }});
  }

  /** 
   * Write code on Method
   *
   * @return response()
   */
  errorHandler(error:any) {
    let errorMessage = '';
    errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    return throwError(errorMessage);
  }
}
