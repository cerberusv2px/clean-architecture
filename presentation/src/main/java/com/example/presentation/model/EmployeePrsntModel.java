package com.example.presentation.model;

/**
 * Created by sujin on 1/15/18.
 */

public class EmployeePrsntModel {
  private String id;
  private String name;
  private CompanyPrsntModel company;

  public EmployeePrsntModel() {
  }

  public EmployeePrsntModel(String id, String name,
      CompanyPrsntModel company) {
    this.id = id;
    this.name = name;
    this.company = company;
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

  public CompanyPrsntModel getCompany() {
    return company;
  }

  public void setCompany(CompanyPrsntModel company) {
    this.company = company;
  }
}
