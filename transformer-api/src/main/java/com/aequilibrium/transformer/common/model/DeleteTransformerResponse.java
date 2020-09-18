package com.aequilibrium.transformer.common.model;

public class DeleteTransformerResponse {
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
