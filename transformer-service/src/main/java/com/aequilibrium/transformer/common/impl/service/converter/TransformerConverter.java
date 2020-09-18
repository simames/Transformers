package com.aequilibrium.transformer.common.impl.service.converter;

import com.aequilibrium.transformer.persistence.model.TransformerEntity;
import com.aequilibrium.transformer.common.model.Transformer;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TransformerConverter {


    @Autowired
    private DozerBeanMapper mapper;

    public TransformerEntity toEntity(Transformer transformer) {
        return mapper.map(transformer,TransformerEntity.class);
    }

    public Transformer toTransformer(TransformerEntity entity) {
        return mapper.map(entity,Transformer.class);
    }

    public List<Transformer> toTransformers(List<TransformerEntity> entities) {
        return entities
                .stream()
                .map(this::toTransformer)
                .collect(Collectors.toList());
    }
}
