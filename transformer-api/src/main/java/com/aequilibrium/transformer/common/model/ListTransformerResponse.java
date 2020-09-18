package com.aequilibrium.transformer.common.model;

import java.util.List;

public class ListTransformerResponse {
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
}
