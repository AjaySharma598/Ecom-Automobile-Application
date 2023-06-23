import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Vehicle } from './model/vehicle';

@Injectable({
  providedIn: 'root'
})
export class UserServicesService {
  cartLength:number=0;
  userData?:any;
  isLoggedIn:boolean=false;
  Url2:string="http://localhost:8082/api/v1/login";
  Url:string='http://localhost:8083/api/v2/customer';
  getDataUrl:string="http://localhost:8083/api/v2/allUsers/products";
  cart:string="http://localhost:8083/api/v2/productCart";
  //cartData:string="http://localhost:8083/api/v2/allUsers/cart";


  constructor( private http:HttpClient) { }

addCart(data:Vehicle,id:string){
   return this.http.post(`http://localhost:8083/api/v2/allUsers/productCart/${id}`,data);
}
login(data:any){
return this.http.post(this.Url2,data);
}
registrationForm(data:any){
  return this.http.post(this.Url,data);
}
getVehical(){
  const requestHeader=new HttpHeaders().set('authorization','Bearer' + window.sessionStorage.getItem('token'));
return this.http.get<Vehicle[]>(this.getDataUrl,{'headers':requestHeader});
}
getVehicalById(id:String){
  return this.http.get(`http://localhost:8083/api/v2/allUsers/productBy/${id}`);
}

getCustomerById(id:string){

  const requestHeader=new HttpHeaders().set('authorization','Bearer' + window.sessionStorage.getItem('token'));
    return this.http.get<any>(`http://localhost:8083/api/v2/allUsers/customer/${id}`,{'headers':requestHeader});
  }

getCartData(id:string){
    const requestHeader=new HttpHeaders().set('authorization','Bearer' + window.sessionStorage.getItem('token'));
      return this.http.get<Vehicle[]>(`http://localhost:8083/api/v2/allUsers/cart/${id}`,{'headers':requestHeader});
    }

deleteItemFromCart(vehicleId:string){
  const requestHeader=new HttpHeaders().set('authorization','Bearer' + window.sessionStorage.getItem('token'));
return this.http.delete(`http://localhost:8083/api/v2/allUsers/itemDelete/${this.userData.emailId}/${vehicleId}`,{'headers':requestHeader});
}
}
