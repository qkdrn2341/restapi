package com.ohgiraffers.restapi.model.dto;

import java.time.LocalDate;
import java.util.Date;

public class MemberDTO {
    int memberNo;
    String id;
    String name;
    String email;

    @Override
    public String toString() {
        return "MemberDTO{" +
                "memberNo=" + memberNo +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", jointedAt=" + jointedAt +
                '}';
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getJointedAt() {
        return jointedAt;
    }

    public void setJointedAt(LocalDate jointedAt) {
        this.jointedAt = jointedAt;
    }

    public MemberDTO(int memberNo, String id, String name, String email) {
        this.memberNo = memberNo;
        this.id = id;
        this.name = name;
        this.email = email;
        this.jointedAt = LocalDate.now();
    }

    public MemberDTO() {
    }

    LocalDate jointedAt;
}
