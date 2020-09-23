package com.aequilibrium.transformer.api.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class TransformersBattleResponse implements Serializable {

    @ApiModelProperty(notes = "The number of battles",name="battleNumbers")
    private Integer battleNumbers;
    @ApiModelProperty(notes = "The list of transformers winners",name="winningTeam")
    private List<Transformer> winningTeam;
    @ApiModelProperty(notes = "The list of transformers who has been survived",name="survivingMembersOfTheLosingTeam")
    private List<Transformer> survivingMembersOfTheLosingTeam;
    @ApiModelProperty(notes = "The winner transformer",name="winner")
    private Transformer winner;

    protected TransformersBattleResponse() {
    }

    public Integer getBattleNumbers() {
        return battleNumbers;
    }

    public void setBattleNumbers(Integer battleNumbers) {
        this.battleNumbers = battleNumbers;
    }


    public List<Transformer> getSurvivingMembersOfTheLosingTeam() {
        return survivingMembersOfTheLosingTeam;
    }

    public void setSurvivingMembersOfTheLosingTeam(List<Transformer> survivingMembersOfTheLosingTeam) {
        this.survivingMembersOfTheLosingTeam = survivingMembersOfTheLosingTeam;
    }


    public List<Transformer> getWinningTeam() {
        return winningTeam;
    }

    public void setWinningTeam(List<Transformer> winningTeam) {
        this.winningTeam = winningTeam;
    }


    public Transformer getWinner() {
        return winner;
    }

    public void setWinner(Transformer winner) {
        this.winner = winner;
    }

    @Override
    public String toString() {
        return "TransformersBattleResponse{" +
                "battleNumbers=" + battleNumbers +
                ", winningTeam=" + winningTeam +
                ", survivingMembersOfTheLosingTeam=" + survivingMembersOfTheLosingTeam +
                ", winner=" + winner +
                '}';
    }
}
