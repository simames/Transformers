package com.aequilibrium.transformer.api.impl;

import com.aequilibrium.transformer.api.model.*;
import com.aequilibrium.transformer.api.service.TransformerAPI;
import com.aequilibrium.transformer.common.TransformerError;
import com.aequilibrium.transformer.service.logic.TransformerService;
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

    @Override
    public UpdateTransformerResponse updateTransformer(UpdateTransformerRequest request) {
        return new UpdateTransformerResponse(service.createTransformer(request.getTransformer()));
    }

    @Override
    public ListTransformerResponse listTransformers() {
        return new ListTransformerResponse(service.listTransformers());
    }

    @Override
    public DeleteTransformerResponse deleteTransformer(DeleteTransformerRequest request)  throws TransformerError {
        return new DeleteTransformerResponse(service.deleteTransformer(request.getTransformer()));
    }
}
