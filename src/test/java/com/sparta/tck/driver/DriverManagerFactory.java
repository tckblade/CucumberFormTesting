package com.sparta.tck.driver;

public class DriverManagerFactory {

    public static DriverManager getManager(DriverType type) {

        DriverManager driverManager;

        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case EDGE:
                driverManager = new EdgeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
//            default:
//                driverManager = new SafariDriverManager();
//                break;
            default:
                driverManager = new ChromeDriverManager();
                break;
        }
        return driverManager;

    }
}
