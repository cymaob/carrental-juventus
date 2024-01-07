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
  ngOnInit(): void {
    this.car = history.state.data;
    console.log(this.car)
  }

}

