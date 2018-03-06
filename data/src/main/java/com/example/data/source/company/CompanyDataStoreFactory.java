package com.example.data.source.company;

import com.example.data.repository.company.CompanyCache;
import com.example.data.repository.company.CompanyDataStore;
import javax.inject.Inject;

/**
 * Created by sujin on 1/15/18.
 */

public class CompanyDataStoreFactory {

  CompanyCache companyCache;
  CompanyCacheDataStore companyCacheDataStore;
  CompanyRemoteDataStore companyRemoteDataStore;

  @Inject
  public CompanyDataStoreFactory(CompanyCache companyCache,
      CompanyCacheDataStore companyCacheDataStore,
      CompanyRemoteDataStore companyRemoteDataStore) {
    this.companyCache = companyCache;
    this.companyCacheDataStore = companyCacheDataStore;
    this.companyRemoteDataStore = companyRemoteDataStore;
  }

  public CompanyDataStore getCompanyDataStore() {
    if (companyCache.isCached() && !companyCache.isExpired()) {
      return getCompanyCacheDataStore();
    }
    return getCompanyRemoteDataStore();
  }

  public CompanyCacheDataStore getCompanyCacheDataStore() {
    return companyCacheDataStore;
  }

  public CompanyRemoteDataStore getCompanyRemoteDataStore() {
    return companyRemoteDataStore;
  }
}
