package com.example.data.mapper;

import com.example.data.model.CompanyDataModel;
import com.example.domain.model.CompanyDomainModel;

/**
 * Created by sujin on 1/15/18.
 */

public class CompanyDataMapper implements Mapper<CompanyDataModel, CompanyDomainModel>{

  @Override
  public CompanyDomainModel mapFromEntity(CompanyDataModel type) {
    return new CompanyDomainModel(type.getId(), type.getName());
  }

  @Override
  public CompanyDataModel mapToEntity(CompanyDomainModel type) {
    return new CompanyDataModel(type.getId(), type.getName());
  }
}
