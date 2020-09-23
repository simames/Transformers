package com.aequilibrium.transformer.service.model;

import com.aequilibrium.transformer.api.model.Transformer;

import java.util.List;

public class BattleResult {
    private Integer battleNumbers;
    private List<Transformer> winningTeam;
    private List<Transformer> survivingMembersOfTheLosingTeam;
    private Transformer winner;

    public BattleResult() {
    }

    public BattleResult(Integer battleNumbers, List<Transformer> winningTeam, List<Transformer> survivingMembersOfTheLosingTeam) {
        this.battleNumbers = battleNumbers;
        this.winningTeam = winningTeam;
        this.survivingMembersOfTheLosingTeam = survivingMembersOfTheLosingTeam;
    }

    public Integer getBattleNumbers() {
        return battleNumbers;
    }

    public void setBattleNumbers(Integer battleNumbers) {
        this.battleNumbers = battleNumbers;
    }

    public List<Transformer> getWinningTeam() {
        return winningTeam;
    }

    public void setWinningTeam(List<Transformer> winningTeam) {
        this.winningTeam = winningTeam;
    }

    public List<Transformer> getSurvivingMembersOfTheLosingTeam() {
        return survivingMembersOfTheLosingTeam;
    }

    public void setSurvivingMembersOfTheLosingTeam(List<Transformer> survivingMembersOfTheLosingTeam) {
        this.survivingMembersOfTheLosingTeam = survivingMembersOfTheLosingTeam;
    }

    public Transformer getWinner() {
        return winner;
    }

    public void setWinner(Transformer winner) {
        this.winner = winner;
    }

    @Override
    public String toString() {
        return "BattleResult{" +
                "battleNumbers=" + battleNumbers +
                ", winningTeam=" + winningTeam +
                ", survivingMembersOfTheLosingTeam=" + survivingMembersOfTheLosingTeam +
                ", winner=" + winner +
                '}';
    }
}
