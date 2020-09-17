package com.aequilibrium.transformer.test.sp;

import com.aequilibrium.transformer.api.impl.api.model.CreateTransformerRequest;
import com.aequilibrium.transformer.api.impl.api.model.CreateTransformerResponse;
import com.aequilibrium.transformer.api.impl.api.service.TransformerAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class TransformerSP implements TransformerAPI {

    @Value("${test.service.url}")
    String transformerUrl;

    @Autowired
    @Qualifier("transformerRestTemplate")
    private RestTemplate transformerRestTemplate;

    @Override
    public CreateTransformerResponse createTransformer(CreateTransformerRequest request) {
        return transformerRestTemplate.postForObject(transformerUrl + "transformer/createTransformer", request, CreateTransformerResponse.class);
    }
}
