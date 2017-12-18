package com.lending;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Lending {
    @Id
    @GeneratedValue
    private Long id;
    private Long memberId;
    private Long bookId;

    public Lending(){}

    public Lending(Long memberId, Long bookId) {
        this.memberId = memberId;
        this.bookId = bookId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public Long getBookId() {
        return bookId;
    }
}
