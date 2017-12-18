package com.controllers;

import com.BookService;
import com.book.Book;
import com.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    @ResponseBody
    public List<Book> findBooks() {
        return bookService.findBooks();
    }

    @PostMapping
    @ResponseBody
    public void createBook(@RequestBody Book book) {
        bookService.createBook(book);
    }
}