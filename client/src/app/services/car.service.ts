// car.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CarService {
  private apiUrl = 'http://localhost:8080/api/v1/cars';

  constructor(private http: HttpClient) {}

  getAllCars(): Observable<any> {
    return this.http.get(this.apiUrl);
  }

  getCarById(id: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/${id}`);
  }
}
