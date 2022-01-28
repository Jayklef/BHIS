package com.jayklef.bhis.service;

import com.jayklef.bhis.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findAllAuthors();

    Author saveAuthor(Author author);
}
