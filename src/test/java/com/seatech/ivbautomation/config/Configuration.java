package com.seatech.ivbautomation.config;

import org.testng.annotations.BeforeTest;

public class Configuration {

    @BeforeTest
    public void setUpAll() {
        String chromeDriverPath = System.getenv("chromeDriverPath");
        String firefoxDriverPath = System.getenv("chromeDriverPath");
        String edgeDriverPath = System.getenv("chromeDriverPath");
        String baseUrl = System.getenv("baseUrl");

        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        System.setProperty("webdriver.edge.driver", edgeDriverPath);
        System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
        com.codeborne.selenide.Configuration.baseUrl = baseUrl;
        com.codeborne.selenide.Configuration.browserSize = "1280x800";
    }
}
