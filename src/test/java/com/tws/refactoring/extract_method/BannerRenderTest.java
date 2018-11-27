package com.tws.refactoring.extract_variable;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BannerRenderTest {
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
    public void BannerRender() {
        BannerRender bannerRender = new BannerRender();
        String platform = "MAC";
        String browser = "IE";
        //      When
        bannerRender.renderBanner(platform,browser);
        String expectedResult  ="true";
        assertEquals(expectedResult, outContent.toString());

    }
}