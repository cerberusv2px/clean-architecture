package com.example.remote.mapper;

import com.example.data.model.CompanyDataModel;
import com.example.data.model.EmployeeDataModel;
import com.example.remote.model.CompanyRemoteModel;
import com.example.remote.model.EmployeeRemoteModel;

/**
 * Created by sujin on 1/15/18.
 */

public class EmployeeRemoteMapper implements Mapper<EmployeeRemoteModel, EmployeeDataModel>{

  CompanyRemoteMapper mapper;

  public EmployeeRemoteMapper(CompanyRemoteMapper mapper) {
    this.mapper = mapper;
  }

  @Override
  public EmployeeDataModel mapFromRemote(EmployeeRemoteModel type) {
    CompanyDataModel companyDataModel = mapper.mapFromRemote(type.getCompany());
    return new EmployeeDataModel(type.getId(), type.getName(), companyDataModel);
  }
}
