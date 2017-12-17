package com.member;

import com.book.Book;

import javax.persistence.*;
import java.util.*;

@Entity
public class Member {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "members", fetch = FetchType.EAGER)
    private Collection<Book> books;

    public Member() {
        books = new ArrayList<Book>();
    }

    public Member(String name) {
        this.name = name;
        books = new ArrayList<Book>();
    }

    public Long getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Collection<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return id + " " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Member)) return false;

        Member member = (Member) o;

        return getName() != null ? getName().equals(member.getName()) : member.getName() == null;
    }
}
