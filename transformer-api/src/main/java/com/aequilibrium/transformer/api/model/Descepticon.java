package com.aequilibrium.transformer.api.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Descepticon extends Transformer {

    protected Descepticon() {
    }

    public Descepticon(@NotEmpty @NotNull String name, @NotNull @Size(min = 1, max = 10) @NotEmpty Integer strength, @NotNull @Size(min = 1, max = 10) @NotEmpty Integer intelligence, @NotNull @Size(min = 1, max = 10) @NotEmpty Integer speed, @NotNull @Size(min = 1, max = 10) @NotEmpty Integer endurance, @NotNull @Size(min = 1, max = 10) @NotEmpty Integer rank, @NotNull @Size(min = 1, max = 10) @NotEmpty Integer courage, @NotNull @Size(min = 1, max = 10) @NotEmpty Integer firepower, @NotEmpty @NotNull @Size(min = 1, max = 10) Integer skill) {
        super(name, strength, intelligence, speed, endurance, rank, courage, firepower, skill);
        super.setType(TransformerEnumType.DESEPTICAN.getCode());
    }

}
