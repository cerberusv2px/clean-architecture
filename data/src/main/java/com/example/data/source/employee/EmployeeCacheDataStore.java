package com.example.data.source.employee;

import com.example.data.model.EmployeeDataModel;
import com.example.data.repository.employee.EmployeeCache;
import com.example.data.repository.employee.EmployeeDataStore;
import io.reactivex.Completable;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by sujin on 1/15/18.
 */

public class EmployeeCacheDataStore implements EmployeeDataStore {

  private EmployeeCache employeeCache;

  @Inject
  public EmployeeCacheDataStore(EmployeeCache employeeCache) {
    this.employeeCache = employeeCache;
  }

  @Override
  public Completable save(List<EmployeeDataModel> employeeDataModels) {
    return employeeCache.save(employeeDataModels)
        .doOnComplete(() -> {
          employeeCache.setLastCacheTime(System.currentTimeMillis());
        });
  }

  @Override
  public Observable<List<EmployeeDataModel>> getAll() {
    return employeeCache.getAll();
  }
}
