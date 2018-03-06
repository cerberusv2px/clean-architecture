package com.example.data.mapper;

/**
 * Created by sujin on 1/15/18.
 */

public interface Mapper<E,D> {

  public D mapFromEntity(E type);
  public E mapToEntity(D type);
}
