import { Component } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { Book } from '../book';
import { LoginPageService } from '../login-page/login-page.service';
import { catchError, EMPTY } from 'rxjs';
import { userAccount } from '../user.global-model';


@Component({
  selector: 'app-home-page',
  imports: [RouterLink],
  templateUrl: './home-page.component.html',
  styleUrl: './home-page.component.css'
})
export class HomePageComponent {
  topRatedBooks!: Book[];
  constructor(private loginService: LoginPageService, private router: Router){

  }
  ngOnInit(): void {
   this.loginService.tryAuthentication()
   .pipe(catchError(error => EMPTY))
   .subscribe((res) => {
      userAccount.isAuth = true;
      userAccount.username = res.username;
      this.router.navigate(['book-list']);
   }, (err) => {
   });
  }
}
