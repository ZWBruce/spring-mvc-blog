package com.example.service;

import com.example.common.PageInfo;
import com.example.entity.Article;


public interface ArticleService {
  public Article insertArticle(Article article);

  public PageInfo<Article> listArticles(int page, int pageSize);

  public void deleteArticle(int id);

  public Article updateArticle(Article article);

  public Article getArticle(int id);
}
