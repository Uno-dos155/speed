package com.epam.speed.repository;

import com.epam.speed.model.Author;
import com.epam.speed.model.Gender;
import com.epam.speed.model.Role;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class AuthorRepositoryTest {

  ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
  Validator validator = factory.getValidator();

  @Autowired
  AuthorRepository authorRepository;


  @Test
  void saveAuthor() {
    Author author = new Author();
    author.setEmail("dddgg@mail.ru");
    Role role = new Role();
    role.setId(1);
    author.setId(2);
    author.setRole(role);
    author.setName("Ivan");
    author.setSurname("Ivanov");
    author.setTel("12");
    author.setGender(Gender.MALE);
    author.setIin("123123123123");
    Set<ConstraintViolation<Author>> violations = validator.validate(author);
    for (ConstraintViolation<Author> violation : violations) {
      System.out.println(violation.getMessage());
    }
    authorRepository.save(author);
    Assert.assertNotNull(author);
  }

  @Test
  void findUseEmail() {
    List<Author> authorList = new ArrayList<>();
    if (authorRepository != null) {
      authorList = authorRepository.findByEmail("dara@mail.ru");
    }
    for (Author author1 : authorList) {
      if (author1 != null) {
        System.out.println(author1.getSurname());
      } else {
        System.out.println("Такого пользователя нет");
      }
    }
  }

  @Test
  void findUseIin() throws Exception {
    List<Author> authorList;
    authorList = authorRepository.findByIinContainingIgnoreCase("123");
    for (Author author1 : authorList) {
      if (author1 != null) {
        System.out.println(author1.getSurname());
      } else {
        System.out.println("Такого пользователя нет");
      }
    }
    Assert.assertNotNull(authorList);
  }

  @Test
  void findUseName() throws Exception {
    List<Author> authorList;
    authorList = authorRepository.findByNameContainingIgnoreCase("llk");
    for (Author author1 : authorList) {
      if (author1 != null) {
        System.out.println(author1.getSurname());
      }
    }
    Assert.assertNotNull(authorList);
  }

  @Test
  void findUseRole() {
    List<Author> authorList;
    Role role = new Role();
    role.setId(2);
    authorList = authorRepository.findByRole(role);
    for (Author author1 : authorList) {
      System.out.println(author1.getSurname());
    }
    Assert.assertNotNull(authorList);
  }

  @Test
  void getAllUsers() {
    List<Author>authorList = authorRepository.findAll();
    Assert.assertNotNull(authorList);
  }
}