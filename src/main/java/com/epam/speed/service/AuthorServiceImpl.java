package com.epam.speed.service;

import com.epam.speed.model.Author;
import com.epam.speed.model.Gender;
import com.epam.speed.model.Role;
import com.epam.speed.repository.AuthorRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl {

  private final AuthorRepository authorRepository;

  public List<Author> getAllAuthors() {
    return authorRepository.findAll();
  }

  public Author saveAuthor(Author author) {
    Role role = new Role();
    role.setId(2);
    author.setRole(role);
    authorRepository.save(author);
    return author;
  }

  public Author findById(Integer id) {
    return authorRepository.getOne(id);
  }

  public void deleteAuthorById(Integer id) {
    authorRepository.deleteById(id);
  }

  public List<Author> findByEmailAuthor(String email) {
    return authorRepository.findByEmail(email);
  }

  public List<Author> findByName(String name) {
    return authorRepository.findByNameContainingIgnoreCase(name);
  }

  public List<Author> findByIin(String iin) {
    return authorRepository.findByIinContainingIgnoreCase(iin);
  }

  public List<Author> findByRole(Role role) {
    return authorRepository.findByRole(role);
  }

  public List<Author> findByGender(Gender gender) {
    return authorRepository.findByGender(gender);
  }
}
