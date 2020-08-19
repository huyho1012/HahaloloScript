package Newsfeed.Widget.SidebarRight.HotExperience;

import Newsfeed.Common.FeedCommon;
import org.openqa.selenium.WebDriver;

public class HotExperience extends FeedCommon {
    WebDriver driver;

    public String checkTitleOfWidget(){
        waitElementToVisible(driver,HotExperienceUI.TITLE_WIDGET);
        return getTextOfElement(driver,HotExperienceUI.TITLE_WIDGET);
    }
    public String getTitleOfHotExperiencePost(){
        waitElementToVisible(driver,HotExperienceUI.TITLE_EXP_POST);
        return  getTextOfElement(driver,HotExperienceUI.TITLE_EXP_POST);
    }
    public String getURLOfCoverHotExperiencePost(){
        waitElementToVisible(driver,HotExperienceUI.COVER_EXP_POST);
        return getAttributeOfElement(driver,HotExperienceUI.COVER_EXP_POST,"src");
    }
    public String getAuthorOfHotExperiencePost(){
        waitElementToVisible(driver,HotExperienceUI.AUTHOR_EXP_POST);
        return getTextOfElement(driver,HotExperienceUI.AUTHOR_EXP_POST);
    }

    public String getCreatedDateOfHotExperiencePost(){
        waitElementToVisible(driver,HotExperienceUI.CREATED_DATE_POST);
        return getTextOfElement(driver,HotExperienceUI.CREATED_DATE_POST);
    }

    public void clickToViewMoreHotExperience(){
        waitElementToClickAble(driver, HotExperienceUI.BUTTON_VIEW_MORE_EXP);
        clickToElement(driver,HotExperienceUI.BUTTON_VIEW_MORE_EXP);
    }

}
