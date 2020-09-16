package com.aequilibrium.transformer.api.model;

public class CreateTransformerRequest {
    private ITransformer iTransformer;


    public CreateTransformerRequest(ITransformer iTransformer) {
        this.iTransformer = iTransformer;
    }

    public CreateTransformerRequest() {
    }
}
