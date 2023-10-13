package com.example.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

// 专门用于持久化的父类注释，不会被当做 entity
@MappedSuperclass
public class AbstractEntity {
  private int id;
  private Date createdAt;
  private Date updatedAt;
  private Boolean deleted;

  @Id
  // 自增
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  // updatable 表示是否允许在更新时操作该字段
  @Column(nullable = false, updatable = false)
  public int getId() { 
    return id;
  }

  @Column(nullable = false, updatable = false, name = "created_at")
  public Date getCreatedAt() { return createdAt; }

  @Column(nullable = true)
  public Boolean getDeleted() { return deleted; }

  @Column(nullable = false, name = "updated_at")
  public Date getUpdatedAt() { return updatedAt; }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  public void setDeleted(Boolean deleted) {
    this.deleted = deleted;
  }

  // before insert hook
  @PrePersist
  public void preInsert() {
    setCreatedAt(new Date());
    setUpdatedAt(new Date());
    setDeleted(false);
  }

  @PreUpdate
  @PreRemove
  public void setUpdate() {
    setUpdatedAt(new Date());
  }
}
