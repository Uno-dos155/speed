package com.epam.speed.repository;

import com.epam.speed.model.Author;
import com.epam.speed.model.News;
import com.epam.speed.model.TopicNews;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class NewsRepositoryTest {
  ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
  Validator validator = factory.getValidator();

  @Autowired
  NewsRepository newsRepository;

  @Test
  public void createNews() {
    News news = new News();
    news.setId(3);
    news.setTextOfNews("Some text about culture ");
    TopicNews topicNews = new TopicNews();
    topicNews.setId(1);
    news.setTopicNews(topicNews);
    news.setTitleNews("Cartoon");
    Set<ConstraintViolation<News>> violations = validator.validate(news);
    for (ConstraintViolation<News> violation : violations) {
      System.out.println(violation.getMessage());
    }
    newsRepository.save(news);
    Assert.assertNotNull(news);
  }

  public void findByTopic(){
    TopicNews topicNews = new TopicNews();
    topicNews.setId(3);
    List<News> newsList = newsRepository.findByTopicNews_nameLikeIgnoreCase("economic");
    for(News news:newsList){
      System.out.println(news.getTextOfNews());
    }
  }
}