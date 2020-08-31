package Newsfeed.PersonalWall.Friends;

import CommonHelper.Function.AbstractPage;
import Newsfeed.Common.FeedCommon;
import Newsfeed.PersonalWall.PersonalCommonUI;
import org.openqa.selenium.WebDriver;

public class PersonalFriend extends FeedCommon {
    WebDriver driver;
    public PersonalFriend(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean checkPerFriendIsDisplay(WebDriver driver, String fullName) {
        return getTextOfElement(driver, PersonalCommonUI.PERSONAL_NAME).contains(fullName) && checkIsDisplayedElement(driver, PersonalFriendUI.SEARCH_FRIEND_FIELD);
    }
}

