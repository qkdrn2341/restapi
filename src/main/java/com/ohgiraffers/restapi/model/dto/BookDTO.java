package com.ohgiraffers.restapi.model.dto;


import com.ohgiraffers.restapi.model.BookStatus;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class BookDTO {
    Integer bookNo;
    @NotNull
    @NotBlank
    String title;
    @NotNull
    @NotBlank
    String author;
    @NotNull
    @NotBlank
    String isbn;
    BookStatus status;
    @PastOrPresent
    LocalDate publishedAt;

    @Override
    public String toString() {
        return "BookDTO{" +
                "bookNo=" + bookNo +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn=" + isbn +
                ", status=" + status +
                ", publishedAt=" + publishedAt +
                '}';
    }

    public int getBookNo() {
        return bookNo;
    }

    public void setBookNo(Integer bookNo) {
        this.bookNo = bookNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public LocalDate getPublishedAt() {
        return publishedAt;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPublishedAt(LocalDate publishedAt) {
        this.publishedAt = publishedAt;
    }

    public BookDTO(Integer bookNo, String title, String author, String isbn, BookStatus status, LocalDate publishedAt) {
        this.bookNo = bookNo;
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.status = status;
        this.publishedAt = publishedAt;
    }

    public BookDTO() {
    }
}
