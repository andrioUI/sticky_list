package com.xyz.stickyitemscrolling;

public class PlayersDataItem {

    private String rank;
    private String name;
    private String points;
    private String priceMoney;

    public PlayersDataItem(String rank, String name, String points, String priceMoney) {
        this.rank = rank;
        this.name = name;
        this.points = points;
        this.priceMoney = priceMoney;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getPriceMoney() {
        return priceMoney;
    }

    public void setPriceMoney(String priceMoney) {
        this.priceMoney = priceMoney;
    }
}
