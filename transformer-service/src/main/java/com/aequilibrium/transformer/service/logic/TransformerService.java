package com.aequilibrium.transformer.service.logic;

import com.aequilibrium.transformer.api.model.Transformer;
import com.aequilibrium.transformer.common.TransformerError;
import com.aequilibrium.transformer.common.TransformerErrorStatic;
import com.aequilibrium.transformer.persistence.model.TransformerEntity;
import com.aequilibrium.transformer.persistence.model.TransformerTypeEntity;
import com.aequilibrium.transformer.persistence.service.ITransformerRepository;
import com.aequilibrium.transformer.persistence.service.ITransformerTypeRepository;
import com.aequilibrium.transformer.service.converter.TransformerConverter;
import com.aequilibrium.transformer.service.model.BattleResult;
import com.aequilibrium.transformer.service.model.TransformerType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * The TransformerService holds the logic of the transformers game
 *
 * @author  SimaMes
 * @version 1.0
 */
@Service
public class TransformerService {

    @Autowired
    private TransformerConverter converter;


    private final ITransformerRepository iTransformerRepository;

    private final ITransformerTypeRepository iTransformerTypeRepository;


    @Autowired
    public TransformerService(ITransformerRepository iTransformerRepository, ITransformerTypeRepository iTransformerTypeRepository) {
        this.iTransformerRepository = iTransformerRepository;
        this.iTransformerTypeRepository = iTransformerTypeRepository;
    }


    public Transformer createTransformer(Transformer transformer) {
        TransformerEntity transformerEntity = converter.toEntity(transformer);

        TransformerEntity savedEntity = iTransformerRepository.save(transformerEntity);
        return converter.toTransformer(savedEntity);
    }

    public List<Transformer> listTransformers() {
        List<TransformerEntity> entities = (List<TransformerEntity>) iTransformerRepository.findAll();
        return converter.toTransformers(entities);
    }


    public String deleteTransformer(Transformer transformer) throws TransformerError {
        TransformerEntity entity = converter.toEntity(transformer);
        if (iTransformerRepository.existsById(entity.getId())) {
            iTransformerRepository.delete(entity);
        } else {
            throw new TransformerError(TransformerErrorStatic.ERROR_TRANSFORMER_PERSISTENCE_TRANSFORMER_DOES_NOT_EXIST);
        }
        return "deleted";
    }

    public BattleResult transformersBattle(List<Long> transformerIds) throws TransformerError{
        BattleResult result;
        List<TransformerEntity> transformers = (List<TransformerEntity>) iTransformerRepository.findAllById(transformerIds);
        if(transformers.size()<2){
            throw new TransformerError(TransformerErrorStatic.ERROR_TRANSFORMER_BATTLE_TRANSFORMERS_DO_NOT_EXIST);
        }else{
            TransformerBattle transformerBattle = new TransformerBattle(converter.toTransformers(transformers), iTransformerRepository,converter);
            result = transformerBattle.battle();
        }
        return result;
    }


    public TransformerType createTransformerType(TransformerType transformerType) {
        TransformerTypeEntity entity = iTransformerTypeRepository.save(converter.toTransformerTypeEntity(transformerType));
        return converter.toTransformerType(entity);
    }
}
