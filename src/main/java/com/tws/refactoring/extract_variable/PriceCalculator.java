package com.tws.refactoring.extract_variable;

public class PriceCalculator {
    public double getPrice(int quantity, int itemPrice) {
        // Price consists of: base price - discount + shipping cost
        return getBasePrice(quantity, itemPrice) -
                Math.max(0, quantity - 500) * itemPrice * 0.05 +
                Math.min(quantity * itemPrice * 0.1, 100.0);
    }

    private int getBasePrice(int quantity, int itemPrice) {
        return quantity * itemPrice;
    }
}
