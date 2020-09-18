package com.aequilibrium.transformer.common;

import java.util.Arrays;
import java.util.Locale;
import java.util.Map;

public class TransformerErrorStatic {


    private static Map<String, Map<String, String>> errorsMap;
    public TransformerErrorStatic(Map<String, Map<String, String>> errorsMap) {
        this.errorsMap = errorsMap;
    }


    /*----------------------- transformer general Job exception------------------------------------------------*/
    public static final String ERROR_TRANSFORMER_GENERAL_INTERNAL_ERROR = "ETG001";
    public static final String ERROR_TRANSFORMER_PERSISTENCE_TRANSFORMER_DOES_NOT_EXIST = "ETP001";




    private final static String defaultLanguage = Locale.getDefault().getLanguage();

    public static String makeErrorParams(String key, Object[] params) {
        return makeErrorParamsLocalized(defaultLanguage, key, params);
    }

    public static String makeErrorMessage(String code, Object... params) {
        return makeErrorParams(code, params);
    }

    private static final String CODE_MESSAGE_SEPARATOR = ": ";

    public static String makeErrorParamsLocalized(String language, String key, Object[] params) {
        String[] params2 = new String[]{};

        if (params != null && params.length > 0) {
            params2 = new String[params.length];
            for (int i = 0; i < params.length; i++) {
                params2[i] = "" + params[i];
            }
        }

        if (errorsMap.get(language).containsKey(key)) {
            String messageTemplate = errorsMap.get(language).get(key);
            return key + CODE_MESSAGE_SEPARATOR + java.text.MessageFormat.format(messageTemplate.replaceAll("'", "''"), params2);
        } else {
            return key + CODE_MESSAGE_SEPARATOR + Arrays.asList(params2).toString();
        }
    }

    public static String makeErrorMessageLocalized(String language, String code, Object... params) {
        return makeErrorParamsLocalized(language, code, params);
    }

    public static String makeFarsiMessage(String code, Object... params) {
        return makeErrorParamsLocalized("fa", code, params);
    }

    public static String makeEnglishMessage(String code, Object... params) {
        return makeErrorParamsLocalized("en", code, params);
    }

    public static String removeErrorCodeFromErrorMessage(String errorMessage) {
        int index = errorMessage.indexOf(CODE_MESSAGE_SEPARATOR);
        if (index > 0) {
            return errorMessage.substring(index + CODE_MESSAGE_SEPARATOR.length());
        } else {
            return errorMessage;
        }
    }

    public static String extractErrorCodeFromErrorMessage(String errorMessage) {
        int index = errorMessage.indexOf(CODE_MESSAGE_SEPARATOR);
        if (index > 0) {
            return errorMessage.substring(0, index);
        } else {
            return null;
        }
    }
}

