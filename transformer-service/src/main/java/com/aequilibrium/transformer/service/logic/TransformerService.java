package com.aequilibrium.transformer.service.logic;

import com.aequilibrium.transformer.api.model.Transformer;
import com.aequilibrium.transformer.common.TransformerError;
import com.aequilibrium.transformer.common.TransformerErrorStatic;
import com.aequilibrium.transformer.persistence.model.TransformerEntity;
import com.aequilibrium.transformer.persistence.service.ITransformerRepository;
import com.aequilibrium.transformer.service.converter.TransformerConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        TransformerEntity transformerEntity = converter.toEntity(transformer);
        TransformerEntity savedEntity =repository.save(transformerEntity);
        return converter.toTransformer(savedEntity);
    }

    public List<Transformer> listTransformers() {
        List<TransformerEntity> entities = (List<TransformerEntity>) repository.findAll();
        return converter.toTransformers(entities);
    }


    public String deleteTransformer(Transformer transformer) throws TransformerError{
        TransformerEntity entity = converter.toEntity(transformer);
        if(repository.existsById(entity.getId())){
            repository.delete(entity);
        }else{
            throw new TransformerError(TransformerErrorStatic.GENERAL_TRANSFORMER_DOES_NOT_EXIST);
        }
        return "deleted";
    }
}
