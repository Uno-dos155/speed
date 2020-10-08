package com.epam.speed.controllers;

import com.epam.speed.model.News;
import com.epam.speed.service.NewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NewsController {

  private final NewsServiceImpl newsService;

  @Autowired
  public NewsController(NewsServiceImpl newsService) {
    this.newsService = newsService;
  }

  @GetMapping("/create")
  public String createNewsForm(News news) {
    return "create_news";
  }

  @PostMapping("/news-create")
  public String saveNews(@ModelAttribute("news") News news) {
    newsService.createNews(news);
    return "authors-list";
  }
}
