package com.example.domain.model;

/**
 * Created by sujin on 1/15/18.
 */

public class CompanyDomainModel {
  private String id;
  private String name;

  public CompanyDomainModel() {
  }

  public CompanyDomainModel(String id, String name) {
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
