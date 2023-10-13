package com.example.service.impl;

import com.example.entity.Article;
import com.example.service.ArticleService;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {
  @Autowired
  public SessionFactory sessionFactory;

  @Override
  public void insertArticle(Article article) {
    System.out.println(String.format("%s, %s, %d, %d", article.content, article.title, article.getCreatedAt(), article.getId()));
    Session session = sessionFactory.getCurrentSession();
    Transaction transaction = session.beginTransaction();
    
    // persist 需要事务提交，而 save 不需要事务
    try {
      session.persist(article);
      transaction.commit();
    }catch(Exception e) {
      transaction.rollback();
      throw e;
    }
  }

  @Override
  public List<Article> listArticles(int page, int pageSize) {
    Session session = sessionFactory.getCurrentSession();

    Query<Article> query = session.createQuery("FROM Article");

    query.setFirstResult(pageSize * (page - 1));

    query.setMaxResults(pageSize);

    List<Article> articles = query.list();

    return articles;
  }

  @Override
  public void deleteArticle(int id) {
    Session session = sessionFactory.getCurrentSession();
    Article article = session.byId(Article.class).load(id);
    System.out.println(article.getId());

    Transaction transaction = session.beginTransaction();

    try {
      // 还有个方法叫 remove
      session.delete(article);
      transaction.commit();
    }catch(Exception e) {
      transaction.rollback();
      throw e;
    }
    
  }

  @Override
  public Article updateArticle(Article article) {
    Session session = sessionFactory.getCurrentSession();
    Article art = session.byId(Article.class).load(article.getId());

    art.setContent(article.content);

    art.setTitle(article.title);

    Transaction transaction = session.beginTransaction();

    try {
      // 还有个方法叫 remove
      session.merge(art);
      transaction.commit();
    }catch(Exception e) {
      transaction.rollback();
      throw e;
    }

    return art;
  }

  @Override
  public Article getArticle(int id) {
    Session session = sessionFactory.getCurrentSession();
    Article article = session.byId(Article.class).load(id);
    return article;
  }
}
