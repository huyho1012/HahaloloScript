package Newsfeed.PersonalWall.Photo;

import CommonHelper.Function.AbstractPage;
import Newsfeed.Common.FeedCommon;
import Newsfeed.PersonalWall.About.Common.PersonalAboutUI;
import Newsfeed.PersonalWall.PersonalCommonUI;
import Newsfeed.PersonalWall.TimeLine.PersonalCommon;
import org.openqa.selenium.WebDriver;

public class PersonalPhoto extends FeedCommon {
    WebDriver driver;
    public PersonalPhoto(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkPagePerAboutIsDisplay(WebDriver driver, String fullName) {
        return getTextOfElement(driver, PersonalCommonUI.PERSONAL_NAME).contains(fullName) && getTextOfElement(driver, PersonalPhotoUI.TITTLE_PAGE).contains("Hình ảnh");
    }


}
