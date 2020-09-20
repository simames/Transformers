package com.aequilibrium.transformer.persistence.service;

import com.aequilibrium.transformer.persistence.model.TransformerTypeEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ITransformerTypeRepository extends CrudRepository<TransformerTypeEntity, Long> {

    Optional<TransformerTypeEntity> findByCode(String name);
}
