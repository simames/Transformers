package com.aequilibrium.transformer.api.model;

import javax.validation.Valid;
import java.io.Serializable;

public class CreateTransformerRequest implements Serializable {
    private Transformer transformer;


    public CreateTransformerRequest(@Valid Transformer iTransformer) {
        this.transformer = iTransformer;
    }

    public CreateTransformerRequest() {
    }

    public Transformer getTransformer() {
        return transformer;
    }
}
