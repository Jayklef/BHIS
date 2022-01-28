package com.jayklef.bhis.service;

import com.jayklef.bhis.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAllBooks();

    Book saveBook(Book book);
}
