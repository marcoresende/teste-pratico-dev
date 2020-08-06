package com.github.marcoresende.testepraticodev.core.rest;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

public abstract class AbstractValueListResponse<V> extends AbstractResponse implements ValueListResponse<V> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonUnwrapped
    @JsonProperty
    private List<V> values;

    @Override
    public List<V> getValues() {
        return this.values;
    }

    @Override
    public void setValues(List<V> values) {
        this.values = values;
    }

}
