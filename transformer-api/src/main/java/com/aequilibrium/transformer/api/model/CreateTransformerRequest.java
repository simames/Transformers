package com.aequilibrium.transformer.api.model;

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
