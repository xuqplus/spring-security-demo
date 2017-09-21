package cn.xuqplus.springsecuritydemo.entity;

import javax.persistence.Entity;

@Entity
public class Role extends BaseEntity {

  public String name;

  public Role() {
  }

  public Role(String name) {
    this.name = name;
  }
}
