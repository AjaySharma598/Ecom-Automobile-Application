import { Component, OnInit } from '@angular/core';
import { Vehicle } from '../services/model/vehicle';
import { UserServicesService } from '../services/user-services.service';

@Component({
  selector: 'app-vehicle-dashboard',
  templateUrl: './vehicle-dashboard.component.html',
  styleUrls: ['./vehicle-dashboard.component.css']
})
export class VehicleDashboardComponent implements OnInit {
  
     vehicleData:Vehicle[]=[];
     vehicleData2:Vehicle[]=[];
  constructor(private service:UserServicesService){}
  ngOnInit(): void {
//to get the length of cart
// this.service.getCartData(this.service.userData.emailId).subscribe((res:any)=>{
//   this.vehicleData2=res;
// })
    this.service.getVehical().subscribe((res)=>{
      console.log("Vehical Data",res);
     this.vehicleData=res;
     this.service.cartLength=this.vehicleData2.length;
    })
     
    // this.service.getCartData(this.service.userData.emailId).subscribe((res:any)=>{
    //   this.vehicleData2=res;
    // })
  }

  addToCart(data:Vehicle){
    //let email:any=localStorage.getItem('emailId');
    //console.warn("emailATcAt",email);
      let email=this.service.userData.emailId;
    console.warn("emailByService",email);
    this.service.addCart(data,email).subscribe((res)=>{
      console.warn(JSON.stringify(res));
      
    });
    alert("Cart added successfully");
  }
}
