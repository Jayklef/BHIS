package com.jayklef.bhis.service;

import com.jayklef.bhis.model.Author;
import com.jayklef.bhis.model.Book;
import com.jayklef.bhis.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author saveAuthorWithBook() {
        Book book = Book.builder()
                .isbn(toString())
                .title(toString())
                .build();

        Author author = Author.builder()
                .name(toString())
                .books(List.of(book))
                .build();
        return authorRepository.save(author);
    }
}
