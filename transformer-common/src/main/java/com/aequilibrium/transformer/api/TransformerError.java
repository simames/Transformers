package com.aequilibrium.transformer.api;

import java.io.Serializable;

public class TransformerError extends RuntimeException implements Serializable {

    private TransformerFault faultInfo;

    public TransformerError(String message, TransformerFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    public TransformerError(String message, TransformerFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    public TransformerError(TransformerError error) {
        super(error.getMessage(), error);
        this.faultInfo = error.faultInfo;

    }

    public TransformerError(String code, Object... params) {
        super(TransformerErrorStatic.makeErrorParams(code, params));
        this.faultInfo = new TransformerFault(code, params, this.getMessage());
    }

    public String getCode() {
        return faultInfo.getCode();
    }

    public String getName() {
        return faultInfo.getName();
    }

    public Object[] getParams() {
        return faultInfo.getParams();
    }


    public TransformerFault getFaultInfo() {
        return faultInfo;
    }

    public void setFaultInfo(TransformerFault faultInfo) {
        this.faultInfo = faultInfo;
    }


    public void setCode(String code){
        this.faultInfo.setCode(code);
    }

    public void setParams(Object[] params){
        this.faultInfo.setParams(params);
    }

}

