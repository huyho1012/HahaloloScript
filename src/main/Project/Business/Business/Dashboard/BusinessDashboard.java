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

    public boolean  checkDashboardPageIsDisplayCaseHaveBusiness(WebDriver driver, String parentID) {
        setTimeDelay(1);
        switchToAnotherWindowByTitle(driver, parentID);
        return getTextOfElement(driver, BusinessDashboardUI.TITLE_CONTENT).contains("Quản lý tài khoản")
                && checkIsDisplayedElement(driver, BusinessDashboardUI.BUTTON_CONTENT,"Quản lý tài khoản");
    }

    public void clickToBusiness() {
        clickToElement(driver,BusinessDashboardUI.BUTTON_CONTENT);
    }
}
