package com.aequilibrium.transformer.api.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Transformer {

    private Long Id;
    @NotNull
    @Size(min=1,max = 10)
    private int strength;
    @NotNull
    @Size(min=1,max = 10)
    private int intelligence;
    @NotNull
    @Size(min=1,max = 10)
    private int speed;
    @NotNull
    @Size(min=1,max = 10)
    private int endurance;
    @NotNull
    @Size(min=1,max = 10)
    private int rank;
    @NotNull
    @Size(min=1,max = 10)
    private int courage;
    @NotNull
    @Size(min=1,max = 10)
    private int firepower;
    @NotNull
    @Size(min=1,max = 10)
    private int skill;

    protected Transformer() {
    }

    public Transformer( int strength, int intelligence, int speed, int endurance, int rank, int courage, int firepower, int skill) {
        this.strength = strength;
        this.intelligence = intelligence;
        this.speed = speed;
        this.endurance = endurance;
        this.rank = rank;
        this.courage = courage;
        this.firepower = firepower;
        this.skill = skill;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getCourage() {
        return courage;
    }

    public void setCourage(int courage) {
        this.courage = courage;
    }

    public int getFirepower() {
        return firepower;
    }

    public void setFirepower(int firepower) {
        this.firepower = firepower;
    }

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }
}
