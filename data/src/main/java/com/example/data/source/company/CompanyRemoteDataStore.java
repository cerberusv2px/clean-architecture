package com.example.data.source.company;

import com.example.data.model.CompanyDataModel;
import com.example.data.repository.company.CompanyDataStore;
import com.example.data.repository.company.CompanyRemote;
import io.reactivex.Completable;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by sujin on 1/15/18.
 */

public class CompanyRemoteDataStore implements CompanyDataStore {

  CompanyRemote companyRemote;

  @Inject
  public CompanyRemoteDataStore(CompanyRemote companyRemote) {
    this.companyRemote = companyRemote;
  }

  @Override
  public Completable save(List<CompanyDataModel> companyDataModels) {
    throw new UnsupportedOperationException();
  }

  @Override
  public Observable<List<CompanyDataModel>> getAll() {
    return companyRemote.getAll();
  }
}
