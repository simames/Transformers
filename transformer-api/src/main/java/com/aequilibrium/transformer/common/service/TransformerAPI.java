package com.aequilibrium.transformer.common.service;

import com.aequilibrium.transformer.common.TransformerError;
import com.aequilibrium.transformer.common.model.*;
import io.swagger.v3.oas.annotations.Operation;
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

    @ResponseBody
    @Operation(summary = "Update a transformer")
    @RequestMapping(value = "/updateTransformer", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    UpdateTransformerResponse updateTransformer(@RequestBody UpdateTransformerRequest updateTransformerRequest);

    @ResponseBody
    @Operation(summary = "give a list of transformers")
    @RequestMapping(value = "/listTransformer", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    ListTransformerResponse listTransformers();

    @ResponseBody
    @Operation(summary = "delete a transformer")
    @RequestMapping(value = "/deleteTransformer", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    DeleteTransformerResponse deleteTransformer(@RequestBody DeleteTransformerRequest deleteTransformerRequest) throws TransformerError;
}
