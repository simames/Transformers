package com.aequilibrium.transformer.api.model;

import java.io.Serializable;

public class CreateTransformerResponse  implements Serializable {
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
