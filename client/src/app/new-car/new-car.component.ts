import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

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
  constructor(private formBuilder: FormBuilder, private http: HttpClient) {}

  submitForm(): void {
    const data = "[" + JSON.stringify(this.form.value) + "]";
    console.log(data)
    this.http.post('http://localhost:8080/api/v1/cars', data, { headers: { 'Content-Type': 'application/json' } }).subscribe(response => {
      console.log(response);
    });
  }


}
