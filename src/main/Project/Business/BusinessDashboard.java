import HeaderMain.HeaderMenu;
import actions.common.Function.PageGenerator;
import actions.common.GlobalVariables;
import org.openqa.selenium.WebDriver;

public class BusinessDashboard extends HeaderMenu {
    WebDriver driver;
    public BusinessDashboard(WebDriver webDriver){
        driver = webDriver;
    }

    public BusinessDashboard getBusinessPage(WebDriver driver){
        openURL(driver, GlobalVariables.URL_BUSINESS_PAGE);
        return PageGenerator.getBusinessDashboardPage(driver);
    }
}
