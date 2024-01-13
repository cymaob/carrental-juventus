import {Component, OnInit, ViewChild} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Router} from "@angular/router";
import {FormBuilder, Validators} from "@angular/forms";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{
  cars: any;
  displayedColumns: string[] = ['brand', 'model', 'doors', 'seats', 'transmission', 'chassis', 'pricePerDay', 'rent'];


  form = this.formBuilder.group({
    brand: [''],
    model: [''],
    doors: [''],
    seats: [''],
    transmission: [''],
    chassis: [''],
    pricePerDay: [''],
  });

  dateForm = this.formBuilder.group({

  })

  constructor(private http: HttpClient, private router: Router, private formBuilder: FormBuilder, private _snackBar: MatSnackBar) {
  }


  ngOnInit(): void {
    console.log("Get http://localhost:8080/api/v1/cars")
    this.http.get("http://localhost:8080/api/v1/cars").subscribe(data => {
      this.cars = data;
    })
  }


  redirectToPage(car: Object) {
    this.router.navigate(['/rent'], { state: { data: car } });
  }


  submitForm(): void {
  }
}
