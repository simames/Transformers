package com.aequilibrium.transformer.api.impl.api.service;

import com.aequilibrium.transformer.api.impl.api.model.CreateTransformerRequest;
import com.aequilibrium.transformer.api.impl.api.model.CreateTransformerResponse;
import io.swagger.annotations.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.core.MediaType;

public interface TransformerAPI {

    @ResponseBody
    @Operation(summary = "Create a transformer")
    @RequestMapping(value = "/createTransformer", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    CreateTransformerResponse createTransformer(@RequestBody CreateTransformerRequest request) ;

}
