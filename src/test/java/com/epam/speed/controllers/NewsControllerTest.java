package com.epam.speed.controllers;

import static org.junit.jupiter.api.Assertions.*;

import com.epam.speed.model.News;
import com.epam.speed.model.TextOfNews;
import com.epam.speed.model.TopicNews;
import com.epam.speed.service.NewsServiceImpl;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class NewsControllerTest {
  @Autowired
NewsServiceImpl newsService;
  @Test
  void saveNews() throws ParseException {
    News news = new News();
    String date = "2020-02-03";
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date sqlDate = new Date(dateFormat.parse(date).getTime());
    news.setDate_news(sqlDate);
   // news.setId(3);
    TextOfNews textOfNews = new TextOfNews();
    textOfNews.setId(1);
    textOfNews.setContent("Hello world");
    news.setTextOfNews(textOfNews);
    TopicNews topicNews = new TopicNews();
    topicNews.setId(2);
    news.setTopicNews(topicNews);
    newsService.createNews(news);
    Assert.assertNotNull(news);

  }
}