package com.epam.speed.controllers;

import com.epam.speed.model.Author;
import com.epam.speed.model.Role;
import com.epam.speed.service.AuthorServiceImpl;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorController {

  private final AuthorServiceImpl authorService;

  @Autowired
  public AuthorController(AuthorServiceImpl authorService) {
    this.authorService = authorService;
  }

  @GetMapping("/authors")
  public String showAllAuthors(Model model) {
    List<Author> authorList = authorService.getAllAuthors();
    model.addAttribute("authors", authorList);
    return "authors-list";
  }

  @PostMapping("/email-find")
  public String findByEmailAuthor(Author author, Model model) {
    List<Author>authorList = authorService.findByEmailAuthor(author.getEmail());
    model.addAttribute("authors", authorList);
    return "author-list-email";
  }
  @PostMapping("/iin-find")
  public String findByIinAuthor(Author author, Model model) {
    List<Author>authorList = authorService.findByIin(author.getIin());
    model.addAttribute("authors", authorList);
    return "author-list-iin";
  }
  @PostMapping("/gender-find")
  public String findByGender(Author author, Model model) {
    List<Author>authorList = authorService.findByGender(author.getGender());
    model.addAttribute("authors", authorList);
    return "author-list-gender";
  }
  @PostMapping("/role-find")
  public String findByRole(Role role, Model model) {
    List<Author>authorList = authorService.findByRole(role);
    model.addAttribute("authors", authorList);
    return "author-list-role";
  }
  @GetMapping("/author-delete/{id}")
  public String deleteAuthor(@PathVariable("id") Integer id) {
    authorService.deleteAuthorById(id);
    return "redirect:/authors";
  }

  @GetMapping("/author-form")
  public String createAuthorForm(Author author) {
    return "author-form";
  }

  @PostMapping("/author-create")
  public String createAuthor(@Valid Author author) {
    authorService.saveAuthor(author);
    return "redirect:/authors";
  }

  @GetMapping("/find-email")
  public String findByEmail(Author author) {
    return "find-email";
  }
  @GetMapping("/find-iin")
  public String findByIin(Author author) {
    return "find-iin";
  }
  @GetMapping("/find-role")
  public String findByRole(Role role) {
    return "find-role";
  }
  @GetMapping("/find-gender")
  public String findByGender(Author author) {
    return "find-gender";
  }
}
