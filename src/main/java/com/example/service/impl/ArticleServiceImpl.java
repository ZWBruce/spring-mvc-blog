package com.example.service.impl;

import com.example.entity.Article;
import com.example.service.ArticleService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service
public class ArticleServiceImpl implements ArticleService {
  @Autowired
  SessionFactory sessionFactory;

  // @Autowired
  // HibernateTransactionManager transactionManager;

  @Override
  public void insertArticle(Article article) {
    System.out.println(String.format("%s, %s, %d, %d", article.content, article.title, article.getCreatedAt(), article.getId()));
    // DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition();

    // transactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
    
    // TransactionStatus status = transactionManager.getTransaction(transactionDefinition);

    
    // try {
    //   sessionFactory.getCurrentSession().persist(article);
    //   transactionManager.commit(status);
    // }catch(HibernateException e) {
    //   transactionManager.rollback(status);
    //   throw e;
    // }

    Session session = sessionFactory.getCurrentSession();

    Transaction transaction = session.beginTransaction();
    try {
      session.persist(article);
      transaction.commit();
    }catch(Exception e) {
      transaction.rollback();
      throw e;
    }
    
  }
}
