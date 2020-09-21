package com.aequilibrium.transformer.service.converter;

import com.aequilibrium.transformer.api.model.Transformer;
import com.aequilibrium.transformer.api.model.TransformerEnumType;
import com.aequilibrium.transformer.persistence.model.TransformerEntity;
import com.aequilibrium.transformer.persistence.model.TransformerTypeEntity;
import com.aequilibrium.transformer.persistence.service.ITransformerTypeRepository;
import com.aequilibrium.transformer.service.model.TransformerType;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TransformerConverter {


    @Autowired
    @Qualifier("serviceMapper")
    private DozerBeanMapper mapper;

    private final ITransformerTypeRepository iTransformerTypeRepository;

    public TransformerConverter(ITransformerTypeRepository iTransformerTypeRepository) {
        this.iTransformerTypeRepository = iTransformerTypeRepository;
    }

    public TransformerEntity toEntity(Transformer transformer) {
        TransformerEntity transformerEntity = mapper.map(transformer, TransformerEntity.class);
        transformerEntity.setTransformerTypeEntity(iTransformerTypeRepository.findByCode(transformer.getType()).get());
        return transformerEntity;
    }

    public Transformer toTransformer(TransformerEntity entity) {
        Transformer transformer = mapper.map(entity,Transformer.class);
        transformer.setType(entity.getTransformerTypeEntity().getCode());
        return transformer;
    }

    public List<TransformerEntity> toEntities(List<Transformer> transformers) {
        return transformers
                .stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    public List<Transformer> toTransformers(List<TransformerEntity> entities) {
        return entities
                .stream()
                .map(this::toTransformer)
                .collect(Collectors.toList());
    }

    public TransformerTypeEntity toTransformerTypeEntity(TransformerType transformerType) {
        return mapper.map(transformerType,TransformerTypeEntity.class);
    }

    public TransformerType toTransformerType(TransformerTypeEntity entity) {
        return mapper.map(entity,TransformerType.class);
    }


}
