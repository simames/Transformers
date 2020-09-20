package com.aequilibrium.transformer.api.impl.converter;

import com.aequilibrium.transformer.api.model.BattleResponse;
import com.aequilibrium.transformer.service.model.BattleResult;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class WebServiceConverter {

    @Autowired
    @Qualifier("ApiDozerMapper")
    private DozerBeanMapper mapper;

    public BattleResponse toBattleResponse(BattleResult battleResult) {
        return mapper.map(battleResult,BattleResponse.class);
    }
}
