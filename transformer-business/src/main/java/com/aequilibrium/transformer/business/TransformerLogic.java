package com.aequilibrium.transformer.business;
import com.aequilibrium.transformer.api.model.CreateTransformerResponse;
import com.aequilibrium.transformer.api.model.Transformer;
import org.springframework.stereotype.Service;

@Service
public class TransformerLogic {
    public CreateTransformerResponse createTransformer(Transformer iTransformer) {
        return  new CreateTransformerResponse(iTransformer);
    }
}
