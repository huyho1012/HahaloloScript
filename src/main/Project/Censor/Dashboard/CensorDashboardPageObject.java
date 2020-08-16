package Censor.Dashboard;

import CommonHelper.Function.AbstractPage;
import org.openqa.selenium.WebDriver;

public class CensorDashboardPageObject extends AbstractPage {
    WebDriver driver;
    public CensorDashboardPageObject(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkLoginCensorSuccess(){
        waitElementToVisible(driver, CensorHomeUI.NOTI_ICON);
        return checkIsDisplayedElement(driver, CensorHomeUI.NOTI_ICON);
    }

    public void clickToItemOnMenu(WebDriver driver, String functionName) {
        waitElementToClickAble(driver, CensorHomeUI.MENU_FUNCTION,functionName);
        clickToElement(driver, CensorHomeUI.MENU_FUNCTION,functionName);
    }

    public void checkAndChangeLanguageToVI(WebDriver driver){
        waitForPageLoading(driver);
        if(checkIsDisplayedElement(driver, CensorHomeUI.ENG_LANGUAGE_ICON)){
            waitElementToVisible(driver, CensorHomeUI.ENG_LANGUAGE_ICON);
            clickToElement(driver, CensorHomeUI.ENG_LANGUAGE_ICON);
        }
    }
}
