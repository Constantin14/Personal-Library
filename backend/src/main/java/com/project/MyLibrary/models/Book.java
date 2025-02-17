package com.project.MyLibrary.models;


import jakarta.persistence.*;


import java.util.Objects;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    private String title;
    private String author;
    private double price;
    private double rating;
    private int year;
    private String bookLink;
    private boolean isRead;
    @ManyToOne
    @JoinColumn(name = "id_user_account", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_id_user_account"))
    private UserAccount userAccount;

    public Book() {}

    public Book(int bookId, String title, String author, double price, double rating, int year, String bookLink, boolean isRead) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
        this.rating = rating;
        this.year = year;
        this.bookLink = bookLink;
        this.isRead = isRead;
    }

    public Book(String title, String author, double price, double rating, int year, String bookLink, boolean isRead) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.rating = rating;
        this.year = year;
        this.bookLink = bookLink;
        this.isRead = isRead;
    }

    public Book(String title, String author, double price, double rating, int year, String bookLink, boolean isRead, UserAccount userAccount) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.rating = rating;
        this.year = year;
        this.bookLink = bookLink;
        this.isRead = isRead;
        this.userAccount = userAccount;
    }

    public Integer getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

    public int getYear() { return year; }

    public String getBookLink() { return bookLink; }

    public boolean getIsRead() { return isRead; }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setYear(int year) { this.year = year; }

    public void setBookLink(String bookLink) { this.bookLink = bookLink; }

    public void setIsRead(boolean read) { isRead = read; }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookId == book.bookId && Double.compare(price, book.price) == 0 && Double.compare(rating, book.rating) == 0 && year == book.year && isRead == book.isRead && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(bookLink, book.bookLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, title, author, price, rating, year, bookLink, isRead);
    }
}
