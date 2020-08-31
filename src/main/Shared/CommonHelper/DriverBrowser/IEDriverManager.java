package CommonHelper.DriverBrowser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEDriverManager extends DriverManager {
    @Override
    protected void createDriver() {
        WebDriverManager.iedriver().arch32().setup();
        driver = new InternetExplorerDriver();
    }
}
