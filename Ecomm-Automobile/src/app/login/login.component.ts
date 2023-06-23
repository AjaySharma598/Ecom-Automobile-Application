import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserServicesService } from '../services/user-services.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  loginForm:FormGroup;
  myControl = new FormControl();
  constructor(private formBuilder: FormBuilder,private router:Router,private service:UserServicesService) {
    this.loginForm=this.formBuilder.group({
      emailId: new FormControl('',[Validators.required]),
      password: new FormControl('',[Validators.required])
    });
  }

  get emailId(){
    return this.loginForm.get('emailId');
  }
  get password(){
    return this.loginForm.get('password');
  }

  login(){
    console.log(this.loginForm.value);
    this.service.login(this.loginForm.value).subscribe((res:any)=>{
      //to get token 
      sessionStorage.setItem("token",JSON.stringify(res.token));
     this.service.isLoggedIn=true;
     if(res){
      this.service.getCustomerById(this.loginForm.value.emailId).subscribe((result)=>
      {
        this.service.userData=result;
        console.warn("DataBack",result);

        this.service.getCartData(this.loginForm.value.emailId);
        
      }) 
     }
      this.router.navigate(['vehicleDashboard']);
      console.log(res);
      alert("login SuccessFull");
    },(error)=>{
      alert("Please check email and password");
    })
}

}
