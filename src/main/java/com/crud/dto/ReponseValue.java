package com.crud.dto;

import java.io.Serializable;

public class ReponseValue<T extends Serializable> implements Serializable {

    private static final long serialVersionUID = 1L;

    public T value;

    public ReponseValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

}
