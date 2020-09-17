package com.aequilibrium.transformer.api.impl;

import com.aequilibrium.transformer.api.impl.api.model.CreateTransformerRequest;
import com.aequilibrium.transformer.api.impl.api.model.CreateTransformerResponse;
import com.aequilibrium.transformer.api.impl.api.service.TransformerAPI;
import com.aequilibrium.transformer.api.impl.service.logic.TransformerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/transformer")
public class TransformerWs implements TransformerAPI {

    private final TransformerService service;

    public TransformerWs(TransformerService service) {
        this.service = service;
    }


    @Override
    public CreateTransformerResponse createTransformer(CreateTransformerRequest request) {
        return new CreateTransformerResponse(service.createTransformer(request.getTransformer()));
    }
}
