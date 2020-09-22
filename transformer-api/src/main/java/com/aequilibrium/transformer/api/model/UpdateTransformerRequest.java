package com.aequilibrium.transformer.api.model;

import java.io.Serializable;

public class UpdateTransformerRequest implements Serializable {
    private Transformer transformer;

    protected UpdateTransformerRequest() {
    }

    public UpdateTransformerRequest(Transformer transformer) {
        this.transformer = transformer;
    }

    public Transformer getTransformer() {
        return transformer;
    }

    public void setTransformer(Transformer transformer) {
        this.transformer = transformer;
    }
}
