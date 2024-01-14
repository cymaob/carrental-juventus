import {Component} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {FormBuilder, Validators} from "@angular/forms";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-new-car',
  templateUrl: './new-car.component.html',
  styleUrls: ['./new-car.component.css']
})
export class NewCarComponent {
  form = this.formBuilder.group({
    brand: ['', Validators.required],
    model: ['', Validators.required],
    doors: ['', Validators.required],
    seats: ['', Validators.required],
    transmission: ['', Validators.required],
    chassis: ['', Validators.required],
    pricePerDay: ['', Validators.required],
  });

  constructor(private formBuilder: FormBuilder, private http: HttpClient, private _snackBar: MatSnackBar) {
  }

  submitForm(): void {
    if (this.form.valid) {
      const data = "[" + JSON.stringify(this.form.value) + "]";
      this.http.post('http://localhost:8080/api/v1/cars', data, {observe: 'response', headers: {'Content-Type': 'application/json'}}).subscribe((response: any) => {
        if (response.status === 201) {
          this._snackBar.open(`Created ${this.form.value.brand} ${this.form.value.model}`, 'Close', {duration: 5000});
          console.log("Sending data to backend")
        } else {
          this._snackBar.open(`Failed to create ${this.form.value.brand} ${this.form.value.model}. Please check your input`, 'Close', {duration: 5000});
          console.log("Failed to create car. Server error")
        }
      });
    } else {
      this._snackBar.open(`Form is invalid. Please check your input!`, 'Close', {duration: 5000});
    }
  }


}
