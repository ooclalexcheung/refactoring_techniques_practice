package com.tws.refactoring.extract_variable;

public class PriceCalculator {
    private final double maxmiumShippingCost = 100.0;
    private final double shippingCostRate = 0.1;
    private final int maximunDiscount = 500;
    public double getPrice(int quantity, int itemPrice) {

        // Price consists of: base price - discount + shipping cost
        return getBasePrice(quantity, itemPrice) -
                getDiscount(quantity, itemPrice) +
                getShippingCost(quantity, itemPrice);
    }

    private double getShippingCost(int quantity, int itemPrice) {
        return Math.min(quantity * itemPrice * shippingCostRate, maxmiumShippingCost);
    }

    private double getDiscount(int quantity, int itemPrice) {
        return Math.max(0, quantity - maximunDiscount) * itemPrice * 0.05;
    }

    private int getBasePrice(int quantity, int itemPrice) {
        return quantity * itemPrice;
    }
}
