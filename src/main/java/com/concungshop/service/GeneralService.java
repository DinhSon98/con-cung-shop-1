package com.concungshop.service;

import java.util.Optional;

public interface GeneralService<T> {
    java.lang.Object findAll();

    Optional<T> findById(Long id);

    void save(T t);

    void remove(Long id);
}