package com.aequilibrium.transformer.api.model;

import java.io.Serializable;

public class UpdateTransformerResponse  implements Serializable {
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
