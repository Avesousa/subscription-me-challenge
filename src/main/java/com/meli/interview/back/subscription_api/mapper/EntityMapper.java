package com.meli.interview.back.subscription_api.mapper;

import java.util.List;

/**
 *  @param <D> - DTO type parameter.
 *  @param <E> - Entity type parameter.
**/
public interface EntityMapper <D, E> {

    E toEntity(D dto);
    D toDTO(E entity);
    List<E> toEntity(List<D> dtoList);
    List <D> toDTO(List<E> entityList);
}