package com.example.data.source.company;

import com.example.data.model.CompanyDataModel;
import com.example.data.repository.company.CompanyCache;
import com.example.data.repository.company.CompanyDataStore;
import io.reactivex.Completable;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by sujin on 1/15/18.
 */

public class CompanyCacheDataStore implements CompanyDataStore{

  private CompanyCache companyCache;

  @Inject
  public CompanyCacheDataStore(CompanyCache companyCache) {
    this.companyCache = companyCache;
  }

  @Override
  public Completable save(List<CompanyDataModel> companyDataModels) {
    return companyCache.save(companyDataModels)
        .doOnComplete(() -> {
          companyCache.setLastCacheTime(System.currentTimeMillis());
        });
  }

  @Override
  public Observable<List<CompanyDataModel>> getAll() {
    return companyCache.getAll();
  }
}
