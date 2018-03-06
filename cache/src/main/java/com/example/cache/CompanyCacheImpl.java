package com.example.cache;

import com.example.cache.mapper.CompanyCacheMapper;
import com.example.cache.model.CompanyCacheModel;
import com.example.data.model.CompanyDataModel;
import com.example.data.repository.company.CompanyCache;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.realm.Realm;
import io.realm.Realm.Transaction;
import io.realm.RealmResults;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by sujin on 1/15/18.
 */

public class CompanyCacheImpl implements CompanyCache {

  CompanyCacheMapper mapper;
  PreferenceHelper preferenceHelper;

  @Inject
  public CompanyCacheImpl(CompanyCacheMapper mapper, PreferenceHelper preferenceHelper) {
    this.mapper = mapper;
    this.preferenceHelper = preferenceHelper;
  }

  @Override
  public Completable save(List<CompanyDataModel> t) {

    List<CompanyCacheModel> companyList = new ArrayList<>();
    for (CompanyDataModel c : t) {
      companyList.add(mapper.mapToCache(c));
    }

    return Completable.defer(() -> {
      Realm realm = Realm.getDefaultInstance();
      try {
        realm.executeTransaction(new Transaction() {
          @Override
          public void execute(Realm realm) {
            realm.insertOrUpdate(companyList);
          }
        });
        return Completable.complete();
      } finally {
        if (realm != null) {
          realm.close();
        }
      }
    });
  }

  @Override
  public Observable<List<CompanyDataModel>> getAll() {
    Realm realm = Realm.getDefaultInstance();
    List<CompanyDataModel> companyDataModel = new ArrayList<>();
    return Observable.defer(() -> {
      RealmResults<CompanyCacheModel> result
          = realm.where(CompanyCacheModel.class).findAll();
      for (CompanyCacheModel c : result) {
        companyDataModel.add(mapper.mapFromCache(c));
      }

      return Observable.just(companyDataModel);
    });
  }

  @Override
  public boolean isCached() {
    return false;
  }

  @Override
  public void setLastCacheTime(long time) {
    preferenceHelper.setCacheTime(time);
  }

  @Override
  public boolean isExpired() {
    return false;
  }
}
