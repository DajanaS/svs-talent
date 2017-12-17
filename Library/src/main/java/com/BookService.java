package com;

import com.book.Book;
import com.google.common.collect.Lists;
import com.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findBooks() {
        return Lists.newArrayList(bookRepository.findAll());
    }

    public void createBook(Book book) {
        bookRepository.save(book);
    }
}
