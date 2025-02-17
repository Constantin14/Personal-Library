import { NgIf } from '@angular/common';
import { Component } from '@angular/core';
import {FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators} from '@angular/forms';
import { Router } from '@angular/router';
import { SubmitPageService } from './submit-page.service';
import { User } from '../login-page/user.interface';
import { NgModel } from '@angular/forms';


@Component({
  standalone:true,
  selector: 'app-submit-page',
  imports: [ReactiveFormsModule, NgIf, FormsModule],
  templateUrl: './submit-page.component.html',
  styleUrl: './submit-page.component.css'
})
export class SubmitPageComponent {

  constructor(private router: Router, private userHandler: SubmitPageService){ }

    regiForm= new FormGroup({
      username: new FormControl('',[Validators.required]),
      city: new FormControl('',[Validators.required]),
      email: new FormControl('',[Validators.required, Validators.email]),
      password: new FormControl('',[Validators.required, Validators.minLength(6),Validators.maxLength(10)]),
      confirmPassword:new FormControl()
  
    })  

addUser(){
    console.log(this.regiForm.value)
    this.userHandler.addUser(this.regiForm.value).subscribe();
}

  
checkPasswords(val1: any, val2: any){

    if(val1!=val2){
        this.regiForm.controls.confirmPassword.setErrors({notEqual:true})
      }
}

goBack() {
  this.router.navigate(['home-page']);
}

}
