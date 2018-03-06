package com.example.presentation.mapper;

/**
 * Created by sujin on 1/15/18.
 */

public interface Mapper<E,D> {
  E mapToPresentation(D type);
}
