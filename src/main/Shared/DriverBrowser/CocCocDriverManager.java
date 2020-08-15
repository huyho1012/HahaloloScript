package DriverBrowser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CocCocDriverManager extends DriverManager {
    @Override
    protected void createDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:/Users/HUY HO/AppData/Local/CocCoc/Browser/Application/browser.exe");
        driver = new ChromeDriver(options);

    }
}
