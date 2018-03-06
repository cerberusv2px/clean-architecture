package com.example.cache.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by sujin on 1/15/18.
 */

public class EmployeeCacheModel extends RealmObject {

  @PrimaryKey
  private String id;
  @Required
  private String name;
  @Required
  private CompanyCacheModel company;

  public EmployeeCacheModel() {}

  public EmployeeCacheModel(String id, String name, CompanyCacheModel company) {
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

  public CompanyCacheModel getCompany() {
    return company;
  }

  public void setCompany(CompanyCacheModel company) {
    this.company = company;
  }
}
