package com.epam.speed.model;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@Table(name = "news")
public class News {
  @NotBlank(message = "Заполни текст")
  @Size(min = 6)
  @Column(name = "text_news")
  private String textOfNews;

  @NotBlank(message = "Заполни заголовок")
  @Size(min = 2, max = 30)
  @Column(name = "title_news")
  private String titleNews;

  @OneToOne(optional = false, cascade = CascadeType.PERSIST)
  @JoinColumn(name = "topic_news_id")
  private TopicNews topicNews;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate date_news = LocalDate.now();
  public News() {
  }

}
