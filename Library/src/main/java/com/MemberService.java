package com;

import com.book.Book;
import com.google.common.collect.Lists;
import com.member.Member;
import com.repository.BookRepository;
import com.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    private MemberRepository memberRepository;
    private BookRepository bookRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository, BookRepository bookRepository) {
        this.memberRepository = memberRepository;
        this.bookRepository = bookRepository;
    }

    public List<Member> findMembers() {
        return Lists.newArrayList(memberRepository.findAll());
    }

    public void createMember(Member member) {
        memberRepository.save(member);
    }

    public void landBook(Long memberId, Long bookId) {
        Member member = memberRepository.findById(memberId);
        Book book = bookRepository.findById(bookId);

        member.addBook(book);
        memberRepository.save(member);

        book.addMember(member);
        bookRepository.save(book);
    }
}
