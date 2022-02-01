package com.jayklef.bhis.controller;

import com.jayklef.bhis.model.Book;
import com.jayklef.bhis.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
@Slf4j
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("")
    public ResponseEntity<List<Book>> getBooks(){
        //All books not archived
        log.info("Inside getBookList of BookController");
        List<Book> bookList = bookService.findAllBooks();
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Book> saveBook(@RequestBody Book book){
        log.info("Inside saveBook of BookController");
        Book newBook = bookService.saveBook(book);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    @GetMapping("/booksbyauthor")
    public ResponseEntity<List<Book>> getBooksByAuthor(@PathVariable("authorid") Long authorId){
        log.info("Inside getBooksByAuthor of BookController");
        List<Book> authorBooks = bookService.findBooksByAuthor(authorId);
        return new ResponseEntity<>(authorBooks, HttpStatus.OK);
    }
}
