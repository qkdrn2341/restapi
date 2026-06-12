package com.ohgiraffers.restapi.model.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.Date;

public class MemberDTO {
    Integer memberNo;
    @NotBlank(message = "아이디는 필수입니다.")
    @Size(min = 4, max = 20, message = "아이디는 4자 이상 20자 이하여야 합니다.")
    String id;
    @NotBlank(message = "이름은 필수입니다.")
    String name;
    @NotBlank(message = "이메일은 필수입니다.")
    @Email(message = "이메일 형식이 아닙니다.")
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

    public void setMemberNo(Integer memberNo) {
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

    public MemberDTO(Integer memberNo, String id, String name, String email) {
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
