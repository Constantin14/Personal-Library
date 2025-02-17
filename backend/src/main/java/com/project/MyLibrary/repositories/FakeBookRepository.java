package com.project.MyLibrary.repositories;

import com.project.MyLibrary.models.Book;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Deprecated
public class FakeBookRepository {
    List<Book> fakeBookRepository = new ArrayList<>();

    public FakeBookRepository() {
        Book b1 = new Book(1, "Not without my daughter", "Betty Mehmody", 50,4.5, 2023, "http/something", false);
        Book b2 = new Book(2, "Accidental PrimeMinister", "Sanjay Baru", 65,4, 2024, "http/something", false);
        Book b3 = new Book(3, "Abstract Algebra", "JNash", 80, 5, 2025, "http/something", false);

        fakeBookRepository.add(b1);
        fakeBookRepository.add(b2);
        fakeBookRepository.add(b3);
    }

    public List<Book> getBooks(){
        return this.fakeBookRepository;
    }

    public Book findBookById(Integer id){
        return this.fakeBookRepository.get(id);
    }



}
