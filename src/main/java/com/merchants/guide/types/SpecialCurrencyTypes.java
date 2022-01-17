package com.merchants.guide.types;

public enum SpecialCurrencyTypes {

    SILVER("silver"),
    GOLD("gold"),
    IRON("iron");

    private String description;

    SpecialCurrencyTypes(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description.toLowerCase();
    }

}
