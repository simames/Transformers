package com.aequilibrium.transformer.api.model;

import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


public class CreateTransformerRequest implements Serializable {

    @Valid
    @NotNull
    private Transformer transformer;


    public CreateTransformerRequest(Transformer iTransformer) {
        this.transformer = iTransformer;
    }

    public CreateTransformerRequest() {
    }

    public Transformer getTransformer() {
        return transformer;
    }

    public void setTransformer(Transformer transformer) {
        this.transformer = transformer;
    }

    @Override
    public String toString() {
        return "CreateTransformerRequest{" +
                "transformer=" + transformer +
                '}';
    }
}
