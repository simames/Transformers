package com.aequilibrium.transformer.api.model;

import java.io.Serializable;

public class DeleteTransformerRequest  implements Serializable {
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
