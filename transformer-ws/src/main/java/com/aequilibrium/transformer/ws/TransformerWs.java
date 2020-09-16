package com.aequilibrium.transformer.ws;

import com.aequilibrium.transformer.api.model.CreateTransformerRequest;
import com.aequilibrium.transformer.api.model.CreateTransformerResponse;
import com.aequilibrium.transformer.api.service.TransformerAPI;
import com.aequilibrium.transformer.business.logic.TransformerLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/transformer")
public class TransformerWs implements TransformerAPI {

    @Autowired
    private TransformerLogic logic;


    @Override
    public CreateTransformerResponse createTransformer(CreateTransformerRequest request) {
        return new CreateTransformerResponse(logic.createTransformer(request.getTransformer()));
    }
}
