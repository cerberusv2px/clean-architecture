package com.example.presentation.mapper;

import com.example.domain.model.EmployeeDomainModel;
import com.example.presentation.model.CompanyPrsntModel;
import com.example.presentation.model.EmployeePrsntModel;
import javax.inject.Inject;

/**
 * Created by sujin on 1/15/18.
 */

public class EmployeePrsntMapper implements Mapper<EmployeePrsntModel, EmployeeDomainModel>{

  CompanyPrsntMapper mapper;

  @Inject
  public EmployeePrsntMapper(CompanyPrsntMapper mapper) {
    this.mapper = mapper;
  }

  @Override
  public EmployeePrsntModel mapToPresentation(EmployeeDomainModel type) {
    CompanyPrsntModel companyPrsntModel = mapper.mapToPresentation(type.getCompany());
    return new EmployeePrsntModel(type.getId(), type.getName(), companyPrsntModel);
  }
}
