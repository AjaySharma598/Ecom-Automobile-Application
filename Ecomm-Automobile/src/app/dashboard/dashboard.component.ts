import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Vehicle } from '../services/model/vehicle';
import { UserServicesService } from '../services/user-services.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  vehicleData:Vehicle[]=[];
  
  constructor(private services:UserServicesService,private route:Router){}
  cartno:number=this.services.cartLength;
  ngOnInit(): void {
    this.cartno=this.services.cartLength;
    console.log("cartLength..........cart no",this.services.cartLength)
  }

  logout(){
    this.services.isLoggedIn=false;

   this.route.navigate(['Login']);
  }
  }

