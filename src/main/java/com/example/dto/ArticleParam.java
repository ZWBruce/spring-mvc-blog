package com.example.dto;


public class ArticleParam {
    public String title;
    public String content;
    public int id;

    public ArticleParam() {
    }

    // Getter 和 Setter 方法
    public String getTitle() {
        return title;
    }

    public ArticleParam setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public ArticleParam setContent(String content) {
        this.content = content;
        return this;
    }

    public int getId() {
        return id;
    }

    public ArticleParam setId(int id) {
        this.id = id;
        return this;
    }
}
