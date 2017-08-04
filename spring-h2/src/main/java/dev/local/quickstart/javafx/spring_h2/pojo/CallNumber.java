package dev.local.quickstart.javafx.spring_h2.pojo;

import lombok.Data;

@Data
public class CallNumber {

  private Integer id;

  private String name;

  private Integer number;

  public CallNumber() {
  }

  public CallNumber(Integer id, String name, Integer number) {
    this.id = id;
    this.name = name;
    this.number = number;
  }

}
