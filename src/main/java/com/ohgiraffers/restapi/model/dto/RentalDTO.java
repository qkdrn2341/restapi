package com.ohgiraffers.restapi.model.dto;


import com.ohgiraffers.restapi.model.RentalStatus;

import java.time.LocalDate;

public class RentalDTO {
    Integer rentalNo;
    Integer memberNo;
    Integer bookNo;
    LocalDate rentedAt;
    LocalDate dueDate;
    LocalDate returnedAt;
    RentalStatus status;

    @Override
    public String toString() {
        return "RentalDTO{" +
                "rentalNo=" + rentalNo +
                ", memberNo=" + memberNo +
                ", bookNo=" + bookNo +
                ", rentedAt=" + rentedAt +
                ", dueDate=" + dueDate +
                ", returnedAt=" + returnedAt +
                ", status=" + status +
                '}';
    }

    public int getRentalNo() {
        return rentalNo;
    }

    public void setRentalNo(int rentalNo) {
        this.rentalNo = rentalNo;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public int getBookNo() {
        return bookNo;
    }

    public void setBookNo(int bookNo) {
        this.bookNo = bookNo;
    }

    public LocalDate getRentedAt() {
        return rentedAt;
    }

    public void setRentedAt(LocalDate rentedAt) {
        this.rentedAt = rentedAt;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReturnedAt() {
        return returnedAt;
    }

    public void setReturnedAt(LocalDate returnedAt) {
        this.returnedAt = returnedAt;
    }

    public RentalStatus getStatus() {
        return status;
    }

    public void setStatus(RentalStatus status) {
        this.status = status;
    }

    public RentalDTO(Integer rentalNo, Integer memberNo, Integer bookNo, LocalDate rentedAt, LocalDate dueDate, LocalDate returnedAt, RentalStatus status) {
        this.rentalNo = rentalNo;
        this.memberNo = memberNo;
        this.bookNo = bookNo;
        this.rentedAt = rentedAt;
        this.dueDate = dueDate;
        this.returnedAt = returnedAt;
        this.status = status;
    }

    public RentalDTO() {
    }

}
