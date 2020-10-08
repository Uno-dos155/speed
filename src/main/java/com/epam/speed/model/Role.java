package com.epam.speed.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "role")
public class Role {
  @Id
private int id;
  @Column(name = "name")
  private String name;

}
