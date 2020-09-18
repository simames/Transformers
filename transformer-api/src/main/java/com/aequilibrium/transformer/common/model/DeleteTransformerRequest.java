package com.aequilibrium.transformer.common.model;

public class DeleteTransformerRequest {
    private Transformer transformer;

    protected DeleteTransformerRequest() {
    }

    public DeleteTransformerRequest(Transformer transformer) {
        this.transformer = transformer;
    }

    public Transformer getTransformer() {
        return transformer;
    }

    public void setTransformer(Transformer transformer) {
        this.transformer = transformer;
    }
}
