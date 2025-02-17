import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Book } from '../book';

@Injectable({
  providedIn: 'root'
})
export class BookDetailService {

  constructor(private httpClient:HttpClient) { }

  getBookById(id: number):Observable<any>{
    return this.httpClient.get<any>(`http://localhost:8080/popularlib/books/${id}`, {withCredentials: true});
  }

  deleteBookById(id: number):Observable<any>{
    return this.httpClient.delete<any>(`http://localhost:8080/popularlib/books/${id}`, {withCredentials: true});
  }

  updateBookById(selectedBook: Book):Observable<any>{
    return this.httpClient.put<any>(`http://localhost:8080/popularlib/books/${selectedBook.bookId}`, selectedBook, {withCredentials: true});
  }


}
