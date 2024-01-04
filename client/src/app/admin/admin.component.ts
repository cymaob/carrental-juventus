import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent {
  constructor(private router: Router, private http: HttpClient) {}
  cars: any;
  displayedColumns: string[] = ['brand', 'model', 'doors', 'seats', 'transmission', 'chassis', 'pricePerDay'];


  redirectToPage(page: string) {
    this.router.navigate([page])
  }

  ngOnInit(): void {
    console.log("Get http://localhost:8080/api/v1/cars")
    this.http.get("http://localhost:8080/api/v1/cars").subscribe(data => {
      this.cars = data;
    })
  }
}
