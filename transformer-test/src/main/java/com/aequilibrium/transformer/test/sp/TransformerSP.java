package com.aequilibrium.transformer.test.sp;

import com.aequilibrium.transformer.api.model.*;
import com.aequilibrium.transformer.api.service.TransformerAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.aequilibrium.transformer.common.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

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

    @Override
    public UpdateTransformerResponse updateTransformer(UpdateTransformerRequest request) {
        return transformerRestTemplate.postForObject(transformerUrl + "transformer/updateTransformer", request, UpdateTransformerResponse.class);
    }

    @Override
    public ListTransformerResponse listTransformers() {
        return transformerRestTemplate.postForObject(transformerUrl + "transformer/listTransformer", null, ListTransformerResponse.class);
    }

    @Override
    public DeleteTransformerResponse deleteTransformer(DeleteTransformerRequest request) throws TransformerError {
        return transformerRestTemplate.postForObject(transformerUrl + "transformer/deleteTransformer", request, DeleteTransformerResponse.class);
    }

    @Override
    public BattleResponse transformersBattle(BattleRequest request) throws TransformerError {
        return transformerRestTemplate.postForObject(transformerUrl + "transformer/transformersBattle", request, BattleResponse.class);
    }




}
