package com.aequilibrium.transformer.api.model;

import java.io.Serializable;
import java.util.List;

public class BattleResponse  implements Serializable {

    private Integer battleNumbers;
    private List<Transformer> winningTeam;
    private List<Transformer> survivingMembersOfTheLosingTeam;
    private Transformer winner;

    protected BattleResponse() {
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
}
