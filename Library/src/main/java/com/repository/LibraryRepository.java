package com.repository;

import com.book.Book;
import com.member.Member;

import java.util.Collection;

public interface LibraryRepository {
    void registerBook(Book book);

    void registerMember(Member member);

    Iterable<Book> listRegisteredBooks();

    Iterable<Member> listRegisteredMembers();

    void landBook(String member, String book);

    Collection<Book> getBooksLandedBy(Member member);
}
