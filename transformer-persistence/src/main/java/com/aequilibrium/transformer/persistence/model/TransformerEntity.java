package com.aequilibrium.transformer.persistence.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
public class TransformerEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
