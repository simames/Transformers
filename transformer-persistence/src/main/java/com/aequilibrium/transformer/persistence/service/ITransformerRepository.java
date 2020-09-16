package com.aequilibrium.transformer.persistence.service;

import com.aequilibrium.transformer.persistence.model.TransformerEntity;
import org.springframework.data.repository.CrudRepository;

public interface ITransformerRepository extends CrudRepository<TransformerEntity, Long> {

        TransformerEntity save(TransformerEntity transformerEntity);
}
