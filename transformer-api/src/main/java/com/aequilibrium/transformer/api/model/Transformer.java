package com.aequilibrium.transformer.api.model;

import com.aequilibrium.transformer.common.TransformerEnumType;
import com.aequilibrium.transformer.common.TransformerError;
import com.aequilibrium.transformer.common.TransformerErrorStatic;
import com.aequilibrium.transformer.common.TransformerWinnerNames;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;


public class Transformer implements Comparable<Transformer>, Serializable {

    @ApiModelProperty(notes = "Transformer's id automatically created when transformer is created",name="id")
    private Long Id;


    @NotNull
    @Size(min = 1,max=38)
    @ApiModelProperty(notes = "Transformer's name",name="name",required=true)
    private String name;

    @NotNull
    @Min(1)
    @Max(10)
    @ApiModelProperty(notes = "Transformer's strength which is used in overall rating",name="strength",required=true)
    private Integer strength;
    @NotNull
    @Min(1)
    @Max(10)
    @ApiModelProperty(notes = "Transformer's intelligence which is used in overall rating",name="intelligence",required=true)
    private Integer intelligence;
    @NotNull
    @Min(1)
    @Max(10)
    @ApiModelProperty(notes = "Transformer's speed which is used in overall rating",name="speed",required=true)
    private Integer speed;
    @NotNull
    @Min(1)
    @Max(10)
    @ApiModelProperty(notes = "Transformer's endurance which is used in overall rating ",name="endurance",required=true)
    private Integer endurance;
    @NotNull
    @Min(1)
    @Max(10)
    @ApiModelProperty(notes = "Transformer's rank which is used to sort transformers in the event of battle",name="rank",required=true)
    private Integer rank;
    @NotNull
    @Min(1)
    @Max(10)
    @ApiModelProperty(notes = "Transformer's courage",name="courage",required=true)
    private Integer courage;
    @NotNull
    @Min(1)
    @Max(10)
    @ApiModelProperty(notes = "Transformer's firepower which is used in overall rating",name="firepower",required=true)
    private Integer firepower;

    @NotNull
    @Min(1)
    @Max(10)
    @ApiModelProperty(notes = "Transformer's skill",name="skill",required=true)
    private int skill;

    @ApiModelProperty(notes = "Automatically created : Strength+Intelligence+Speed+Endurance+Firepower ",name="rating")
    private int rating;

    @NotNull
    @Size(min = 1, max=3)
    @ApiModelProperty(notes = "Transformer's type should be 'DES' or 'AUT'",name="type",required=true)
    private String type;

    protected Transformer() {
    }

    public void setType(String type) {
        if ((TransformerEnumType.getByCode(type) != null
                &&(TransformerEnumType.AUTOBOT.getCode().equals(type)
                ||TransformerEnumType.DESEPTICAN.getCode().equals(type)))) {
            this.type = type;
        } else {
            throw new TransformerError(TransformerErrorStatic.ERROR_TRANSFORMER_GENERAL_TYPE_NOT_VALID);
        }
    }

    public Transformer(@NotNull String name,
                       @NotNull @Min(1) @Max(10) Integer strength,
                       @NotNull @Min(1) @Max(10) Integer intelligence,
                       @NotNull @Min(1) @Max(10) Integer speed,
                       @NotNull @Min(1) @Max(10) Integer endurance,
                       @NotNull @Min(1) @Max(10) Integer rank,
                       @NotNull @Min(1) @Max(10) Integer courage,
                       @NotNull @Min(1) @Max(10) Integer firepower,
                       @NotNull @Min(1) @Max(10) Integer skill,
                       @NotNull @Size(min=1, max = 3)  String type) {
        this(name,strength,intelligence,speed,endurance,rank,courage,firepower,skill);
        setType(type);
        setRanking();
    }

    protected Transformer(@NotNull String name,
                          @NotNull @Min(1) @Max(10)
                               Integer strength,
                          @NotNull @Min(1) @Max(10)
                               Integer intelligence,
                          @NotNull @Min(1) @Max(10)
                               Integer speed,
                          @NotNull @Min(1) @Max(10)
                               Integer endurance,
                          @NotNull @Min(1) @Max(10)
                               Integer rank,
                          @NotNull @Min(1) @Max(10)
                               Integer courage,
                          @NotNull @Min(1) @Max(10)
                               Integer firepower,
                          @NotNull @Min(1) @Max(10) Integer skill
    ) {

        this.name = name;
        this.strength = strength;
        this.intelligence = intelligence;
        this.speed = speed;
        this.endurance = endurance;
        this.rank = rank;
        this.courage = courage;
        this.firepower = firepower;
        this.skill = skill;
        setRanking();
    }

    public void setRanking() {
        this.rating = strength + intelligence + speed + endurance + firepower;
    }

    public Integer getRating() {
        setRanking();
        return this.rating;
    }

    @Override
    public int compareTo(Transformer o) {
        if (TransformerWinnerNames.OPTIMUS_PRIME.equals(this.getName()) ||
                TransformerWinnerNames.PREDAKING.equals(this.getName())) {
            return -1;
        } else {
            return (o.getRank() > this.getRank()) ? 0 : -1;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transformer that = (Transformer) o;
        return Id.equals(that.Id);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
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

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Transformer{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", strength=" + strength +
                ", intelligence=" + intelligence +
                ", speed=" + speed +
                ", endurance=" + endurance +
                ", rank=" + rank +
                ", courage=" + courage +
                ", firepower=" + firepower +
                ", skill=" + skill +
                ", rating=" + rating +
                ", type='" + type + '\'' +
                '}';
    }
}
