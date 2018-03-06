package com.example.cache.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by sujin on 1/15/18.
 */

public class CompanyCacheModel extends RealmObject{

  @PrimaryKey
  private String id;
  @Required
  private String name;

  public CompanyCacheModel() {}

  public CompanyCacheModel(String id, String name) {
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
