import { Component, NgModule, OnInit } from '@angular/core';
import { Book } from '../book';
import { ActivatedRoute, Router } from '@angular/router';
import { __param } from 'tslib';
import { BookDetailService } from './book-detail.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-book-detail',
  imports: [FormsModule],
  templateUrl: './book-detail.component.html',
  styleUrl: './book-detail.component.css'
})
export class BookDetailComponent {
  selectedBook: Book;
  bookId:number = 0;

  constructor(private route:ActivatedRoute, private service: BookDetailService, private router: Router){
    this.selectedBook = {
      bookId: 0,
      title: '',
      author: '',
      price: 0,
      rating: 0,
      year: 0,
      bookLink: '',
      isRead: false
    }
  }
  ngOnInit(): void {
    this.route.params.subscribe((params=>{this.bookId=params['id']}))
    this.service.getBookById(this.bookId).subscribe((res) => {
        this.selectedBook = res;
    });
   
  }

  deleteBook(){
    this.service.deleteBookById(this.bookId).subscribe((res) => {
      this.router.navigate(['book-list']);
    });
  
  }

  updateBook(){
    this.service.updateBookById(this.selectedBook).subscribe((res) => {
    this.router.navigate(['book-list']);
    })
  }

  goHome() {
    this.router.navigate(['book-list']);
  }
}
