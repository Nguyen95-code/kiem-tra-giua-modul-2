package com.codegym.cms.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GenaralService<E> {
    Page<E> findAll(Pageable pageable);
    void delete(long id);
    E findById(long id);
    Iterable<E> findAll();
}

