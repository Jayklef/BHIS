package com.jayklef.bhis.service;

import com.jayklef.bhis.exception.BookNotFoundException;
import com.jayklef.bhis.model.Book;
import com.jayklef.bhis.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BookServiceImpl implements  BookService{

    @Autowired
    private BookRepository bookRepository;


    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> findAllByIsArchivedFalse() throws BookNotFoundException {

        if (findAllByIsArchivedFalse().isEmpty()){
            throw new BookNotFoundException("No book archived");
        }
        return bookRepository.findAllByIsArchivedFalse();
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findBooksByAuthor(Long authorId) {
        return bookRepository.findAllById(Collections.singleton(authorId));
    }


}
