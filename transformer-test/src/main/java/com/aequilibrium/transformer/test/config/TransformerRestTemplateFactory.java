package com.aequilibrium.transformer.test.config;


import com.aequilibrium.transformer.common.TransformerErrorStatic;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;


@Configuration
@Component
public class TransformerRestTemplateFactory {

    @Bean(name = "transformerRestTemplate")
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new RestTemplateResponseErrorHandler());

        List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
        if (CollectionUtils.isEmpty(interceptors)) {
            interceptors = new ArrayList<>();
        }

        restTemplate.setInterceptors(interceptors);

        restTemplate.setRequestFactory(new ClientRequestFactoryWithEntity());
        MappingJackson2HttpMessageConverter jsonHttpMessageConverter = new MappingJackson2HttpMessageConverter();
        jsonHttpMessageConverter.getObjectMapper().configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        restTemplate.getMessageConverters().add(jsonHttpMessageConverter);
        return restTemplate;
    }
    @Bean
    public TransformerErrorStatic transformerErrorStatic() throws IOException {
        Properties enProp = new Properties();
        Map<String, Map<String, String>> transformerMap = new HashMap<>();
        enProp.load(this.getClass().getClassLoader().getResourceAsStream("transformerError_en.properties"));
        transformerMap.put("en",(Map)enProp);
        return new TransformerErrorStatic(transformerMap);
    }

}
