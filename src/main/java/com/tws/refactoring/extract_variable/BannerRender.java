package com.tws.refactoring.extract_variable;

public class BannerRender {
    void renderBanner(String platform, String browser) {
        boolean matchPlatform = platform.toUpperCase().indexOf("MAC") > -1;
        if (matchPlatform &&
                (browser.toUpperCase().indexOf("IE") > -1)) {
            // do something
            System.out.print("true");
        }
    }
}
