package com.jayklef.bhis.controller;

import com.jayklef.bhis.model.Book;
import com.jayklef.bhis.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("books/")
@Slf4j
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/listofbooks")
    public ResponseEntity<List<Book>> getBookList(){
        log.info("Inside getBookList of BookController");
        List<Book> bookList = bookService.findAllBooks();
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

    public ResponseEntity<Book> saveBook(@RequestBody Book book){
        log.info("Inside saveBook of BookController");
        Book newBook = bookService.saveBook(book);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }
}
