package actions.PageObject.newsfeed.AccountSetting;

import actions.PageObject.newsfeed.Common.HeaderMenu;
import interfaces.Newsfeed.AccountSetting.AccountSettingUI;
import org.openqa.selenium.WebDriver;

public class NewsFeedAccSettingGeneral extends HeaderMenu {
    WebDriver driver;
    public NewsFeedAccSettingGeneral(WebDriver webDriver){
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
