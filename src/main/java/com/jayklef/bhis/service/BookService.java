package com.jayklef.bhis.service;

import com.jayklef.bhis.exception.BookNotFoundException;
import com.jayklef.bhis.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAllBooks();

    List<Book> findAllByIsArchivedFalse() throws BookNotFoundException;

    Book saveBook(Book book);

    List<Book> findBooksByAuthor(Long authorId);
}
