package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;


// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;

@Entity
@SQLDelete(sql = "UPDATE article SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class Article extends AbstractEntity {
  public String title;
  public String content;

  /**
   * 删除操作：
   * User user = session.get(User.class, 1L); // 获取要删除的用户
   * session.delete(user); // 执行删除操作
   */

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
