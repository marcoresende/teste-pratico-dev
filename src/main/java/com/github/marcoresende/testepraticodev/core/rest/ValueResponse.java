package com.github.marcoresende.testepraticodev.core.rest;

public interface ValueResponse<V> extends Response {

    public abstract void setValue(V value);

    public abstract V getValue();

}
