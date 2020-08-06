package com.github.marcoresende.testepraticodev.core.rest;

import java.util.List;

public interface ValueListResponse<V> extends Response {

    public abstract void setValues(List<V> values);

    public abstract List<V> getValues();
}
