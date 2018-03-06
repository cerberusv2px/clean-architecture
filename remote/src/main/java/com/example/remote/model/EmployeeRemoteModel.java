package com.example.remote.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sujin on 1/15/18.
 */

public class EmployeeRemoteModel {

  @SerializedName("id")
  private String id;
  @SerializedName("name")
  private String name;
  @SerializedName("company")
  private CompanyRemoteModel company;

  public EmployeeRemoteModel() {
  }

  public EmployeeRemoteModel(String id, String name,
      CompanyRemoteModel company) {
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

  public CompanyRemoteModel getCompany() {
    return company;
  }

  public void setCompany(CompanyRemoteModel company) {
    this.company = company;
  }
}
