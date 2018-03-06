package com.example.data.repository;

import io.reactivex.Completable;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by sujin on 1/15/18.
 */

public interface Cache<T> {
  Completable save(List<T> t);
  Observable<List<T>> getAll();
  boolean isCached();
  void setLastCacheTime(long time);
  boolean isExpired();
}
