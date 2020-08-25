package Business.Business.Dashboard;

import CommonHelper.Function.PageGenerator;
import CommonHelper.GlobalVariables;
import Newsfeed.HeaderMenu.HeaderMenu;
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

    public boolean checkBusinessDashboardPageIsDisplay(WebDriver driver) {
        return true;
    }
}
