package com.example.service;

import com.example.entity.Article;
import java.util.List;


public interface ArticleService {
  public void insertArticle(Article article);

  public List<Article> listArticles(int page, int pageSize);

  public void deleteArticle(int id);

  public Article updateArticle(Article article);

  public Article getArticle(int id);
}
