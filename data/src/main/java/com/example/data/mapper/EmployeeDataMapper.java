package com.example.data.mapper;

import com.example.data.model.CompanyDataModel;
import com.example.data.model.EmployeeDataModel;
import com.example.domain.model.CompanyDomainModel;
import com.example.domain.model.EmployeeDomainModel;

/**
 * Created by sujin on 1/15/18.
 */

public class EmployeeDataMapper implements
    Mapper<EmployeeDataModel, EmployeeDomainModel> {

  private CompanyDataMapper mapper;

  public EmployeeDataMapper(CompanyDataMapper mapper) {
    this.mapper = mapper;
  }

  @Override
  public EmployeeDomainModel mapFromEntity(EmployeeDataModel type) {
    CompanyDomainModel companyDomainModel = mapper.mapFromEntity(type.getCompany());
    return new EmployeeDomainModel(type.getId(), type.getName(), companyDomainModel);
  }

  @Override
  public EmployeeDataModel mapToEntity(EmployeeDomainModel type) {
    CompanyDataModel companyDataModel = mapper.mapToEntity(type.getCompany());
    return new EmployeeDataModel(type.getId(), type.getName(),companyDataModel);
  }
}
