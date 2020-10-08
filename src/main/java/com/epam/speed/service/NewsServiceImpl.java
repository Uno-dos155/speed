package com.epam.speed.service;

import com.epam.speed.model.News;
import com.epam.speed.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl {

  @Autowired
  public NewsServiceImpl(NewsRepository newsRepository) {
    this.newsRepository = newsRepository;
  }

  private final NewsRepository newsRepository;

  public News createNews(News news) {
    return newsRepository.save(news);
  }

}
