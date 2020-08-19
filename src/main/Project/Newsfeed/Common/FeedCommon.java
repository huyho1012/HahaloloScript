package Newsfeed.Common;

import CommonHelper.Function.PageGenerator;
import HeaderMain.HeaderMenu;
import HeaderMain.HeaderPageUI;
import Newsfeed.Common.UpdateInfo.FirstUpdateInfo;
import Newsfeed.Common.UpdateInfo.FirstUpdatePopUpUI;
import Newsfeed.Editor.ExperiencePost.ExperiencePostUI;
import Newsfeed.Editor.NormalPost.NormalPostUI;
import Newsfeed.Widget.SidebarRight.HotExperience.HotExperience;
import Newsfeed.TabFeed.NewsFeedPageIU;
import org.openqa.selenium.WebDriver;

public class FeedCommon extends HeaderMenu {
    public FeedCommon(){
        HotExperience hotExp = new HotExperience();
    }
    WebDriver driver;
    // Hàm thay đổi ngôn ngữ hiển thị

    // Điều hướng các tab có trên thanh Nav menu
    public void clickToNavTabOnNewsfeed(String nameTab) {
        waitElementToClickAble(driver,NewsFeedPageIU.NAV_FEED_TAB, nameTab);
        clickToElement(driver,NewsFeedPageIU.NAV_FEED_TAB, nameTab);
    }

    // Mở model Post Normal
    public void clickToNormalPostFunction() {
        waitElementToClickAble(driver, NormalPostUI.TITLE_POPUP);
        clickToElement(driver, NormalPostUI.TITLE_POPUP);
    }
    // Mở model Post Experience
    public void clickToExperiencePost() {
        waitElementToClickAble(driver, ExperiencePostUI.EXPERIENCE_MODE);
        clickToElement(driver, ExperiencePostUI.EXPERIENCE_MODE);
    }
    // Điều hướng tới trang personal-Timeline
    public void clickToUserHomePage() {
        waitElementToVisible(driver, HeaderPageUI.PERSONAL_URL_LINK);
        clickToElement(driver,HeaderPageUI.PERSONAL_URL_LINK);
    }

    public FirstUpdateInfo targetToFirstUpdateInfoPopup(){
        waitElementToVisible(driver, FirstUpdatePopUpUI.FORM_UPDATE_INFO);
        clickToElement(driver,FirstUpdatePopUpUI.FORM_UPDATE_INFO);
        return PageGenerator.createUpdateInfoPopup(driver);
    }

    public boolean checkViewModelExperiencePostIsDisplay(){
        return checkIsEnableElement(driver, NewsFeedPageIU.MODEL_VIEW_EXPERIENCE);
    }

    // Hàm kiểm tra đã login thành công hay chưa
    public boolean checkLoginSuccess() {
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
