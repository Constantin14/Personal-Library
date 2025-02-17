
import { Component } from '@angular/core';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import { Router } from '@angular/router';
import { User } from './user.interface';
import { LoginPageService } from './login-page.service';
import { userAccount } from '../user.global-model';

@Component({
  standalone:true,
  selector: 'app-login-page',
  imports: [ReactiveFormsModule, FormsModule],
  templateUrl: './login-page.component.html',
  styleUrl: './login-page.component.css'
})
export class LoginPageComponent {

  user: User;

  constructor(private router: Router, private loginPageService: LoginPageService){
      this.user = {
        username: "",
        password: ""
      };
  }




  handleSubmit() {
    this.loginPageService.login(this.user).subscribe((res) => {
      userAccount.isAuth = true;
      userAccount.username = res.username;
      this.router.navigate(['home-page']);
    }, (err) => {
      
    });
  }

  goHome() {
    this.router.navigate(['home-page']);
  }

}
