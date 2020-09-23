package com.aequilibrium.transformer.api.service;

import com.aequilibrium.transformer.api.model.*;
import com.aequilibrium.transformer.common.TransformerError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.core.MediaType;

@Validated
public interface TransformerAPI {

    @ResponseBody
    @RequestMapping(value = "/createTransformer", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    CreateTransformerResponse createTransformer(@Valid @NotNull @RequestBody CreateTransformerRequest request);

    @ResponseBody
    @RequestMapping(value = "/updateTransformer", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    UpdateTransformerResponse updateTransformer(@Valid @NotNull @RequestBody UpdateTransformerRequest updateTransformerRequest);

    @ResponseBody
    @RequestMapping(value = "/listTransformer", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    ListTransformerResponse listTransformers();

    @ResponseBody
    @RequestMapping(value = "/deleteTransformer", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    DeleteTransformerResponse deleteTransformer(@Valid @NotNull @RequestBody DeleteTransformerRequest deleteTransformerRequest) throws TransformerError;

    @ResponseBody
    @RequestMapping(value = "/transformersBattle", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    BattleResponse transformersBattle(@Valid @NotNull @RequestBody BattleRequest battleRequest) throws TransformerError;


}
