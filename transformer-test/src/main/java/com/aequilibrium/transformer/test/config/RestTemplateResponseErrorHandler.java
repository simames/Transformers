package com.aequilibrium.transformer.test.config;

import com.aequilibrium.transformer.api.impl.api.TransformerError;
import com.aequilibrium.transformer.api.impl.api.TransformerFault;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;
import java.nio.charset.Charset;

import static org.springframework.http.HttpStatus.Series.CLIENT_ERROR;
import static org.springframework.http.HttpStatus.Series.SERVER_ERROR;

public class RestTemplateResponseErrorHandler
        implements ResponseErrorHandler {


    private static ObjectMapper mapper = new ObjectMapper();

    protected Charset getCharset(ClientHttpResponse response) {
        HttpHeaders headers = response.getHeaders();
        MediaType contentType = headers.getContentType();
        return null; // (contentType != null ? contentType.getCharset() : null);
    }

    protected byte[] getResponseBody(ClientHttpResponse response) {
        try {
            return FileCopyUtils.copyToByteArray(response.getBody());
        } catch (IOException ex) {
            // ignore
        }
        return new byte[0];
    }


    @Override
    public boolean hasError(ClientHttpResponse httpResponse)
            throws IOException {

        return (
                httpResponse.getStatusCode().series() == CLIENT_ERROR
                        || httpResponse.getStatusCode().series() == SERVER_ERROR);
    }

    @Override
    public void handleError(ClientHttpResponse httpResponse)
            throws IOException {

        Charset charset = getCharset(httpResponse);

        if (charset == null) {
            charset = Charset.defaultCharset();
        }

        String s = new String(getResponseBody(httpResponse), charset);
        if (s.length() == 0) return;
        TransformerFault bf = mapper.readValue(s, TransformerFault.class);
        throw new TransformerError(bf.getCode(),bf.getParams());
    }

}