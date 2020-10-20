package com.epam.speed.model;

import com.sun.istack.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.Setter;

@Data
@Setter
@Entity
@Table(name = "author")
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @NotBlank(message = "Заполни имя")
  @NotNull
  @Size(min = 4, max = 20)
  @NotBlank(message = "Заполни имя")
  private String name;
  @NotNull
  @NotBlank(message = "Заполни фамилию")
  private String surname;
  @NotNull
  @Email(message = "nepravilno post")
  private String email;
  @NotNull
  @NotBlank(message = "Заполни телефон")
  @Size(min = 6, max = 20)
  private String tel;
  @NotNull
  @NotBlank(message = "Заполни иин")
  private String iin;
  @Column(name = "gender")
  @Enumerated(EnumType.STRING)
  @NotBlank(message = "Заполни пол")
  private Gender gender;
  @OneToOne()
  @JoinColumn(name = "role_id")
  private Role role;
}
