package com.example.remote.mapper;

import com.example.data.model.CompanyDataModel;
import com.example.remote.model.CompanyRemoteModel;

/**
 * Created by sujin on 1/15/18.
 */

public class CompanyRemoteMapper implements Mapper<CompanyRemoteModel, CompanyDataModel> {

  @Override
  public CompanyDataModel mapFromRemote(CompanyRemoteModel type) {
    return new CompanyDataModel(type.getId(), type.getName());
  }
}
