package actions.PageObject.newsfeed.PersonalWall;

import actions.PageObject.newsfeed.Common.HeaderMenu;
import actions.common.Function.AbstractPage;
import interfaces.Newsfeed.PersonalWall.PersonalAboutUI;
import org.openqa.selenium.WebDriver;

public class PersonalAbout extends AbstractPage {
    WebDriver driver;
    public PersonalAbout(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkDataValueAccount(WebDriver driver, String valuePer, String valueData){
        waitElementToVisible(driver, PersonalAboutUI.VALUE_OF_PERSONAL,valuePer);
        if(getTextOfElement(driver,PersonalAboutUI.VALUE_OF_PERSONAL,valuePer).equals(valueData)){
            return true;
        }else
            return false;
    }

    public void clickToBasicInfo() {
    waitElementToVisible(driver,PersonalAboutUI.ABOUT_MENU_TAB);
    clickToElement(driver,PersonalAboutUI.ABOUT_MENU_TAB);
    }
}
