import { Component } from '@angular/core';
import { AbstractControl, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { UserServicesService } from '../services/user-services.service';

@Component({
  selector: 'app-registration-form',
  templateUrl: './registration-form.component.html',
  styleUrls: ['./registration-form.component.css']
})
export class RegistrationFormComponent {

  registerForm:FormGroup;
  myControl = new FormControl();
  constructor(private formbuider:FormBuilder,private services:UserServicesService) {
this.registerForm = this.formbuider.group({
      name:new FormControl('',[Validators.required,Validators.minLength(3),Validators.pattern('[a-zA-Z][a-zA-Z ]{1,}')]),
      emailId:new FormControl('',[Validators.required,Validators.pattern(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/)]),
      password:new FormControl('',[Validators.required,Validators.pattern(/^(?=.*\d)(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z]).{4,}$/)]),
      confirmPassword:new FormControl('',[Validators.required]),
      mobileNumber:new FormControl('',[Validators.required,Validators.pattern(/^[789]\d{9,9}$/)]),
},{validator:[this.passwordShouldMatchValidation]});
}
get name(){
  return this.registerForm.get('name');
}
get emailId(){
  return this.registerForm.get('emailId');
}
get password(){
  return this.registerForm.get('password');
}
get confirmPassword(){
  return this.registerForm.get('confirmPassword');
}
get mobileNumber(){
  return this.registerForm.get('mobileNumber');
}

passwordShouldMatchValidation(myControl:AbstractControl){
  const passwordValue=myControl.get('password')?.value;
  const confirmPasswordValue=myControl.get('confirmPassword')?.value;
  if(!passwordValue || !confirmPasswordValue){
    return null;
 }
if(passwordValue != confirmPasswordValue){
  return {passwordShouldMatch : false};   
}
return null;
}

addNote(){
  console.log(this.registerForm.value);
  this.services.registrationForm(this.registerForm.value).subscribe((res)=>{
    console.log(res)
    alert("sucess")});
  
}


}
