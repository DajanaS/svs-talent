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
    private Collection<Member> landed_books;

    public Book() {
        landed_books = new ArrayList<Member>();
    }

    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
        landed_books = new ArrayList<Member>();
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
        landed_books.add(member);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", landed_books=" + landed_books +
                '}';
    }
}
