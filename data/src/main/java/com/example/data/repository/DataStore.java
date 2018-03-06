package com.example.data.repository;

import io.reactivex.Completable;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by sujin on 1/15/18.
 */

public interface DataStore<T> {
  Completable save(List<T> tList);
  Observable<List<T>> getAll();
}
