package com.example.dto;


public class ArticleParam {
    private String title;
    private String content;

    public ArticleParam() {
    }

    public ArticleParam(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // Getter 和 Setter 方法
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
