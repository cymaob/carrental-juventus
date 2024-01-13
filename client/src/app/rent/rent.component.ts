import {Component, OnInit} from '@angular/core';
import {NgFor} from '@angular/common';
import {MatGridListModule} from '@angular/material/grid-list';

@Component({
  selector: 'app-rent',
  templateUrl: './rent.component.html',
  styleUrls: ['./rent.component.css']
})

export class RentComponent implements OnInit{
  car: any;
  startDate: any;
  endDate: any;

  ngOnInit(): void {
    this.car = history.state.data;
    this.startDate = history.state.date.start;
    this.endDate = history.state.date.end;
    console.log(this.car)
  }

}

