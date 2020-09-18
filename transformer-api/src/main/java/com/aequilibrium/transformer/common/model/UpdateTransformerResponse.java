package com.aequilibrium.transformer.common.model;

public class UpdateTransformerResponse {
    private Transformer transformer;

    public UpdateTransformerResponse() {
    }

    public UpdateTransformerResponse(Transformer transformer) {
        this.transformer = transformer;
    }

    public Transformer getTransformer() {
        return transformer;
    }

    public void setTransformer(Transformer transformer) {
        this.transformer = transformer;
    }
}
