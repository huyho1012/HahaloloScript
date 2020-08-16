package CommonHelper.DriverBrowser;

import CommonHelper.DriverBrowser.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager {
    @Override
    protected void createDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
}
