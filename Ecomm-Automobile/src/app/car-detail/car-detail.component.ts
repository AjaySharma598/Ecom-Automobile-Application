import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Vehicle } from '../services/model/vehicle';
import { UserServicesService } from '../services/user-services.service';

@Component({
  selector: 'app-car-detail',
  templateUrl: './car-detail.component.html',
  styleUrls: ['./car-detail.component.css']
})
export class CarDetailComponent implements OnInit {

    data1:Vehicle={};
  constructor(private activateRoute:ActivatedRoute,private service:UserServicesService){}
  ngOnInit(): void {

    this.activateRoute.paramMap.subscribe(params => {
      console.log(params);
    let id = params.get('vehicleId')??0;
    let id2=id.toString();
    console.log(id);
    
    
    this.service.getVehicalById(id2).subscribe(data => {
    
      this.data1=data;
      console.log(this.data1);
    })
    });
  }
  buy(id:any){
    alert("Thank You To Buy a Car!!")
       console.warn("buy id",id);       
  }

}
