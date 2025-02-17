import { NgFor } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { Book } from '../book';
import { BookListService } from './book-list.service';
import { FormsModule } from '@angular/forms';


@Component({
  selector: 'app-book-list',
  imports: [RouterLink, FormsModule],
  templateUrl: './book-list.component.html',
  providers: [BookListService],
  styleUrl: './book-list.component.css'
})
export class BookListComponent implements OnInit{

  allBooks!: Book[];
  readBooks!: Book[];
  year:string ="";
  totalPrice = 0;
  showPriceBool = false;
  constructor(private service:BookListService){

  }
  ngOnInit(): void {
    this.service.getAllBooks().subscribe((res) => {
      this.allBooks=res;
    });
  }

  applyNoReadFilter(){
    this.service.getAllBooks().subscribe((res) => {
      this.allBooks=res;
    });
    this.showPriceBool = false;
    this.showPrice();
  }

  applyReadFilter() {
    this.service.getAllReadBooks(true).subscribe((res) => {
      this.allBooks=res;
    })
    this.showPriceBool = false;
    this.showPrice();
  }

  applyUnReadFilter() {
    this.service.getAllReadBooks(false).subscribe((res) => {
      this.allBooks=res;
    })
    this.showPriceBool = false;
    this.showPrice();
  }

  applyFilter() {
    if (this.year == '') {
      this.service.getAllBooks().subscribe((res) => {
        this.allBooks = res;
      })
    } else {
      this.service.getAllBooksByYear(this.year).subscribe((res) => {
        this.allBooks = res;
      });
    }
    this.showPriceBool = false;
    this.showPrice();
  }

  applyPriceFilter() {
    this.totalPrice = 0;
    for(let i=0; i<this.allBooks.length; i++)
    {
      this.totalPrice = this.totalPrice + this.allBooks[i].price;
    }
    this.showPriceBool = true;
  }

  showPrice() {
    if (this.showPriceBool === true) {
      return false;
    }
    return true;
  }
}

