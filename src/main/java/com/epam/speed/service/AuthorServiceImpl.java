package com.epam.speed.service;

import com.epam.speed.model.Author;
import com.epam.speed.model.News;
import com.epam.speed.repository.AuthorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl {
  News news;


  Author author;
  @Autowired
  AuthorRepository authorRepository;

  public List<Author> getAllAuthors() {
    return authorRepository.findAll();
  }

  public void saveAuthor(Author author) {
    authorRepository.save(author);
  }

}
