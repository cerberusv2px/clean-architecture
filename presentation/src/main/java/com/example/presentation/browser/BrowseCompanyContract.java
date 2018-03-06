package com.example.presentation.browser;

import com.example.presentation.BasePresenter;
import com.example.presentation.BaseView;
import com.example.presentation.model.CompanyPrsntModel;
import java.util.List;

/**
 * Created by sujin on 1/15/18.
 */

public interface BrowseCompanyContract {

  interface View extends BaseView<Presenter> {
    void showProgress();
    void hideProgress();
    void showCompany(List<CompanyPrsntModel> companyList);
    void hideCompany();
  }

  interface Presenter extends BasePresenter {
    void retrieveCompany();
  }
}
