import {Component, OnInit} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Router} from "@angular/router";
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {MatSnackBar} from "@angular/material/snack-bar";
import {MatTableDataSource} from "@angular/material/table";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{
  cars: any;
  dataSource = new MatTableDataSource();
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
    this.http.get("http://localhost:8080/api/v1/cars").subscribe(data  => {
      this.cars = data;
      this.dataSource.data = this.cars;
      this.dataSource.filterPredicate = (data: any, filter: string) => {
        const brandMatches = data.brand.toLowerCase().includes(filter);
        const modelMatches = data.model.toLowerCase().includes(filter);
        return brandMatches || modelMatches;
      };
    })
  }

  applyBrandModelFilter(event: Event){
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  redirectToPage(car: Object) {
    if (this.dateRange.value.start && this.dateRange.value.end != null){
      this.router.navigate(['/rent'], { state: { data: car, date: this.dateRange.value} });
    } else {
      this._snackBar.open(`Please provide the desired dates before renting a car`, 'Close', {duration: 8000});
    }
  }


  submitDates(): void {
    const startDate = this.dateRange.value.start ? this.dateRange.value.start.toISOString():'';
    const endDate = this.dateRange.value.end ? this.dateRange.value.end.toISOString():'';
    console.log(startDate, endDate)
    this.http.get("http://localhost:8080/api/v1/cars", {
      params: {
        startDate: startDate,
        endDate: endDate
      }
    }).subscribe(data => {
        this.cars = data;
    })
  }
}
