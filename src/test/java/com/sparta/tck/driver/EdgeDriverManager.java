package com.sparta.tck.driver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class EdgeDriverManager extends DriverManager{
    private EdgeDriverService eService;

    @Override
    public void startService() {
        if (null == eService) {
            try {
                eService = new EdgeDriverService.Builder()
                        .usingDriverExecutable(new File("msedgedriver.exe"))
                        .usingAnyFreePort()
                        .build();
                eService.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void stopService() {
        if (null != eService && eService.isRunning())
            eService.stop();
    }

    @Override
    public void createDriver() {
        DesiredCapabilities capabilities = DesiredCapabilities.edge();
        EdgeOptions options = new EdgeOptions();
//        options.addArguments("test-type");
//        capabilities.setCapability(EdgeOptions.E, options);
        driver = new EdgeDriver(eService, capabilities);
    }
}
