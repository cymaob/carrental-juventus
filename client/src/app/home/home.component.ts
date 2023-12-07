import {Component, OnInit} from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{
  cars: any;

  constructor(private http: HttpClient) { }
  ngOnInit(): void {
    this.http.get("http://localhost:8080/api/v1/cars/").subscribe(data => {
      this.cars = data;
    })
  }

}
