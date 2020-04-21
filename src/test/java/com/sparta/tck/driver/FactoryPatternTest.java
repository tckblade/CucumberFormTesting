package com.sparta.tck.driver;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class FactoryPatternTest {

    DriverManager driverManager;
    WebDriver driver;

    @BeforeAll
    public void beforeTest() {
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
    }

    @BeforeEach
    public void beforeMethod() {
        driver = driverManager.getDriver();
    }

    @AfterEach
    public void afterMethod() {
        driverManager.quitDriver();
    }

    @Test
    public void launchTestAutomationGuruTest() {
        driver.get("http://testautomationguru.com");
        Assertions.assertEquals("TestAutomationGuru – A technical blog on test automation", driver.getTitle());
    }

    @Test
    public void launchGoogleTest() {
        driver.get("https://www.google.com");
        Assertions.assertEquals("Google", driver.getTitle());
    }

    @Test
    public void launchYahooTest() {
        driver.get("https://www.yahoo.com");
        Assertions.assertEquals("Yahoo", driver.getTitle());
    }

}