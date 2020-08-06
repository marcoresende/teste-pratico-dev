package com.github.marcoresende.testepraticodev.core.rest;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class Message implements Serializable {

    private static final long serialVersionUID = -8433072263949331111L;

    public enum Severity {
        ERROR, WARN, INFO
    }

    public Message() {
    }

    public Message(Severity severity,String description) {
        this.severity = severity;
        this.description = description;
    }

    private Severity severity;
    private String description;

    @JsonProperty
    public Severity getSeverity() {
        return this.severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    @JsonProperty
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
