package com.project.MyLibrary.services;

import com.project.MyLibrary.dtos.BookUpdateRequest;
import com.project.MyLibrary.dtos.NewBookRequest;
import com.project.MyLibrary.exception.ResourceNotFoundException;
import com.project.MyLibrary.models.Book;
import com.project.MyLibrary.models.UserAccount;
import com.project.MyLibrary.repositories.BookRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;
    private final UserAccountServiceImpl userAccountServiceImpl;

    public BookServiceImpl(BookRepository bookRepository, UserAccountServiceImpl userAccountServiceImpl) {
        this.bookRepository = bookRepository;
        this.userAccountServiceImpl = userAccountServiceImpl;
    }

    public List<Book> getBooks(){
        UserAccount userAccountByUsername = userAccountServiceImpl
                .getUserAccountByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        return bookRepository.findAllBooksByUserAccount(userAccountByUsername.getId()).orElseThrow(() ->
                new RuntimeException("No books for this user_account"));
    }


    public Book getBookById(Integer id){
        return bookRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                            "Book with id " + id + " not found"));
    }

    public List<Book> getBooksByYear(Integer year) {
        UserAccount userAccountByUsername = userAccountServiceImpl
                .getUserAccountByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        return   bookRepository.findAllBooksByYearAndIdUserAccount(year, userAccountByUsername.getId()).
                orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Books with year " + year + " not found"));

    }

    public List<Book> getAllReadBooks(Boolean isRead){
        UserAccount userAccountByUsername = userAccountServiceImpl
                .getUserAccountByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        return  bookRepository.findAllBooksByIsReadAndIdUserAccount(isRead, userAccountByUsername.getId()).
                orElseThrow(() ->
                        new ResourceNotFoundException(
                                "We don't have read books"));
    }

    public void deleteBookById(Integer id){
        boolean existsById = bookRepository.existsById(id);
        if(!existsById) {
            throw new ResourceNotFoundException(
                    "Book with id " + id + " not found");

        }
        bookRepository.deleteById(id);
    }

    public void addBook(NewBookRequest bookRequest) {
        UserAccount userAccount = userAccountServiceImpl
                .getUserAccountByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        Book book = new Book(
                bookRequest.title(),
                bookRequest.author(),
                bookRequest.price(),
                bookRequest.rating(),
                bookRequest.year(),
                bookRequest.bookLink(),
                bookRequest.isRead(),
                userAccount
        );
        bookRepository.save(book);
    }

    public void updateBook(Integer id,
                           BookUpdateRequest request){
        Book book = bookRepository.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException(
                            "Book with id " +id + " not found"
                    ));

        if(request.title() != null &&
                !request.title().isEmpty() &&
                !request.title().equals(book.getTitle())) {
            book.setTitle(request.title());
            bookRepository.save(book);
        }

        if(request.author() != null &&
                !request.author().isEmpty() &&
                !request.author().equals(book.getAuthor())) {
            book.setAuthor(request.author());
            bookRepository.save(book);
        }

        if(request.price() != null &&
                !request.price().equals(book.getPrice())) {
            book.setPrice(request.price());
            bookRepository.save(book);
        }

        if(request.rating() != null &&
                !request.rating().equals(book.getRating())) {
            book.setRating(request.rating());
            bookRepository.save(book);
        }

        if(request.year() != null &&
                !request.year().equals(book.getYear())) {
            book.setYear(request.year());
            bookRepository.save(book);
        }

        if(request.bookLink() != null &&
                !request.bookLink().isEmpty() &&
                !request.bookLink().equals(book.getBookLink())) {
            book.setBookLink(request.bookLink());
            bookRepository.save(book);
        }

        if(request.isRead() != null &&
                !request.isRead().equals(book.getIsRead())) {
            book.setIsRead(request.isRead());
            bookRepository.save(book);
        }
    }
}
