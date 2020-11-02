package com.engine.fakau.springjwtsecurity.sercice.mapper;

public interface IMapper<U,V> {
    U toEntity (V v);
    V toDTO (U u);
}
