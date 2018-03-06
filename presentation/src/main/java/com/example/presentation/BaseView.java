package com.example.presentation;

/**
 * Created by sujin on 1/15/18.
 */

public interface BaseView<T extends BasePresenter> {

  void setPresenter(T presenter);
}
