package org.shumskih.spring.service;

import java.util.List;
import java.util.UUID;

public interface GenericService<T, ID> {
    void add(T t);

    void update(T t);

    void remove(UUID id);

    T getById(UUID id);

    List<T> getAll();
}
