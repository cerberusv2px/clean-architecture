package com.example.remote.service;

import com.example.data.repository.employee.EmployeeRemote;
import com.example.remote.model.CompanyRemoteModel;
import com.example.remote.model.EmployeeRemoteModel;
import io.reactivex.Observable;
import java.util.List;
import retrofit2.http.GET;

/**
 * Created by sujin on 1/15/18.
 */

public interface APIService {

  @GET("employee")
  Observable<List<EmployeeRemoteModel>> getAllEmployee();

  @GET("company")
  Observable<List<CompanyRemoteModel>> getAllCompany();
}
