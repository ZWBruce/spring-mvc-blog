create database my_blog;

CREATE TABLE article(
  id INT PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(255) NOT NULL,
  content TEXT NOT NULL,
  created_at TIMESTAMP default CURRENT_TIMESTAMP not null
);