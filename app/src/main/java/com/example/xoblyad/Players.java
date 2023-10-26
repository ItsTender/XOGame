package com.example.xoblyad;

import java.text.ParseException;

public class Players {
    private String PlayerX;
    private String PlayerO;
    private int ScoreX;
    private int ScoreO;

    public Players() {
    }
    public Players(String playerX, String playerO) {
        PlayerX = playerX;
        PlayerO = playerO;
        ScoreX=0;
        ScoreO=0;
    }

    public String getPlayerX() {
        return PlayerX;
    }

    public void setPlayerX(String playerX) {
        PlayerX = playerX;
    }

    public String getPlayerO() {
        return PlayerO;
    }

    public void setPlayerO(String playerO) {
        PlayerO = playerO;
    }

    public int getScoreX() {
        return ScoreX;
    }

    public void setScoreX(int scoreX) {
        ScoreX = scoreX;
    }

    public int getScoreO() {
        return ScoreO;
    }

    public void setScoreO(int scoreO) {
        ScoreO = scoreO;
    }
}
