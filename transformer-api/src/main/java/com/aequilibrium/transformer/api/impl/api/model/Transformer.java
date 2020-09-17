package com.aequilibrium.transformer.api.impl.api.model;

public class Transformer {

    private Long Id;

    public Transformer() {
    }

    public Transformer(Long id) {
        Id = id;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
}
