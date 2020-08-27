package Newsfeed.Common;

import CommonHelper.Function.PageGenerator;
import Newsfeed.HeaderMenu.HeaderMenu;
import Newsfeed.HeaderMenu.HeaderPageUI;
import Newsfeed.Common.UpdateInfo.FirstUpdateInfo;
import Newsfeed.Common.UpdateInfo.FirstUpdatePopUpUI;
import Newsfeed.Editor.ExperiencePost.ExperiencePostUI;
import Newsfeed.Editor.NormalPost.NormalPostUI;
import Newsfeed.TabFeed.NewsFeedPageIU;
import org.openqa.selenium.WebDriver;

public class FeedCommon extends HeaderMenu {
    WebDriver driver;
    public FeedCommon(){
    }

    // Điều hướng các tab có trên thanh Nav menu
    public void clickToNavTabOnNewsfeed(WebDriver driver, String nameTab) {
        waitElementToClickAble(driver,NewsFeedPageIU.NAV_FEED_TAB, nameTab);
        clickToElement(driver,NewsFeedPageIU.NAV_FEED_TAB, nameTab);
    }

    // Mở model Post Normal
    public void clickToNormalPostFunction(WebDriver driver) {
        waitElementToClickAble(driver, NormalPostUI.TITLE_POPUP);
        clickToElement(driver, NormalPostUI.TITLE_POPUP);
    }
    // Mở model Post Experience
    public void clickToExperiencePost() {
        waitElementToClickAble(driver, ExperiencePostUI.EXPERIENCE_MODE);
        clickToElement(driver, ExperiencePostUI.EXPERIENCE_MODE);
    }


    public FirstUpdateInfo targetToFirstUpdateInfoPopup(WebDriver driver){
        waitElementToVisible(driver, FirstUpdatePopUpUI.FORM_UPDATE_INFO);
        clickToElement(driver,FirstUpdatePopUpUI.FORM_UPDATE_INFO);
        return PageGenerator.createUpdateInfoPopup(driver);
    }

    public boolean checkViewModelExperiencePostIsDisplay(){
        return checkIsEnableElement(driver, NewsFeedPageIU.MODEL_VIEW_EXPERIENCE);
    }

    // Hàm kiểm tra đã login thành công hay chưa
    public boolean checkLoginSuccess(WebDriver driver) {
        waitElementToVisible(driver, HeaderPageUI.CART_FUNCTION);
        return checkIsDisplayedElement(driver, HeaderPageUI.CART_FUNCTION);
    }















    public void clickLike() {
        setTimeDelay(2);
        scrollToElement(driver,NewsFeedPageIU.React_Button);
        waitElementToClickAble(driver,NewsFeedPageIU.React_Button);
        clickToElement(driver,NewsFeedPageIU.React_Button);
    }
}
