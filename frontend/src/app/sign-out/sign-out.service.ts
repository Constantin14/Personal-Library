import { Injectable } from '@angular/core';
import { User } from '../login-page/user.interface';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SignOutService {

  constructor(private httpClient: HttpClient) { }

  signOutUser():Observable<User>{
      return this.httpClient.get<User>("http://localhost:8080/user/logout", {withCredentials: true});
    }
}
