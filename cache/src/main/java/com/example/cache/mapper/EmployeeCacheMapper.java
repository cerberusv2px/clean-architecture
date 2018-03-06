package com.example.cache.mapper;

import com.example.cache.model.CompanyCacheModel;
import com.example.cache.model.EmployeeCacheModel;
import com.example.data.model.CompanyDataModel;
import com.example.data.model.EmployeeDataModel;
import com.example.data.repository.employee.EmployeeCache;

/**
 * Created by sujin on 1/15/18.
 */

public class EmployeeCacheMapper implements Mapper<EmployeeCacheModel, EmployeeDataModel> {

  CompanyCacheMapper mapper;

  public EmployeeCacheMapper(CompanyCacheMapper mapper) {
    this.mapper = mapper;
  }


  @Override
  public EmployeeDataModel mapFromCache(EmployeeCacheModel type) {
    CompanyDataModel companyDataModel = mapper.mapFromCache(type.getCompany());
    return new EmployeeDataModel(type.getId(), type.getName(), companyDataModel);
  }

  @Override
  public EmployeeCacheModel mapToCache(EmployeeDataModel type) {
    CompanyCacheModel companyCacheModel = mapper.mapToCache(type.getCompany());
    return new EmployeeCacheModel(type.getId(), type.getName(), companyCacheModel);
  }
}
