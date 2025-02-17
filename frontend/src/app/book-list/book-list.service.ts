import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class BookListService {

  constructor(private httpClient:HttpClient) { }

  getAllBooks():Observable<any>{
    return this.httpClient.get<any>("http://localhost:8080/popularlib/books", {withCredentials: true});
  }

  getAllBooksByYear(year:string):Observable<any>{
    return this.httpClient.get<any>(`http://localhost:8080/popularlib/books/year/${year}`, {withCredentials: true});
  }
  getAllReadBooks(isRead:boolean):Observable<any>{
    return this.httpClient.get<any>(`http://localhost:8080/popularlib/books/read/${isRead}`, {withCredentials: true});
  }

  
}
