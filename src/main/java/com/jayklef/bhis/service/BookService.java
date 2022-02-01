package com.jayklef.bhis.service;

import com.jayklef.bhis.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAllBooks();

    List<Book> findAllByIsArchivedFalse();

    Book saveBook(Book book);

    List<Book> findBooksByAuthor(Long authorId);
}
