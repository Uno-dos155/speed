package com.epam.speed.repository;

import com.epam.speed.model.Author;
import com.epam.speed.model.News;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {

  List<News> findByTopicNews_nameLikeIgnoreCase(String name);
}
