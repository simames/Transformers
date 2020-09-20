package com.aequilibrium.transformer.service.config;

import com.aequilibrium.transformer.api.model.Transformer;
import com.aequilibrium.transformer.persistence.model.TransformerEntity;
import com.aequilibrium.transformer.service.model.TransformerType;
import org.dozer.CustomConverter;
import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DozerMapper {
    @Bean("serviceMapper")
    public DozerBeanMapper beanMapper(){
        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        transformerMapper(dozerBeanMapper);
        return dozerBeanMapper;
    }

    private void transformerMapper(DozerBeanMapper dozerBeanMapper) {
        dozerBeanMapper.addMapping(new BeanMappingBuilder() {
            @Override
            protected void configure() {
                mapping(TransformerEntity.class, Transformer.class);
            }
        });
        dozerBeanMapper.addMapping(new BeanMappingBuilder() {
            @Override
            protected void configure() {
                mapping(TransformerType.class, TransformerEntity.class);
            }
        });
    }


}
