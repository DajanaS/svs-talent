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
        System.out.println("By name " + m + " is found: " + member);
        Book book = bookRepository.findByTitle(b);
        System.out.println("By title " + b + " is found: " + book);
        System.out.println("Member's book listata pred da se dodade: ");
        System.out.println(member.toString() + " has taken the following books:");
        Collection<Book> books = member.getBooks();
        if (books.size() == 0) System.out.println("   any.");
        else for (Book bo : books) {
            System.out.println("   " + bo);
        }
        member.addBook(book);
        System.out.println("Member's book listata otkako ke se dodade: ");
        System.out.println(member.toString() + " has taken the following books:");
        books = member.getBooks();
        if (books.size() == 0) System.out.println("   any.");
        else for (Book bo : books) {
            System.out.println("   " + bo);
        }
        //book.addMember(member);
    }

    public Collection<Book> getBooksLandedBy(Member member){
        return member.getBooks();
    }
}
