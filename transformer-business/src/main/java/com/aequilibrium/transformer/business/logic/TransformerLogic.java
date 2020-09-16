package com.aequilibrium.transformer.business.logic;

import com.aequilibrium.transformer.api.model.Transformer;
import com.aequilibrium.transformer.business.converter.TransformerConverter;
import com.aequilibrium.transformer.persistence.model.TransformerEntity;
import com.aequilibrium.transformer.persistence.service.ITransformerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransformerLogic {

    @Autowired
    private TransformerConverter converter;

    @Autowired
    private ITransformerRepository repository;


    public Transformer createTransformer(Transformer transformer) {
        TransformerEntity transformerEntity = converter.convertTransformerToEntity(transformer);
        repository.save(transformerEntity);
        return transformer;
    }
}
