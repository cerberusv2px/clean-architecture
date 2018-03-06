package com.example.domain.model;

/**
 * Created by sujin on 1/15/18.
 */

public class EmployeeDomainModel {
  private String id;
  private String name;
  private CompanyDomainModel company;

  public EmployeeDomainModel() {

  }

  public EmployeeDomainModel(String id, String name,
      CompanyDomainModel company) {
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

  public CompanyDomainModel getCompany() {
    return company;
  }

  public void setCompany(CompanyDomainModel company) {
    this.company = company;
  }
}
