package com.ohgiraffers.restapi.model.dto;


import com.ohgiraffers.restapi.model.BookStatus;

import java.time.LocalDate;

public class BookDTO {
    int bookNo;
    String title;
    String author;
    BookStatus status;
    LocalDate publishedAt;

    @Override
    public String toString() {
        return "BookDTO{" +
                "bookNo=" + bookNo +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", status=" + status +
                ", publishedAt=" + publishedAt +
                '}';
    }

    public int getBookNo() {
        return bookNo;
    }

    public void setBookNo(int bookNo) {
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

    public void setPublishedAt(LocalDate publishedAt) {
        this.publishedAt = publishedAt;
    }

    public BookDTO(int bookNo, String title, String author, BookStatus status, LocalDate publishedAt) {
        this.bookNo = bookNo;
        this.title = title;
        this.author = author;
        this.status = status;
        this.publishedAt = publishedAt;
    }

    public BookDTO() {
    }
}
