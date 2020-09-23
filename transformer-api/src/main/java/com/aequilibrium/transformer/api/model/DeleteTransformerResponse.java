package com.aequilibrium.transformer.api.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class DeleteTransformerResponse  implements Serializable {
    @ApiModelProperty(notes = "The result of deletation",name="result")
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

    @Override
    public String toString() {
        return "DeleteTransformerResponse{" +
                "result='" + result + '\'' +
                '}';
    }
}
