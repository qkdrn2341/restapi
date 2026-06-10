package com.ohgiraffers.restapi.Controller;

import com.ohgiraffers.restapi.model.BookStatus;
import com.ohgiraffers.restapi.model.dto.BookDTO;
import com.ohgiraffers.restapi.model.dto.MemberDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/library")
public class LibraryController {

    private final List<MemberDTO> members = new ArrayList<>();

    private final List<BookDTO> books = new ArrayList<>();

    int temp = 1;
    int btemp = 1;


    public LibraryController() {
        members.add(new MemberDTO(temp++, "reader1", "판다", "reader1@asd.com"));
        members.add(new MemberDTO(temp++, "reader2", "다람쥐", "reader2@asd.com"));
        members.add(new MemberDTO(temp++, "reader3", "양", "reader3@asd.com"));
        members.add(new MemberDTO(temp++, "reader4", "거북이", "reader4@asd.com"));
        members.add(new MemberDTO(temp++, "reader5", "코끼리", "reader5@asd.com"));

        books.add(new BookDTO(btemp++, "book1", "somebody1", 100001, BookStatus.AVAILABLE, LocalDate.now()));
        books.add(new BookDTO(btemp++, "book2", "somebody2", 100002, BookStatus.RENTED, LocalDate.now()));
        books.add(new BookDTO(btemp++, "book3", "somebody3", 100003, BookStatus.AVAILABLE, LocalDate.now()));
        books.add(new BookDTO(btemp++, "book4", "somebody4", 100004, BookStatus.AVAILABLE, LocalDate.now()));
        books.add(new BookDTO(btemp++, "book5", "somebody5", 100005, BookStatus.RENTED, LocalDate.now()));
        books.add(new BookDTO(btemp++, "book6", "somebody6", 100006, BookStatus.AVAILABLE, LocalDate.now()));
        books.add(new BookDTO(btemp++, "book7", "somebody7", 100007, BookStatus.RENTED, LocalDate.now()));
        books.add(new BookDTO(btemp++, "book8", "somebody8", 100008, BookStatus.AVAILABLE, LocalDate.now()));

    }

    @GetMapping("/members")
    public ResponseEntity<List<MemberDTO>> getMembers() {
        return ResponseEntity.ok(members);
    }


    /**
     * 선택 검색 조건:
     * name이 있으면 이름에 해당 글자가 포함된 회원만 조회한다.
     * 검색 결과가 없어도 200 OK와 빈 배열을 응답한다.
     */

    @GetMapping("/members/{name}")
    public ResponseEntity<List<MemberDTO>> getMember(@PathVariable String name) {
        var mem = members.stream().filter(m -> m.getName().contains(name)).toList();

        return ResponseEntity.ok(mem);
    }

    /**
     * 회원 단건 조회
     * 회원이 있으면 200 OK
     * 회원이 없으면 404 Not Found
     */
    @GetMapping("/members/{memberNo}")
    public ResponseEntity<MemberDTO> getMemberByMemberNo(@PathVariable int memberNo) {
        /**
         * 회원이 있으면 200 OK
         * 회원이 없으면 404 Not Found */

        for (MemberDTO mem : members) {
            if (mem.getMemberNo() == memberNo) {
                return ResponseEntity.ok(mem);
            }
        }
        return ResponseEntity.notFound().build();
    }


    /**
     * POST /api/v1/library/members
     * Content-Type: application/json
     * <p>
     * {
     * "id": "reader01",
     * "name": "홍길동",
     * "email": "reader01@test.com"
     * }
     * <p>
     * id
     * - 필수
     * - 4자 이상 20자 이하
     * <p>
     * name
     * - 필수
     * - 공백 불가
     * <p>
     * email
     * - 필수
     * - 이메일 형식(@Email 사용)
     * <p>
     * memberNo는 서버에서 자동 증가시킨다.
     * joinedAt은 오늘 날짜로 저장한다.
     * 등록 성공 시 201 Created를 응답한다.
     * Location header에 새 회원 조회 주소를 담는다.
     */

    @PostMapping("/members")
    public ResponseEntity<Map<String, Object>> addMember(@Valid @RequestBody MemberDTO member) {


        member.setMemberNo(temp++);
        member.setJointedAt(LocalDate.now());

        members.add(member);

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "멤버 등록 성공");
        response.put("member", member);


        URI location = URI.create("/members/" + member.getMemberNo());

        return ResponseEntity.created(location)
                .body(response);
    }


    @GetMapping("/books")
    public List<BookDTO> getBooks() {
        return books;
    }

    @GetMapping("/books/{bookNo}")
    public ResponseEntity<BookDTO> getBookByBookNo(@PathVariable int bookNo) {
        var result =  books.stream().filter(m-> m.getBookNo() == bookNo).findFirst();

        if(result != null)
            return ResponseEntity.ok(result.get());
        else return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> addBook(@Valid @RequestBody BookDTO book) {

        book.setBookNo(btemp++);
        book.setIsbn(123456);
        book.setPublishedAt(LocalDate.now());

        books.add(book);
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "도서 등록 성공");
        response.put("book", book);

        URI location = URI.create("/books/" + book.getBookNo());

        return ResponseEntity.created(location)
                .body(response);

    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> rentBook(int memberNo, int bookNo) {

        return null;
    }


}
