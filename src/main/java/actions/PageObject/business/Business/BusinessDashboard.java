package actions.PageObject.business.Business;

import actions.PageObject.newsfeed.Common.HeaderMenu;
import actions.common.Function.PageGenerator;
import actions.common.Global_Constant;
import org.openqa.selenium.WebDriver;

public class BusinessDashboard extends HeaderMenu {
    WebDriver driver;
    public BusinessDashboard(WebDriver webDriver){
        driver = webDriver;
    }

    public BusinessDashboard getBusinessPage(WebDriver driver){
        openURL(driver, Global_Constant.URL_BUSINESS_PAGE);
        return PageGenerator.getBusinessDashboardPage(driver);
    }
}
