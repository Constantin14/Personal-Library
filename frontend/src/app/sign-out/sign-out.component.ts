import { Component } from '@angular/core';
import { SignOutService } from './sign-out.service';
import { User } from '../login-page/user.interface';
import { Router } from '@angular/router';
import { userAccount } from '../user.global-model';

@Component({
  selector: 'app-sign-out',
  imports: [],
  templateUrl: './sign-out.component.html',
  styleUrl: './sign-out.component.css'
})
export class SignOutComponent {
  constructor(private signOutService: SignOutService, private router: Router){}

    user: User;
  

    signOutUser(){
    this.signOutService.signOutUser().subscribe((res) => {
      userAccount.isAuth = false;
      userAccount.username = '';
      this.router.navigate(['home-page']);
    }, (err) => {
      userAccount.isAuth = false;
      userAccount.username = '';
      this.router.navigate(['home-page']);
    });

  }

  checkIfSignedIn() {
    return userAccount.isAuth;
  }

  

}

