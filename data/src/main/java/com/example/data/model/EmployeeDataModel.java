package com.example.data.model;

import com.example.domain.model.CompanyDomainModel;

/**
 * Created by sujin on 1/15/18.
 */

public class EmployeeDataModel {

  private String id;
  private String name;
  private CompanyDataModel company;

  public EmployeeDataModel() {}

  public EmployeeDataModel(String id, String name,
      CompanyDataModel company) {
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

  public CompanyDataModel getCompany() {
    return company;
  }

  public void setCompany(CompanyDataModel company) {
    this.company = company;
  }
}
