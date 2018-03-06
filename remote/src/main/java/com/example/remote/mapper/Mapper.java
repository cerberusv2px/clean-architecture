package com.example.remote.mapper;

/**
 * Created by sujin on 1/15/18.
 */

public interface Mapper<E,D> {

  D mapFromRemote(E type);
}
