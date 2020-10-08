package com.epam.speed.service;

import static org.junit.jupiter.api.Assertions.*;

import com.epam.speed.model.Author;
import com.epam.speed.repository.AuthorRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class AuthorServiceImplTest {
private AuthorRepository authorRepository;
  @Test
  void saveAuthor() {
    Author author = new Author();
    author.setEmail("ddd@.com");
    author.setId(2);
    author.setName("Dodo");
    author.setSurname("Pizza");
    author.setTel("121212");
    authorRepository.save(author);
    Assert.assertNotNull(author);

  }
}