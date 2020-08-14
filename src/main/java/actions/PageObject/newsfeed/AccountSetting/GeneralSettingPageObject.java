package actions.PageObject.Newsfeed.AccountSetting;

import actions.common.Function.AbstractPage;
import interfaces.Newsfeed.AccountSetting.AccountSettingUI;
import org.openqa.selenium.WebDriver;

public class GeneralSettingPageObject extends AbstractPage {

    WebDriver driver;
    public GeneralSettingPageObject(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkFullNameIsDisplay(WebDriver driver,String name) {
        waitElementToVisible(driver, AccountSettingUI.FULL_NAME_DATA);
        return (getTextOfElement(driver,AccountSettingUI.FULL_NAME_DATA).trim().equals(name.trim()));
    }
    public String getFullNameIsDisplay(WebDriver driver){
        waitElementToVisible(driver,AccountSettingUI.FULL_NAME_DATA);
        return  getTextOfElement(driver,AccountSettingUI.FULL_NAME_DATA);
    }

}
