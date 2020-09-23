package com.aequilibrium.transformer.api.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class UpdateTransformerRequest implements Serializable {

    @Valid
    @NotNull
    private Transformer transformer;

    protected UpdateTransformerRequest() {
    }

    public UpdateTransformerRequest(Transformer transformer) {
        this.transformer = transformer;
    }

    public Transformer getTransformer() {
        return transformer;
    }

    public void setTransformer(Transformer transformer) {
        this.transformer = transformer;
    }

    @Override
    public String toString() {
        return "UpdateTransformerRequest{" +
                "transformer=" + transformer +
                '}';
    }
}
