import {Component, NgModule} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {FormBuilder} from "@angular/forms";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-new-car',
  templateUrl: './new-car.component.html',
  styleUrls: ['./new-car.component.css']
})
export class NewCarComponent {
  form = this.formBuilder.group({
    brand: '',
    model: '',
    doors: '',
    seats: '',
    transmission: '',
    chassis: '',
    pricePerDay: '',
  });
  constructor(private formBuilder: FormBuilder, private http: HttpClient, private _snackBar: MatSnackBar) {}

  submitForm(): void {
    const data = "[" + JSON.stringify(this.form.value) + "]";
    console.log(data)
    this.http.post('http://localhost:8080/api/v1/cars', data, { headers: { 'Content-Type': 'application/json' } }).subscribe(response => {
      console.log(response);
    });
    this._snackBar.open(`Created ${this.form.value.brand} ${this.form.value.model}`, 'Close', { duration: 5000 });
  }


}
