package com.aequilibrium.transformer.api.model;

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
