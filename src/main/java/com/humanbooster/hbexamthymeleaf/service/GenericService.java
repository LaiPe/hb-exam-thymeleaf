package com.humanbooster.hbexamthymeleaf.service;

import com.humanbooster.hbexamthymeleaf.model.GenericModel;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public abstract class GenericService<T extends GenericModel<ID>,ID> {
    private List<T> entities;

    public List<T> getEntities() {
        return entities;
    }

    public Optional<T> getEntityById(ID id) {
        for (T entity : entities) {
            if (entity.getId().equals(id)) {
                return Optional.of(entity);
            }
        }
        return Optional.empty();
    }

    public T addEntity(T entity) {
        entities.add(entity);
        return entity;
    }

    public void deleteEntity(T entity) {
        entities.remove(entity);
    }

    public void updateEntity(T modifiedEntity, ID id) {
        for (T entity2 : entities) {
            if (entity2.getId().equals(id)) {
                modifiedEntity.setId(id);
                entities.add(modifiedEntity);
                entities.remove(entity2);
            }
        }
    }
}