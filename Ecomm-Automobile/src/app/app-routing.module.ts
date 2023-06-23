import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthguardGuard } from './authguard.guard';
import { CarDetailComponent } from './car-detail/car-detail.component';
import { CartPageComponent } from './cart-page/cart-page.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginComponent } from './login/login.component';
import { NotAllowedGuard } from './not-allowed.guard';
import { RegistrationFormComponent } from './registration-form/registration-form.component';
import { VehicleDashboardComponent } from './vehicle-dashboard/vehicle-dashboard.component';

const routes: Routes = [
  {path:'Registration',component:RegistrationFormComponent},
  {path:'Login',component:LoginComponent,canDeactivate:[NotAllowedGuard]},
  {path:'Dashboard',component:DashboardComponent},
  {path:'vehicleDashboard',component:VehicleDashboardComponent,canActivate:[AuthguardGuard]},
  {path:'carDetail/:vehicleId',component:CarDetailComponent},
  {path:'CartPage',component:CartPageComponent,canActivate:[AuthguardGuard]},

];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
