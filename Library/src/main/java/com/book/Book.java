package com.book;

import com.member.Member;

import javax.persistence.*;
import java.util.*;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String isbn;
    private String title;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Member> members;

    public Book() {
        members = new ArrayList<Member>();
    }

    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
        members = new ArrayList<Member>();
    }

    public Long getId(){
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public Collection<Member> getMembers() {
        return members;
    }

    @Override
    public String toString() {
        return id + " " + isbn + " " + title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (!getIsbn().equals(book.getIsbn())) return false;
        return getTitle().equals(book.getTitle());
    }
}
