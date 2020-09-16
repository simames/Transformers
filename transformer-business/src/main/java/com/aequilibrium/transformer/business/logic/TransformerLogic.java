package com.aequilibrium.transformer.business.logic;

import com.aequilibrium.transformer.api.model.Transformer;
import com.aequilibrium.transformer.business.converter.TransformerConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransformerLogic {

    @Autowired
    private TransformerConverter converter;


    public Transformer createTransformer(Transformer transformer) {
//        TransformerEntity transformerEntity = converter.convertTransformerToEntity(transformer);
        return transformer;
    }
}
