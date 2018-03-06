package com.example.presentation.browser;

import com.example.presentation.BasePresenter;
import com.example.presentation.BaseView;
import com.example.presentation.model.EmployeePrsntModel;
import java.util.List;

/**
 * Created by sujin on 1/15/18.
 */

public interface BrowseEmployeeContract {

  interface View extends BaseView<Presenter> {
    void showProgress();
    void hideProgress();
    void showCompany(List<EmployeePrsntModel> companyList);
    void hideCompany();
  }

  interface Presenter extends BasePresenter {
    void retrieveEmployee();
  }
}
