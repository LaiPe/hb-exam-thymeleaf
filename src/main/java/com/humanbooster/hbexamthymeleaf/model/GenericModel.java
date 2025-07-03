package com.humanbooster.hbexamthymeleaf.model;

public abstract class GenericModel<ID> {
    public abstract ID getId();
    public abstract void setId(ID id);
}
