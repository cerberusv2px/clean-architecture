package com.example.data.source;

import com.example.data.mapper.CompanyDataMapper;
import com.example.data.model.CompanyDataModel;
import com.example.data.repository.company.CompanyDataStore;
import com.example.data.source.company.CompanyCacheDataStore;
import com.example.data.source.company.CompanyDataStoreFactory;
import com.example.domain.model.CompanyDomainModel;
import com.example.domain.repository.company.CompanyRepository;
import io.reactivex.Completable;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by sujin on 1/15/18.
 */

public class CompanyDataRepository implements CompanyRepository {

  CompanyDataMapper mapper;
  CompanyDataStoreFactory factory;

  @Inject
  public CompanyDataRepository(CompanyDataMapper mapper,
      CompanyDataStoreFactory factory) {
    this.mapper = mapper;
    this.factory = factory;
  }

  @Override
  public Completable save(List<CompanyDomainModel> companyDomainModels) {
    List<CompanyDataModel> companyList = new ArrayList<>();
    for (CompanyDomainModel company : companyDomainModels) {
      companyList.add(mapper.mapToEntity(company));
    }
    return saveCompanyEntites(companyList);
  }

  @Override
  public Observable<List<CompanyDomainModel>> getAll() {
    List<CompanyDomainModel> companyDomaiList = new ArrayList<>();
    CompanyDataStore dataStore = factory.getCompanyDataStore();

    return dataStore
        .getAll()
        .flatMap(companyDataModels -> {
          if (dataStore instanceof CompanyCacheDataStore) {
            return saveCompanyEntites(companyDataModels).toObservable();
          } else {
            return Observable.just(companyDataModels);
          }
        })
        .map(companyList -> {
          for (CompanyDataModel c : companyList) {
            companyDomaiList.add(mapper.mapFromEntity(c));
          }
          return companyDomaiList;
        });
  }

  private Completable saveCompanyEntites(List<CompanyDataModel> companyList) {
    return factory.getCompanyCacheDataStore().save(companyList);
  }
}
