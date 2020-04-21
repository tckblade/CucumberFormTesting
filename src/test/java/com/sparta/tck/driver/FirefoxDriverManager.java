package com.sparta.tck.driver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class FirefoxDriverManager extends DriverManager{

    private GeckoDriverService gkService;

    @Override
    public void startService() {
        if (null == gkService) {
            try {
                gkService = new GeckoDriverService.Builder()
                        .usingDriverExecutable(new File("geckodriver.exe"))
                        .usingAnyFreePort()
                        .build();
                gkService.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void stopService() {
        if (null != gkService && gkService.isRunning())
            gkService.stop();
    }

    @Override
    public void createDriver() {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("test-type");
        capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
        driver = new FirefoxDriver(gkService, capabilities);
    }
}
