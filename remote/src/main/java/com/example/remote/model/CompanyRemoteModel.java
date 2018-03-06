package com.example.remote.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sujin on 1/15/18.
 */

public class CompanyRemoteModel {

  @SerializedName("id")
  private String id;
  @SerializedName("name")
  private String name;

  public CompanyRemoteModel() {
  }

  public CompanyRemoteModel(String id, String name) {
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
