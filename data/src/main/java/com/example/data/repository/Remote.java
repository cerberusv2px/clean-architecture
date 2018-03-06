package com.example.data.repository;

import io.reactivex.Observable;
import java.util.List;

/**
 * Created by sujin on 1/15/18.
 */

public interface Remote<T> {
  Observable<List<T>> getAll();
}
