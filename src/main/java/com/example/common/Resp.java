package com.example.common;

public class Resp<T> {
  private T data;

  public Resp(T param) {
    this.data = param;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }
}
