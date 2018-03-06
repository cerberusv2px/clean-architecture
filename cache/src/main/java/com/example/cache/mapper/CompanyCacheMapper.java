package com.example.cache.mapper;

import com.example.cache.model.CompanyCacheModel;
import com.example.data.model.CompanyDataModel;

/**
 * Created by sujin on 1/15/18.
 */

public class CompanyCacheMapper implements Mapper<CompanyCacheModel, CompanyDataModel> {

  @Override
  public CompanyDataModel mapFromCache(CompanyCacheModel type) {
    return new CompanyDataModel(type.getId(), type.getName());
  }

  @Override
  public CompanyCacheModel mapToCache(CompanyDataModel type) {
    return new CompanyCacheModel(type.getId(), type.getName());
  }
}
