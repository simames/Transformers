package com.aequilibrium.transformer.service.model;

import javax.persistence.Column;

public class TransformerType {
    private Long id;
    private String code;
    private String description;

    protected TransformerType() {
    }

    public TransformerType(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
