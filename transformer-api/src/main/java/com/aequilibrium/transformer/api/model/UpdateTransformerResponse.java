package com.aequilibrium.transformer.api.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class UpdateTransformerResponse  implements Serializable {
    @ApiModelProperty(notes = "The updated transformer",name="transformer")
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

    @Override
    public String toString() {
        return "UpdateTransformerResponse{" +
                "transformer=" + transformer +
                '}';
    }
}
