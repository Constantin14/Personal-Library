import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SubmitPageService {

  constructor(private httpClient: HttpClient) { }
  
    addUser(regiForm: any) {
        return this.httpClient.post('http://localhost:8080/user/register', regiForm, {withCredentials: true});
    }
}
