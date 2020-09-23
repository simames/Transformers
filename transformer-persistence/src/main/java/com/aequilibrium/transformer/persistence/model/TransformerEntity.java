package com.aequilibrium.transformer.persistence.model;

import javax.persistence.*;


@Entity
public class TransformerEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @Column
    private String name;
    @Column
    private Integer strength;
    @Column
    private Integer intelligence;
    @Column
    private Integer speed;
    @Column
    private Integer endurance;
    @Column
    private Integer rank;
    @Column
    private Integer courage;
    @Column

    private Integer firepower;
    @Column

    private Integer skill;

    @OneToOne

    private TransformerTypeEntity transformerTypeEntity;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getEndurance() {
        return endurance;
    }

    public void setEndurance(Integer endurance) {
        this.endurance = endurance;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getCourage() {
        return courage;
    }

    public void setCourage(Integer courage) {
        this.courage = courage;
    }

    public Integer getFirepower() {
        return firepower;
    }

    public void setFirepower(Integer firepower) {
        this.firepower = firepower;
    }

    public Integer getSkill() {
        return skill;
    }

    public void setSkill(Integer skill) {
        this.skill = skill;
    }

    public TransformerTypeEntity getTransformerTypeEntity() {
        return transformerTypeEntity;
    }

    public void setTransformerTypeEntity(TransformerTypeEntity type) {
        this.transformerTypeEntity = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TransformerEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", strength=" + strength +
                ", intelligence=" + intelligence +
                ", speed=" + speed +
                ", endurance=" + endurance +
                ", rank=" + rank +
                ", courage=" + courage +
                ", firepower=" + firepower +
                ", skill=" + skill +
                ", transformerTypeEntity=" + transformerTypeEntity +
                '}';
    }
}
