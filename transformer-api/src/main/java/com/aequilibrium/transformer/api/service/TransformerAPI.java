package com.aequilibrium.transformer.api.service;

import com.aequilibrium.transformer.api.model.*;
import com.aequilibrium.transformer.common.TransformerError;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.lang.NonNullApi;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.core.MediaType;

@Validated
@Api(value = "TransformersGame",description = "REST Api for the Transformers Game")
public interface TransformerAPI {

    @ResponseBody
    @ApiOperation(value = "Create a transformer ")
    @RequestMapping(value = "/createTransformer", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    CreateTransformerResponse createTransformer(@Valid @NotNull @RequestBody CreateTransformerRequest request);

    @ResponseBody
    @ApiOperation(value = "Update a transformer")
    @RequestMapping(value = "/updateTransformer", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    UpdateTransformerResponse updateTransformer(@Valid @NotNull @RequestBody UpdateTransformerRequest updateTransformerRequest);

    @ResponseBody
    @ApiOperation(value = "Get list of all transformers")
    @RequestMapping(value = "/listTransformer", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    ListTransformerResponse listTransformers();

    @ResponseBody
    @ApiOperation(value = "delete transformers")
    @RequestMapping(value = "/deleteTransformer", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    DeleteTransformerResponse deleteTransformer(@Valid @NotNull @RequestBody DeleteTransformerRequest deleteTransformerRequest) throws TransformerError;

    @ResponseBody
    @ApiOperation(value = "Battle between transformers")
    @RequestMapping(value = "/transformersBattle", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    TransformersBattleResponse transformersBattle(@Valid @NotNull @RequestBody TransformersBattleRequest transformersBattleRequest) throws TransformerError;


}
