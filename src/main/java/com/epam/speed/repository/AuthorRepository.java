package com.epam.speed.repository;

import com.epam.speed.model.Author;
import com.epam.speed.model.Gender;
import com.epam.speed.model.Role;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

  @Query("select u from Author u where u.email = ?1")
  List<Author> findByEmail(String email);

  List<Author> findByNameContainingIgnoreCase(String name);

  List<Author> findByGender(Gender gender);

  List<Author> findByIinContainingIgnoreCase(String name);

 /* @Query("select u from Author u where u.role in :role")
  List<Author> findByRole(@Param("role") String role);*/

 List<Author> findByRole(Role role);
}
