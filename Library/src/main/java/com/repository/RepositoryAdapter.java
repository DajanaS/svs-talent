package com.repository;

import com.book.Book;
import com.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class RepositoryAdapter implements LibraryRepository {
    private BookRepository bookRepository;
    private MemberRepository memberRepository;

    public RepositoryAdapter() {
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
        if (!exists(book))
            bookRepository.save(book);
    }

    @Override
    public Iterable<Book> listRegisteredBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void registerMember(Member member) {
        if (!exists(member))
            memberRepository.save(member);
    }

    @Override
    public Iterable<Member> listRegisteredMembers() {
        return memberRepository.findAll();
    }

    private boolean exists(Book b) {
        Iterable<Book> books = listRegisteredBooks();
        for (Book book : books)
            if (book.equals(b)) return true;
        return false;
    }

    private boolean exists(Member m) {
        Iterable<Member> members = listRegisteredMembers();
        for (Member member : members)
            if (member.equals(m)) return true;
        return false;
    }

    @Override
    public void landBook(String m, String b) {
        Member member = memberRepository.findByName(m);
        Book book = bookRepository.findByTitle(b);
        member.addBook(book);
        memberRepository.save(member);
        book.addMember(member);
        bookRepository.save(book);
    }

    public Collection<Book> getBooksLandedBy(Member member){
        return member.getBooks();
    }
}
