package com;

import com.book.Book;
import com.member.Member;
import com.lending.Lending;
import com.repository.BookRepository;
import com.repository.MemberRepository;
import com.repository.LendingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LendingService {
    private BookRepository bookRepository;
    private MemberRepository memberRepository;
    private LendingRepository lendingRepository;

    @Autowired
    public LendingService(BookRepository bookRepository, MemberRepository memberRepository, LendingRepository lendingRepository) {
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
        this.lendingRepository = lendingRepository;
    }

    public List<Member> getMembersLendedAt(Long bookId) {
        List<Member> members = new ArrayList<>();
        Iterable<Lending> lendings = lendingRepository.findAllByBookId(bookId);
        for (Lending lending : lendings) {
            Member member = memberRepository.findById(lending.getMemberId());
            members.add(member);
        }
        return members;
    }

    public List<Book> getBooksLendedBy(Long memberId) {
        List<Book> books = new ArrayList<>();
        Iterable<Lending> lendings = lendingRepository.findAllByMemberId(memberId);
        for (Lending lending : lendings) {
            Book book = bookRepository.findById(lending.getBookId());
            books.add(book);
        }
        return books;
    }

    public void lendBook(Long memberId, Long bookId) {
        Lending lending = new Lending(memberId, bookId);
        lendingRepository.save(lending);
    }

    public List<Integer> getMemberCounts() {
        List<Integer> counts = new ArrayList<>();
        Iterable<Book> books = bookRepository.findAll();
        for (Book book : books) {
            counts.add(this.getMembersLendedAt(book.getId()).size());
        }
        return counts;
    }

    public List<Integer> getBookCounts() {
        List<Integer> counts = new ArrayList<>();
        Iterable<Member> members = memberRepository.findAll();
        for (Member member : members) {
            counts.add(this.getBooksLendedBy(member.getId()).size());
        }
        return counts;
    }
}
