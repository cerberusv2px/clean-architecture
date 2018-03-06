package com.example.data.source.employee;

import com.example.data.repository.employee.EmployeeCache;
import com.example.data.repository.employee.EmployeeDataStore;
import javax.inject.Inject;

/**
 * Created by sujin on 1/15/18.
 */

public class EmployeeDataStoreFactory {

  EmployeeCache employeeCache;
  EmployeeCacheDataStore employeeCacheDataStore;
  EmployeeRemoteDataStore employeeRemoteDataStore;

  @Inject
  public EmployeeDataStoreFactory(EmployeeCache employeeCache,
      EmployeeCacheDataStore employeeCacheDataStore,
      EmployeeRemoteDataStore employeeRemoteDataStore) {
    this.employeeCache = employeeCache;
    this.employeeCacheDataStore = employeeCacheDataStore;
    this.employeeRemoteDataStore = employeeRemoteDataStore;
  }

  public EmployeeDataStore getEmployeeDataStore() {
    if(employeeCache.isCached() && !employeeCache.isExpired()) {
      return getEmployeeCacheDataStore();
    }
    return getEmployeeRemoteDataStore();
  }

  public EmployeeCacheDataStore getEmployeeCacheDataStore() {
    return employeeCacheDataStore;
  }

  public EmployeeRemoteDataStore getEmployeeRemoteDataStore() {
    return employeeRemoteDataStore;
  }
}
