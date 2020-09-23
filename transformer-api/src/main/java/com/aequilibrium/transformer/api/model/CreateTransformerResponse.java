package com.aequilibrium.transformer.api.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class CreateTransformerResponse  implements Serializable {
    @ApiModelProperty(notes = "The transformer who has been created",name="transformer")
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

    @Override
    public String toString() {
        return "CreateTransformerResponse{" +
                "transformer=" + transformer +
                '}';
    }
}
