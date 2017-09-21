package cn.xuqplus.springsecuritydemo.listener;

import cn.xuqplus.springsecuritydemo.entity.BaseEntity;
import java.util.Date;
import javax.persistence.PreUpdate;

public class BaseEntityListener {

  @PreUpdate
  public void preUpdate(BaseEntity baseEntity) {
    baseEntity.modifyAt = new Date(System.currentTimeMillis());
  }
}
