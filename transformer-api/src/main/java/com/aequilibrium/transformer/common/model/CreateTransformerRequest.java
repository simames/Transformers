package com.aequilibrium.transformer.common.model;

public class CreateTransformerRequest {
    private Transformer transformer;


    public CreateTransformerRequest(Transformer iTransformer) {
        this.transformer = iTransformer;
    }

    public CreateTransformerRequest() {
    }

    public Transformer getTransformer() {
        return transformer;
    }
}
