package common.DriverBrowser;

import common.DriverBrowser.DriverCategory.*;

public class DriverFactory {
    public static DriverManager getBrowser(String browserName){
        DriverManager driverManager;
        switch (browserName){
            case "chrome":
                driverManager = new ChromeDriverManager();
                break;
            case "firefox":
                driverManager = new FirefoxDriverManager();
                break;
            case "ie":
                driverManager = new IEDriverManager();
                break;
            case "coc coc":
                driverManager = new CocCocDriverManager();
                break;
            case "chrome-headless":
                driverManager = new ChromeHeadLessDriverManager();
                break;
            default:
                driverManager = new EdgeDriverManager();
                break;
        }
    return driverManager;
    }
}
