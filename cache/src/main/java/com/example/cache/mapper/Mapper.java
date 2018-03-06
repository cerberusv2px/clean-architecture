package com.example.cache.mapper;

/**
 * Created by sujin on 1/15/18.
 */

public interface Mapper<E,D> {
   D mapFromCache(E type);
   E mapToCache(D type);
}
