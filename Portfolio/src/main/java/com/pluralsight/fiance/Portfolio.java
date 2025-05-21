package com.pluralsight.fiance;

import java.util.List;

public class Portfolio {
    private String name;
    private String owner;
    private List<Asset> assets;

    public Portfolio(String name, String owner) {
        this.name = name;
        this.owner = owner;

    }

}
