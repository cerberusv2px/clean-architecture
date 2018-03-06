package com.example.cache;

import com.example.cache.mapper.EmployeeCacheMapper;
import com.example.cache.model.CompanyCacheModel;
import com.example.cache.model.EmployeeCacheModel;
import com.example.data.model.CompanyDataModel;
import com.example.data.model.EmployeeDataModel;
import com.example.data.repository.employee.EmployeeCache;
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

public class EmployeeCacheImpl implements EmployeeCache {

  EmployeeCacheMapper mapper;
  PreferenceHelper preferenceHelper;

  @Inject
  public EmployeeCacheImpl(EmployeeCacheMapper mapper,
      PreferenceHelper preferenceHelper) {
    this.mapper = mapper;
    this.preferenceHelper = preferenceHelper;
  }

  @Override
  public Completable save(List<EmployeeDataModel> t) {
    List<EmployeeCacheModel> empList = new ArrayList<>();
    for (EmployeeDataModel e : t) {
      empList.add(mapper.mapToCache(e));
    }

    return Completable.defer(() -> {
      Realm realm = Realm.getDefaultInstance();
      try {
        realm.executeTransaction(new Transaction() {
          @Override
          public void execute(Realm realm) {
            realm.insertOrUpdate(empList);
          }
        });
        return Completable.complete();
      } finally {
        realm.close();
      }
    });
  }

  @Override
  public Observable<List<EmployeeDataModel>> getAll() {
    Realm realm = Realm.getDefaultInstance();
    List<EmployeeDataModel> employeeDataModel = new ArrayList<>();
    return Observable.defer(() -> {
      RealmResults<EmployeeCacheModel> result
          = realm.where(EmployeeCacheModel.class).findAll();
      for (EmployeeCacheModel c : result) {
        employeeDataModel.add(mapper.mapFromCache(c));
      }

      return Observable.just(employeeDataModel);
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
