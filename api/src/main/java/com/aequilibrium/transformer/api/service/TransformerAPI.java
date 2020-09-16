package com.aequilibrium.transformer.api.service;

import com.aequilibrium.transformer.api.model.CreateTransformerRequest;
import com.aequilibrium.transformer.api.model.CreateTransformerResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.ws.rs.core.MediaType;

public interface TransformerAPI {
    @ResponseBody
    @RequestMapping(value = "/createTransformer", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    CreateTransformerResponse createTransformer(@RequestBody CreateTransformerRequest request) ;

}
