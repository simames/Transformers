package com.aequilibrium.transformer.common.impl.service.config;

import com.aequilibrium.transformer.common.model.Transformer;
import com.aequilibrium.transformer.persistence.model.TransformerEntity;
import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DozerMapper {
    @Bean
    public DozerBeanMapper beanMapper(){
        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        TransformerMapper(dozerBeanMapper);
        return dozerBeanMapper;
    }

    private void TransformerMapper(DozerBeanMapper dozerBeanMapper) {
        dozerBeanMapper.addMapping(new BeanMappingBuilder() {
            @Override
            protected void configure() {
                mapping(TransformerEntity.class, Transformer.class);
            }
        });
    }

}
