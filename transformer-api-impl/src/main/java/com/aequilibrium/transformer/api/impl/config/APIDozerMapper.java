package com.aequilibrium.transformer.api.impl.config;

import com.aequilibrium.transformer.api.model.BattleResponse;
import com.aequilibrium.transformer.service.model.BattleResult;
import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class APIDozerMapper {
    @Bean("ApiDozerMapper")
    public DozerBeanMapper beanMapper(){
        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        battleMapper(dozerBeanMapper);
        return dozerBeanMapper;
    }

    private void battleMapper(DozerBeanMapper dozerBeanMapper) {
        dozerBeanMapper.addMapping(new BeanMappingBuilder() {
            @Override
            protected void configure() {
                mapping(BattleResponse.class, BattleResult.class);
            }
        });
    }

}
