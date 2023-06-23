import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Vehicle } from '../services/model/vehicle';
import { UserServicesService } from '../services/user-services.service';

@Component({
  selector: 'app-cart-page',
  templateUrl: './cart-page.component.html',
  styleUrls: ['./cart-page.component.css']
})
export class CartPageComponent implements OnInit {

  vehicleData:Vehicle[]=[];
constructor(private service:UserServicesService,private router:Router){}

  ngOnInit(): void {
   this.service.getCartData(this.service.userData.emailId).subscribe((data:any)=>{
     this.vehicleData=data;
     this.service.cartLength=this.vehicleData.length;
     console.log("Login.......Cart Length",this.service.cartLength);
   }) 
  }

  remove(id:any){
this.service.deleteItemFromCart(id).subscribe((res)=>{
  this.ngOnInit();

  //this.service.getCartData(this.service.userData.emailId);
});
console.warn("remove item id",id);

  }
}
