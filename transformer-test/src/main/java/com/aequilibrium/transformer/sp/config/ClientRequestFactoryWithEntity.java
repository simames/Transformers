package com.aequilibrium.transformer.sp.config;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

import java.net.URI;

public class ClientRequestFactoryWithEntity extends HttpComponentsClientHttpRequestFactory {
    @Override
    protected HttpUriRequest createHttpUriRequest(HttpMethod httpMethod, URI uri) {
        if (httpMethod == HttpMethod.GET) {
            return new ClientRequestFactoryWithEntity.HttpGetRequestWithEntity(uri);
        }
        return super.createHttpUriRequest(httpMethod, uri);
    }

    private static final class HttpGetRequestWithEntity extends HttpEntityEnclosingRequestBase {
        public HttpGetRequestWithEntity(final URI uri) {
            super.setURI(uri);
        }

        @Override
        public String getMethod() {
            return HttpMethod.GET.name();
        }
    }

}