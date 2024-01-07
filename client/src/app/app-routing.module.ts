import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import {RentComponent} from "./rent/rent.component";
import {AdminComponent} from "./admin/admin.component";
import {NewCarComponent} from "./new-car/new-car.component";
import {EditCarComponent} from "./edit-car/edit-car.component";

const routes: Routes = [
  {path: '', component: HomeComponent}, // This is the default route
  {path: 'rent', component: RentComponent},
  {path: 'admin', component: AdminComponent},
  {path: 'new-car', component: NewCarComponent},
  {path: 'edit-car', component: EditCarComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
