package com.project.MyLibrary.services;

import com.project.MyLibrary.dtos.BookUpdateRequest;
import com.project.MyLibrary.dtos.NewBookRequest;
import com.project.MyLibrary.models.Book;

import java.util.List;

public interface BookService {
    List<Book> getBooks();

    Book getBookById(Integer id);

    List<Book> getBooksByYear(Integer year);

    List<Book> getAllReadBooks(Boolean isRead);

    void deleteBookById(Integer id);

    void addBook(NewBookRequest bookRequest);

    void updateBook(Integer id, BookUpdateRequest request);
}
