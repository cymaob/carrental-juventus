import {Component, OnInit, ViewChild} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Router} from "@angular/router";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{
  cars: any;
  displayedColumns: string[] = ['brand', 'model', 'doors', 'seats', 'transmission', 'chassis', 'pricePerDay', 'rent'];


  dateRange = new FormGroup({
    start: new FormControl<Date | null>(null),
    end: new FormControl<Date | null>(null),
  });


  form = this.formBuilder.group({
    brand: [''],
    model: [''],
    doors: [''],
    seats: [''],
    transmission: [''],
    chassis: [''],
    pricePerDay: [''],
  });


  constructor(private http: HttpClient, private router: Router, private formBuilder: FormBuilder, private _snackBar: MatSnackBar) {
  }


  ngOnInit(): void {
    console.log("Get http://localhost:8080/api/v1/cars")
    this.http.get("http://localhost:8080/api/v1/cars").subscribe(data => {
      this.cars = data;
    })
  }


  redirectToPage(car: Object) {
    if (this.dateRange.value.start && this.dateRange.value.end != null){
      this.router.navigate(['/rent'], { state: { data: car, date: this.dateRange.value} });
    } else {
      this._snackBar.open(`Please provide the desired dates first`, 'Close', {duration: 8000});
    }
  }


  submitForm(): void {
    console.log(this.dateRange.value)
    console.log(typeof this.dateRange.value.end)
  }
}
