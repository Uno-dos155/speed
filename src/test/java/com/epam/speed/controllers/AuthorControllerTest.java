package com.epam.speed.controllers;

import static org.junit.jupiter.api.Assertions.*;

import com.epam.speed.model.Author;
import com.epam.speed.model.Role;
import com.epam.speed.service.AuthorServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class AuthorControllerTest {
  @Autowired
  AuthorServiceImpl authorService;

  @Test
  void createAuthor() {
    Author author = new Author();
    Role role = new Role();
    role.setId(1);
    author.setEmail("ddd@.com");
    author.setId(2);
    author.setName("Dodo");
    author.setSurname("Pizza");
    author.setTel("121212");
    author.setRole(role);
    authorService.saveAuthor(author);
    Assert.assertNotNull(author);
  }
}