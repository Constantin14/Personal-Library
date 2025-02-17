package com.project.MyLibrary.controllers;

import com.project.MyLibrary.models.Book;
import com.project.MyLibrary.services.BookService;
import com.project.MyLibrary.services.BookServiceImpl;
import com.project.MyLibrary.dtos.BookUpdateRequest;
import com.project.MyLibrary.dtos.NewBookRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/popularlib")
public class BookController {

    private final BookService bookServiceImpl;

    public BookController(BookServiceImpl bookServiceImpl) {
        this.bookServiceImpl = bookServiceImpl;
    }


    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookServiceImpl.getBooks();
    }



    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Integer id
    ) {
        Book book = bookServiceImpl.getBookById(id);
        return ResponseEntity.ok().body(book);
    }

    @GetMapping("/books/year/{year}")
    public ResponseEntity <List<Book>> getBooksByYear(@PathVariable("year") Integer year){
       List<Book> book = bookServiceImpl.getBooksByYear(year);
       return ResponseEntity.ok().body(book);
    }

    @GetMapping("/books/read/{getIsRead}")
    public  ResponseEntity <List<Book>> getAllReadBooks(@PathVariable("getIsRead") Boolean isRead){
        List<Book> book = bookServiceImpl.getAllReadBooks(isRead);
        return ResponseEntity.ok().body(book);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable("id") Integer id) {
        bookServiceImpl.deleteBookById(id);
    }

    @PostMapping("/books")
    public void addBook(@RequestBody NewBookRequest book) {
        bookServiceImpl.addBook(book);
    }

    @PutMapping("/books/{id}")
    public void updateBook(@PathVariable("id") Integer id,
                    @RequestBody BookUpdateRequest request){
        bookServiceImpl.updateBook(id, request);
    }


}
