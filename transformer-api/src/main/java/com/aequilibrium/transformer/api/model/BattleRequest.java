package com.aequilibrium.transformer.api.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

public class BattleRequest  implements Serializable {

    @NotNull
    @Size(min=1)
    private List<Long> transformerIds;

    protected BattleRequest() {
    }

    public BattleRequest(List<Long> transformersIds) {
        this.transformerIds = transformersIds;
    }

    public List<Long> getTransformerIds() {
        return transformerIds;
    }

    public void setTransformerIds(List<Long> transformerIds) {
        this.transformerIds = transformerIds;
    }
}
