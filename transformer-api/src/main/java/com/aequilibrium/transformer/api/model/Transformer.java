package com.aequilibrium.transformer.api.model;

import com.aequilibrium.transformer.common.TransformerError;
import com.aequilibrium.transformer.common.TransformerErrorStatic;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Transformer implements Comparable<Transformer> {

    private Long Id;

    @NotEmpty
    @NotNull
    private String name;

    @NotNull
    @Size(min=1,max = 10)
    @NotEmpty
    private Integer strength;
    @NotNull
    @Size(min=1,max = 10)
    @NotEmpty
    private Integer intelligence;
    @NotNull
    @Size(min=1,max = 10)
    @NotEmpty
    private Integer speed;
    @NotNull
    @Size(min=1,max = 10)
    @NotEmpty
    private Integer endurance;
    @NotNull
    @Size(min=1,max = 10)
    @NotEmpty
    private Integer rank;
    @NotNull
    @Size(min=1,max = 10)
    @NotEmpty
    private Integer courage;
    @NotNull
    @Size(min=1,max = 10)
    @NotEmpty
    private Integer firepower;
    @NotEmpty
    @NotNull
    @Size(min=1,max = 10)
    private Integer skill;

    private Integer ranking;

    @NotNull
    @NotEmpty
    private String type;

    protected Transformer() {
    }

    public void setType(String type){
        if((TransformerEnumType.getByCode(type)!=null)){
            this.type = type;
        }else{
            throw new TransformerError(TransformerErrorStatic.ERROR_TRANSFORMER_GENERAL_TYPE_NOT_VALID);
        }
    }

    public Transformer(@NotEmpty @NotNull String name,
                       @NotNull @Size(min = 1, max = 10)
                       @NotEmpty Integer strength,
                       @NotNull @Size(min = 1, max = 10)
                       @NotEmpty Integer intelligence,
                       @NotNull @Size(min = 1, max = 10)
                       @NotEmpty Integer speed,
                       @NotNull @Size(min = 1, max = 10)
                       @NotEmpty Integer endurance,
                       @NotNull @Size(min = 1, max = 10)
                       @NotEmpty Integer rank,
                       @NotNull @Size(min = 1, max = 10)
                       @NotEmpty Integer courage,
                       @NotNull @Size(min = 1, max = 10)
                       @NotEmpty Integer firepower,
                       @NotEmpty @NotNull @Size(min = 1, max = 10) Integer skill
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
    }

    public void setRanking() {
        this.ranking = strength+ intelligence+speed+endurance+firepower;
    }

    public Integer getRanking() {
        setRanking();
        return this.ranking;
    }

    @Override
    public int compareTo(Transformer o) {
        if(TransformerWinnerNames.OPTIMUS_PRIME.equals(this.getName())||
                TransformerWinnerNames.PREDAKING.equals(this.getName())){
            return -1;
        }else{
            return (o.getRank() > this.getRank())?0:-1;
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

    @Size(min=1,max=10)
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
                ", ranking=" + ranking +
                ", type='" + type + '\'' +
                '}';
    }
}
