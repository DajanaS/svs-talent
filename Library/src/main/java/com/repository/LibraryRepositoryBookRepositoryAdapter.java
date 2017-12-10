package com.repository;

import com.book.Book;
import com.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LibraryRepositoryBookRepositoryAdapter implements LibraryRepository {
    private BookRepository bookRepository;
    private MemberRepository memberRepository;

    public LibraryRepositoryBookRepositoryAdapter() {
    }

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void registerBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Iterable<Book> listRegisteredBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void registerMember(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Iterable<Member> listRegisteredMembers() {
        return memberRepository.findAll();
    }

    @Override
    public void landBook(String m, String b) {
        Member member = memberRepository.findByName(m);
        Book book = bookRepository.findByTitle(b);
        member.addBook(book);
    }
}
