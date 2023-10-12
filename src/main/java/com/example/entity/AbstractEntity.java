package com.example.entity;

// import jakarta.persistence.Column;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.MappedSuperclass;
// import jakarta.persistence.PrePersist;
// import jakarta.persistence.Transient;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;



// 专门用于持久化的父类注释，不会被当做 entity
@MappedSuperclass
public class AbstractEntity {
  private Long id;
  private Date createdAt;

  @Id
  // 自增
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  // updatable 表示是否允许在更新时操作该字段
  @Column(nullable = false, updatable = false)
  public Long getId() { 
    return id;
  }

  @Column(nullable = false, updatable = false, name = "created_at")
  public Date getCreatedAt() { return createdAt; }

  // virtual prop
  // @Transient
  // public ZonedDateTime getCreatedDateTime() {
  //   return Instant.ofEpochMilli(this.createdAt).atZone(ZoneId.systemDefault());
  // }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public void setId(Long id) {
    this.id = id;
  }

  // before insert hook
  @PrePersist
  public void preInsert() {
    setCreatedAt(new Date());
  }
}
