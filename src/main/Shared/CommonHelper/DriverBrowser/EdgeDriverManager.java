package CommonHelper.DriverBrowser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager extends DriverManager {
    @Override
    protected void createDriver() {
        WebDriverManager.chromiumdriver().setup();
        driver = new EdgeDriver();
    }
}
