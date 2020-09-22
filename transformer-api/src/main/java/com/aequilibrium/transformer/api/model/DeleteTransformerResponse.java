package com.aequilibrium.transformer.api.model;

import java.io.Serializable;

public class DeleteTransformerResponse  implements Serializable {
    private String result;

    protected DeleteTransformerResponse() {
    }

    public DeleteTransformerResponse(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
