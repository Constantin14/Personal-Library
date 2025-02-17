import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { HttpHeaders } from '@angular/common/http';
import { User } from './user.interface';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class LoginPageService {

  constructor(private httpClient:HttpClient) { }

  login(user: User) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Authorization': 'Basic ' + window.btoa(user.username + ':' + user.password)
      }),
      withCredentials: true
    };
    return this.httpClient.get<User>('http://localhost:8080/user/details', httpOptions);
  }

  tryAuthentication(): Observable<User> {
    const httpOptions = {
      withCredentials: true
    };
    return this.httpClient.get<User>('http://localhost:8080/user/details', httpOptions);
  }

  
}
