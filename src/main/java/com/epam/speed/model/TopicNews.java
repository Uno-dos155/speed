package com.epam.speed.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "topic_news")
@Data
public class TopicNews {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
}
