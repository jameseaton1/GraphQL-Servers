package org.example;

public class Selection {

    private final int id;
    private final String name;
    private final String price;
    private final int marketId;

    public Selection(int id, String name, String price, int marketId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.marketId = marketId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public int getMarketId() {
        return marketId;
    }
}
