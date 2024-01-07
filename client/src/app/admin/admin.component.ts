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
  displayedColumns: string[] = ['brand', 'model', 'doors', 'seats', 'transmission', 'chassis', 'pricePerDay', 'edit', 'delete'];


  redirectToPage(page: string) {
    this.router.navigate([page])
  }

  goToEdit(car: Object) {
    this.router.navigate(['/edit-car'], { state: { data: car } });
  }

  deleteCar(id: string){
    console.log(id)
    this.http.delete(`http://localhost:8080/api/v1/cars/${id}`, {headers: {'Content-Type': 'application/json'}}).subscribe((response: any) => {
      if (response && response.status === 200) {
        console.log("Deleted")
      } else {
        console.log("Failed to delete car. Server error")
      }
    });
  }

  ngOnInit(): void {
    console.log("Get http://localhost:8080/api/v1/cars")
    this.http.get("http://localhost:8080/api/v1/cars").subscribe(data => {
      this.cars = data;
    })
  }
}
