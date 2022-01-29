package com.jayklef.bhis.controller;

import com.jayklef.bhis.model.Author;
import com.jayklef.bhis.model.Book;
import com.jayklef.bhis.service.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("authors/")
@Slf4j
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/list")
    public ResponseEntity<List<Author>> getAuthorList(){
        log.info("Inside getAuthorList of AuthorController");
        List<Author> authorList = authorService.findAllAuthors();
        return new ResponseEntity<>(authorList, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Author> saveAuthor(@RequestBody Author author){
        log.info("Inside saveAuthor of AuthorController");
        Author newAuthor = authorService.saveAuthor(author);
        return new ResponseEntity<>(newAuthor, HttpStatus.OK);
    }

    public ResponseEntity<Author> saveAuthorWithBook(){
        Author author = authorService.saveAuthorWithBook();
        return new ResponseEntity<>(author, HttpStatus.CREATED);
    }
}
