package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;

@Entity
public class Article extends AbstractEntity {
  public String title;
  public String content;

  @Column(nullable = false, length = 255)
  public String getTitle() {
    return title;
  }

  @Column(nullable = false)
  public String getContent() {
    return content;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
