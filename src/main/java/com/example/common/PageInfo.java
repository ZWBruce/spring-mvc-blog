package com.example.common;

import java.util.List;

public class PageInfo<T> {
  public List<T> list;
  public int page;
  public int total;

  public PageInfo(List<T> list, int page, int total) {
    this.list = list;
    this.page = page;
    this.total = total;
  }

}
