package com.aequilibrium.transformer.api.impl.service.logic;

import com.aequilibrium.transformer.persistence.model.TransformerEntity;
import com.aequilibrium.transformer.persistence.service.ITransformerRepository;
import com.aequilibrium.transformer.api.impl.api.model.Transformer;
import com.aequilibrium.transformer.api.impl.service.converter.TransformerConverter;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransformerService {

    @Autowired
    private TransformerConverter converter;

    private final ITransformerRepository repository;

    @Autowired
    public TransformerService(ITransformerRepository iTransformerRepository){
        this.repository = iTransformerRepository;
    }


    public Transformer createTransformer(Transformer transformer) {
        TransformerEntity transformerEntity = converter.convertTransformerToEntity(transformer);
        TransformerEntity savedEntity = repository.findById(transformerEntity.getId()).
                orElse(repository.save(transformerEntity));
        return converter.toTransformer(savedEntity);
    }
}
