package com.tws.refactoring.extract_method;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class OwingPrinterTest {
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
    public void printOwing() {
        OwingPrinter printer = new OwingPrinter();
        String name = "Name1";
        List<Order> orders = new ArrayList<Order>();
        Order element = new Order(2.5);
        Order element1 = new Order(0.5);
        orders.add(element);
        orders.add(element1);
        //      When
        printer.printOwing(name,orders);
        String expectedResult = "";
        expectedResult += "*****************************\r\n";
        expectedResult += "****** Customer totals ******\r\n";
        expectedResult += "*****************************\r\n";
        expectedResult += "name: Name1\r\n";
        expectedResult += "amount: 3.0\r\n";
        assertEquals(expectedResult, outContent.toString());
    }
}