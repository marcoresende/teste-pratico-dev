package com.github.marcoresende.testepraticodev.core.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

public abstract class AbstractValueResponse<V> extends AbstractResponse implements ValueResponse<V> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private V value;

    @JsonUnwrapped
    @JsonProperty
    @Override
    public V getValue() {
        return this.value;
    }

    @Override
    public void setValue(V value) {
        this.value = value;
    }

}
