package com.tws.refactoring.extract_method;


import com.tws.refactoring.extract_variable.BannerRender;
import com.tws.refactoring.extract_variable.PriceCalculator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class PriceCalculatorTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void PriceCalculator() {
        PriceCalculator priceCalculator = new PriceCalculator();
        int quantity =10;
        int itemPrice = 20;
        double expectedResult = 220.00;
        //      When
        double outContect = priceCalculator.getPrice(quantity,itemPrice);

        assertEquals(expectedResult,outContect,0.01);

    }
}