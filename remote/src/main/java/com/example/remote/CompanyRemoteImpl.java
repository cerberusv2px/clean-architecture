package com.example.remote;

import com.example.data.model.CompanyDataModel;
import com.example.data.repository.company.CompanyRemote;
import com.example.remote.mapper.CompanyRemoteMapper;
import com.example.remote.model.CompanyRemoteModel;
import com.example.remote.service.APIService;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by sujin on 1/15/18.
 */

public class CompanyRemoteImpl implements CompanyRemote {

  private APIService apiService;
  private CompanyRemoteMapper mapper;

  @Inject
  public CompanyRemoteImpl(APIService apiService,
      CompanyRemoteMapper mapper) {
    this.apiService = apiService;
    this.mapper = mapper;
  }

  @Override
  public Observable<List<CompanyDataModel>> getAll() {
    List<CompanyDataModel> companyDataModelList = new ArrayList<>();
    return apiService
        .getAllCompany()
        .map(companyRemoteModels -> {
          for (CompanyRemoteModel c : companyRemoteModels) {
            companyDataModelList.add(mapper.mapFromRemote(c));
          }
          return companyDataModelList;
        });
  }
}
