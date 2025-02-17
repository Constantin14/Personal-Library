import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { NewBook } from './new-book.interface';
import { BookHandlerService } from './book-handler.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-book-handler',
  imports: [FormsModule],
  templateUrl: './book-handler.component.html',
  styleUrl: './book-handler.component.css'
})
export class BookHandlerComponent {

  bookModel: NewBook ;

  constructor(private bookHandlerService:BookHandlerService, private router: Router) {
    this.bookModel = {
      title: '',
      author: '',
      price: 0,
      rating: 0,
      year: 0,
      bookLink: '',
      isRead: false
    }
  }

  addBook(){
    this.bookHandlerService.addBook(this.bookModel).subscribe();
    this.router.navigate(['book-list']);
  }

  goHome() {
    this.router.navigate(['book-list']);
  }

}
