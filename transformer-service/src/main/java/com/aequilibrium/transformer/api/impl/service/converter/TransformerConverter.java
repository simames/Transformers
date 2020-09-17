package com.aequilibrium.transformer.api.impl.service.converter;

import com.aequilibrium.transformer.persistence.model.TransformerEntity;
import com.aequilibrium.transformer.api.impl.api.model.Transformer;
import io.swagger.annotations.ApiResponse;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransformerConverter {


    @Autowired
    private DozerBeanMapper mapper;

    public TransformerEntity convertTransformerToEntity(Transformer transformer) {
        return mapper.map(transformer,TransformerEntity.class);
    }

    public Transformer toTransformer(TransformerEntity savedEntity) {
        return mapper.map(savedEntity,Transformer.class);
    }
}
