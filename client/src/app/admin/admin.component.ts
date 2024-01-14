import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent {
  constructor(private router: Router, private http: HttpClient, private _snackBar: MatSnackBar) {}
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
    this.http.delete(`http://localhost:8080/api/v1/cars/${id}`, {observe: 'response', headers: {'Content-Type': 'application/json'}}).subscribe((response: any) => {
      if (response.status === 200) {
        this._snackBar.open(`Car with ID ${id} has been deleted. Refresh to see changes.`, 'Close', {duration: 8000});
      } else {
        this._snackBar.open(`Unable to delete Car with ID ${id}`, 'Close', {duration: 8000});
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
