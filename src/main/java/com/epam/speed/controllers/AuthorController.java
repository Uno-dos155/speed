package com.epam.speed.controllers;

import com.epam.speed.model.Author;
import com.epam.speed.service.AuthorServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

  public void createAuthor(Author author) {
    authorService.saveAuthor(author);
  }

}
