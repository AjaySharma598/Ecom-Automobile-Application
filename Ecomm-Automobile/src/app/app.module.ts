import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { RegistrationFormComponent } from './registration-form/registration-form.component';
import { LoginComponent } from './login/login.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import {MatFormFieldModule} from '@angular/material/form-field';
import { ReactiveFormsModule} from '@angular/forms';
import { FormsModule } from '@angular/forms';

import { LayoutModule } from '@angular/cdk/layout';
import{MatSelectModule} from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';
import{MatRadioModule} from '@angular/material/radio';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatNativeDateModule} from '@angular/material/core';
import {MatCardModule} from '@angular/material/card';
import { HttpClientModule } from '@angular/common/http';
import { VehicleDashboardComponent } from './vehicle-dashboard/vehicle-dashboard.component';
import { CarDetailComponent } from './car-detail/car-detail.component';
import { CartPageComponent } from './cart-page/cart-page.component';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    RegistrationFormComponent,
    LoginComponent,
    VehicleDashboardComponent,
    CarDetailComponent,
    CartPageComponent
  ],
  imports: [
    BrowserModule,MatToolbarModule,MatButtonModule,MatSidenavModule,MatIconModule,MatListModule,MatFormFieldModule,
    AppRoutingModule,ReactiveFormsModule,FormsModule,LayoutModule,MatSelectModule,MatInputModule,MatRadioModule,
    BrowserAnimationsModule,MatDatepickerModule,MatNativeDateModule,MatCardModule,HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
