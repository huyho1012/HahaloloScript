package DriverBrowser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeHeadLessDriverManager extends DriverManager {
    @Override
    protected void createDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("windown-size=1366x768");
        driver = new ChromeDriver(options);
    }
}
