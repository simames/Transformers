package com.aequilibrium.transformer.api;

import java.io.Serializable;
import java.lang.reflect.Field;

public class TransformerFault implements Serializable {
    String code;
    String name;
    Object[] params;
    String message;

    public TransformerFault() {
    }

    public TransformerFault(String code, Object[] params, String message) {
        this.params = params;
        this.message = message;

        setCode(code);

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
        for (Field f : TransformerErrorStatic.class.getFields()) {
            try {
                String codeConstant = null;
                if (f.get(null).equals(code))
                    codeConstant = f.getName();
                if (codeConstant != null) {
                    this.name = codeConstant;
                    return;
                }
            } catch (IllegalAccessException e) {
            }
        }
    }

    public String getName() {
        return name;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
