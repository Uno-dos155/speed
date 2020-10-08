package com.epam.speed.model;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "news")
public class News {

  public News() {
  }

  @OneToOne
  @JoinColumn(name = "text_news_id")
  private TextOfNews textOfNews;

  @OneToOne()
  @JoinColumn(name = "topic_news_id")
  private TopicNews topicNews;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Basic
  private Date date_news;





}
