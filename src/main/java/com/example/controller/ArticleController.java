package com.example.controller;

import com.example.common.Resp;
import com.example.dto.ArticleParam;
import com.example.entity.Article;
import com.example.service.impl.ArticleServiceImpl;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class ArticleController {
  @Autowired
  ArticleServiceImpl articleServiceImpl;

  @PostMapping("/article")
  // @RequestBody ArticleParam param
  // @RequestParam String title, @RequestParam String content
  public String insertArticle(@RequestBody ArticleParam param) {
    
    System.out.println(String.format("%s, %s", param.title, param.content));
    Article article = new Article();

    article.setTitle(param.title);
    article.setContent(param.content);

    articleServiceImpl.insertArticle(article);

    return "success";
  }

  @GetMapping("/article/{id}")
  public Resp getArticle(@PathVariable("id") int id, HttpServletResponse response) throws Exception {
    Article article = articleServiceImpl.getArticle(id);

    if(article == null) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    }
    
    return new Resp(article);
  }

  @GetMapping("/articles")
  public List<Article> listArticles(@RequestParam(name = "page", required = false, defaultValue = "1") int page, @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
    return articleServiceImpl.listArticles(page, pageSize);
  }

  @DeleteMapping("/article")
  public void deleteArticle(@RequestParam("id") int id) {
    articleServiceImpl.deleteArticle(id);
  }

  @PutMapping("/article")
  public Article updateArticle(@RequestBody ArticleParam param) {
    Article article = new Article();

    article.setId(param.id);
    article.setContent(param.content);
    article.setTitle(param.title);

    Article art = articleServiceImpl.updateArticle(article);

    return art;
  }
}
