package com.example.presentation.mapper;

import com.example.domain.model.CompanyDomainModel;
import com.example.presentation.model.CompanyPrsntModel;
import javax.inject.Inject;

/**
 * Created by sujin on 1/15/18.
 */

public class CompanyPrsntMapper implements Mapper<CompanyPrsntModel, CompanyDomainModel>{

  @Inject
  public CompanyPrsntMapper() {
  }

  @Override
  public CompanyPrsntModel mapToPresentation(CompanyDomainModel type) {
    return new CompanyPrsntModel(type.getId(), type.getName());
  }
}
