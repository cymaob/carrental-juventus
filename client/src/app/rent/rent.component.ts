import {Component, OnInit} from '@angular/core';
import {NgFor} from '@angular/common';
import {MatGridListModule} from '@angular/material/grid-list';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-rent',
  templateUrl: './rent.component.html',
  styleUrls: ['./rent.component.css']
})

export class RentComponent implements OnInit{
  car: any;
  startDate: any;
  endDate: any;
  body: any;
  isConfirmed: boolean = false;

  constructor(private http: HttpClient) {
  }

  ngOnInit(): void {
    this.car = history.state.data;
    this.startDate = history.state.date.start;
    this.endDate = history.state.date.end;
  }

  rentCar(){
    this.body = {
      car: {
        "id": this.car.id
      },
      rentStartDate: this.startDate,
      rentEndDate: this.endDate
    }

    this.http.post('http://localhost:8080/api/v1/rentals', this.body, {observe: 'response', headers: {'Content-Type': 'application/json'}}).subscribe((response: any) => {
      if (response.status === 200) {
        console.log("rented")
        this.isConfirmed = true;
      } else {
        console.log("not rented")
      }
    });

  }

}

