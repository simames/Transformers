package com.aequilibrium.transformer.api.impl.api.model;

public class CreateTransformerResponse  {
    private Transformer transformer;

    public CreateTransformerResponse() {
    }

    public CreateTransformerResponse(Transformer iTransformer) {
        this.transformer = iTransformer;
    }

    public Transformer getTransformer() {
        return transformer;
    }

    public void setTransformer(Transformer transformer) {
        this.transformer = transformer;
    }
}
