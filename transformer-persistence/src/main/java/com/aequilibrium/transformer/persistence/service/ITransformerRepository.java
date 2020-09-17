package com.aequilibrium.transformer.persistence.service;

import com.aequilibrium.transformer.persistence.model.TransformerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransformerRepository extends CrudRepository<TransformerEntity, Long> {

}
