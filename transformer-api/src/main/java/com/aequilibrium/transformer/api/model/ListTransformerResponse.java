package com.aequilibrium.transformer.api.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class ListTransformerResponse  implements Serializable {
    @ApiModelProperty(notes = "The transformers which are created",name="transformers")
    private List<Transformer> transformers;

    protected ListTransformerResponse() {
    }

    public ListTransformerResponse(List<Transformer> transformers) {
        this.transformers = transformers;
    }

    public List<Transformer> getTransformers() {
        return transformers;
    }

    public void setTransformers(List<Transformer> transformers) {
        this.transformers = transformers;
    }

    @Override
    public String toString() {
        return "ListTransformerResponse{" +
                "transformers=" + transformers +
                '}';
    }
}
