package com.example.data.model;

/**
 * Created by sujin on 1/15/18.
 */

public class CompanyDataModel {
  private String id;
  private String name;

  public CompanyDataModel() {
  }

  public CompanyDataModel(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
