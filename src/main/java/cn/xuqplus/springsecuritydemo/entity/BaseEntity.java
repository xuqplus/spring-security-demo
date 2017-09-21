package cn.xuqplus.springsecuritydemo.entity;

import cn.xuqplus.springsecuritydemo.listener.BaseEntityListener;
import java.util.Date;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@MappedSuperclass
@EntityListeners(BaseEntityListener.class)
public abstract class BaseEntity {

  @Temporal(TemporalType.TIMESTAMP)
  public Date createAt = new Date(System.currentTimeMillis());
  @Temporal(TemporalType.TIMESTAMP)
  public Date modifyAt = new Date(System.currentTimeMillis());
  @Id
  @GeneratedValue
  public Long id;
  @Version
  public Integer version;
  public boolean isDeleted;
}
