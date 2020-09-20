package com.aequilibrium.transformer.api.model;

public enum  TransformerEnumType {
    AUTOBOT("AUO","Autobot"),
    DESEPTICAN("DES","Descepticon");

    private String code;
    private String description;

    TransformerEnumType(String code,String description) {
        this.description = description;
        this.code = code;
    }

    public static TransformerEnumType getByCode(String type) {
        for (TransformerEnumType enumType:
             values()) {
            if (enumType.getCode().equals(type)){
                return enumType;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
