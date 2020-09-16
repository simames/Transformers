package com.aequilibrium.transformer.business;
import com.aequilibrium.transformer.api.model.CreateTransformerResponse;
import org.springframework.stereotype.Component;

@Component
public class TransformerLogic {
    public CreateTransformerResponse createTransformer() {
        return  new CreateTransformerResponse();
    }
}
