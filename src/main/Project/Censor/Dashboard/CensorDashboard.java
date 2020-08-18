package Censor.Dashboard;

import CommonHelper.Function.AbstractPage;
import org.openqa.selenium.WebDriver;

public class CensorDashboard extends AbstractPage {
    WebDriver driver;
    public CensorDashboard(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkLoginCensorSuccess(){
        waitElementToVisible(driver, CensorHomeUI.NAV_MENU_BARD);
        return checkIsDisplayedElement(driver, CensorHomeUI.NAV_MENU_BARD);
    }

    public void clickToItemOnMenu(WebDriver driver, String functionName) {
        waitElementToClickAble(driver, CensorHomeUI.MENU_FUNCTION,functionName);
        clickToElement(driver, CensorHomeUI.MENU_FUNCTION,functionName);
    }

    public void checkAndChangeLanguageToVI(WebDriver driver){
        waitForPageLoading(driver);
        if(getTextOfElement(driver, CensorHomeUI.LANGUAGE_ICON)=="English"){
            waitElementToVisible(driver, CensorHomeUI.LANGUAGE_ICON);
            clickToElement(driver, CensorHomeUI.LANGUAGE_ICON);
        }
    }
}
