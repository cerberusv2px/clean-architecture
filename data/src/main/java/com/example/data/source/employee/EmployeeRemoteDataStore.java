package com.example.data.source.employee;

import com.example.data.model.EmployeeDataModel;
import com.example.data.repository.employee.EmployeeDataStore;
import com.example.data.repository.employee.EmployeeRemote;
import io.reactivex.Completable;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by sujin on 1/15/18.
 */

public class EmployeeRemoteDataStore implements EmployeeDataStore {

  EmployeeRemote employeeRemote;

  @Inject
  public EmployeeRemoteDataStore(EmployeeRemote employeeRemote) {
    this.employeeRemote = employeeRemote;
  }

  @Override
  public Completable save(List<EmployeeDataModel> employeeDataModels) {
    throw new UnsupportedOperationException();
  }

  @Override
  public Observable<List<EmployeeDataModel>> getAll() {
    return employeeRemote.getAll();
  }
}
