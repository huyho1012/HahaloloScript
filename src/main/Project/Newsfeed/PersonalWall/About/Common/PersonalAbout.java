package Newsfeed.PersonalWall.About.Common;

import Newsfeed.HeaderMenu.HeaderMenu;
import PersonalWall.About.Common.PersonalAboutUI;
import org.openqa.selenium.WebDriver;

public class PersonalAbout extends HeaderMenu {
    WebDriver driver;
    public boolean checkDataValueAccount(WebDriver driver, String valuePer, String valueData){
        waitElementToVisible(driver, PersonalAboutUI.VALUE_OF_PERSONAL,valuePer);
        if(getTextOfElement(driver,PersonalAboutUI.VALUE_OF_PERSONAL,valuePer).equals(valueData)){
            return true;
        }else
            return false;
    }

    public void clickToOverViewTab(){
        waitElementToVisible(driver,PersonalAboutUI.OVERVIEW_TAB);
        clickToElement(driver,PersonalAboutUI.OVERVIEW_TAB);
    }

    public void clickToWorkAndEduTab(){
        waitElementToVisible(driver,PersonalAboutUI.EDUCATION_WORK_TAB);
        clickToElement(driver,PersonalAboutUI.EDUCATION_WORK_TAB);
    }

    public void clickToBasicInfoTab(){
        waitElementToVisible(driver,PersonalAboutUI.BASIC_INFO_TAB);
        clickToElement(driver,PersonalAboutUI.BASIC_INFO_TAB);
    }

    public void clickToPlaceLivingTab(){
        waitElementToVisible(driver,PersonalAboutUI.LIVING_PLACE_TAB);
        clickToElement(driver,PersonalAboutUI.LIVING_PLACE_TAB);
    }
    public void clickToDetailAboutYouTab(){
        waitElementToVisible(driver,PersonalAboutUI.DETAILS_ABOUT_TAB);
        clickToElement(driver,PersonalAboutUI.DETAILS_ABOUT_TAB);
    }
}
