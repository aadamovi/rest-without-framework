package com.market.rates.domain;

public enum PricingTier {
    A("A", 1.5, 0.015),
    B("B", 2, 0.02),
    C("C", 4, 0.04);

    private final String abbr;
    private final double spreadPercentage;
    private final double spreadMultiplier;

    PricingTier(String abbr, double spreadPercentage, double spreadMultiplier) {
        this.abbr = abbr;
        this.spreadPercentage = spreadPercentage;
        this.spreadMultiplier = spreadMultiplier;
    }

    public String getAbbr() {
        return abbr;
    }

    public double getSpreadPercentage() {
        return spreadPercentage;
    }

    public double getSpreadMultiplier() {
        return spreadMultiplier;
    }
}
