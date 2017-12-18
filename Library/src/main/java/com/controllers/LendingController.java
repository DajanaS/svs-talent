package com.controllers;

import com.LendingService;
import com.book.Book;
import com.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/lending")
public class LendingController {
    private LendingService lendingService;

    @Autowired
    public LendingController(LendingService lendingService) {
        this.lendingService = lendingService;
    }

    @GetMapping
    @ResponseBody
    public void landBook(@RequestParam Long memberId, Long bookId) {
        lendingService.lendBook(memberId, bookId);
    }

    @GetMapping("/member/{memberId}")
    @ResponseBody
    public List<Book> getMemberBooks(@PathVariable Long memberId) {
        return lendingService.getBooksLendedBy(memberId);
    }

    @GetMapping("/book/{bookId}")
    @ResponseBody
    public List<Member> getBookMembers(@PathVariable Long bookId) {
        return lendingService.getMembersLendedAt(bookId);
    }

    @GetMapping("/members")
    @ResponseBody
    public List<Integer> getMemberCounts() {
        return lendingService.getMemberCounts();
    }

    @GetMapping("/books")
    @ResponseBody
    public List<Integer> getBookCounts() {
        return lendingService.getBookCounts();
    }
}
