package com.example.controller;

import com.example.dto.ArticleParam;
import com.example.entity.Article;
import com.example.service.impl.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class ArticleController {
  @Autowired
  ArticleServiceImpl articleServiceImpl;

  @PostMapping("/article")
  // @RequestBody ArticleParam param
  // @RequestParam String title, @RequestParam String content
  public String insertArticle(@RequestBody ArticleParam param) {
    
    System.out.println(String.format("%s, %s", param.getTitle(), param.getContent()));
    Article article = new Article();

    article.setTitle(param.getTitle());
    article.setContent(param.getContent());

    articleServiceImpl.insertArticle(article);

    return "success";
  }
}
