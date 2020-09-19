package com.aequilibrium.transformer.app;

import com.aequilibrium.transformer.app.filter.TransformerUnhandledErrorFilter;
import com.aequilibrium.transformer.common.TransformerErrorStatic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
public class WebConfiguration {
    @Bean
    public TransformerErrorStatic transformerErrorStatic() throws IOException {
        Properties enProp = new Properties();
        Map<String, Map<String, String>> transformerMap = new HashMap<>();
        enProp.load(this.getClass().getClassLoader().getResourceAsStream("transformerError_en.properties"));
        transformerMap.put("en",(Map)enProp);
        return new TransformerErrorStatic(transformerMap);
    }

    @Bean
    TransformerUnhandledErrorFilter unhandledErrorFilter(){
        return new TransformerUnhandledErrorFilter();
    }

}
