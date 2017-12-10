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
    @ManyToMany(mappedBy = "landed_books", fetch = FetchType.EAGER)
    private Collection<Book> books;

    public Member() {
        books = new ArrayList<Book>();
    }

    public Member(String name) {
        this.name = name;
        books = new ArrayList<Book>();
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

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}
