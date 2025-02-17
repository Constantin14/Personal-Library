import { Injectable } from '@angular/core';
import { NewBook } from './new-book.interface';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BookHandlerService {

  constructor(private httpClient: HttpClient) { }

  addBook(newBook:NewBook) {
      return this.httpClient.post('http://localhost:8080/popularlib/books', newBook, {withCredentials: true});
  }
}
