package com.example.data.source;

import com.example.data.mapper.EmployeeDataMapper;
import com.example.data.model.EmployeeDataModel;
import com.example.data.repository.employee.EmployeeDataStore;
import com.example.data.source.employee.EmployeeCacheDataStore;
import com.example.data.source.employee.EmployeeDataStoreFactory;
import com.example.domain.model.EmployeeDomainModel;
import com.example.domain.repository.employee.EmployeeRepository;
import io.reactivex.Completable;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by sujin on 1/15/18.
 */

public class EmployeeDataRepository implements EmployeeRepository {

  private EmployeeDataMapper mapper;
  private EmployeeDataStoreFactory factory;

  @Inject
  public EmployeeDataRepository(EmployeeDataMapper mapper,
      EmployeeDataStoreFactory factory) {
    this.mapper = mapper;
    this.factory = factory;
  }

  @Override
  public Completable save(List<EmployeeDomainModel> employeeDomainModels) {
    List<EmployeeDataModel> employeeDataModels = new ArrayList<>();
    for(EmployeeDomainModel emp : employeeDomainModels) {
      employeeDataModels.add(mapper.mapToEntity(emp));
    }
    return saveEmployeeEntites(employeeDataModels);
  }

  @Override
  public Observable<List<EmployeeDomainModel>> getAll() {
    List<EmployeeDomainModel> employeeDomainList = new ArrayList<>();
    EmployeeDataStore dataStore = factory.getEmployeeDataStore();

    return dataStore
        .getAll()
        .flatMap(employeeDataModels -> {
          if(dataStore instanceof EmployeeCacheDataStore) {
            return saveEmployeeEntites(employeeDataModels).toObservable();
          } else {
            return Observable.just(employeeDataModels);
          }
        })
        .map(employeeDataModels -> {
          for(EmployeeDataModel e : employeeDataModels) {
            employeeDomainList.add(mapper.mapFromEntity(e));
          }
          return employeeDomainList;
        });
  }

  private Completable saveEmployeeEntites(List<EmployeeDataModel> empList) {
    return factory.getEmployeeCacheDataStore().save(empList);
  }
}
