package Newsfeed.Common;

import CommonHelper.Function.PageGenerator;
import HeaderMain.HeaderMenu;
import HeaderMain.HeaderPageUI;
import Newsfeed.Common.UpdateInfo.FirstUpdateInfo;
import Newsfeed.Common.UpdateInfo.FirstUpdatePopUpUI;
import Newsfeed.Editor.ExperiencePost.ExperiencePostUI;
import Newsfeed.Editor.NormalPost.NormalPostUI;
import Newsfeed.TabFeed.NewsFeedPageIU;
import org.openqa.selenium.WebDriver;

public class FeedCommon extends HeaderMenu {
    WebDriver driver;
    // Hàm thay đổi ngôn ngữ hiển thị
    public void changeLanguageDisplay() {
        waitForPageLoading(driver);
        if(getTextOfElement(driver, NewsFeedPageIU.LANGUAGE_BUTTON)== "English"){
            clickToElement(driver,NewsFeedPageIU.LANGUAGE_BUTTON);
        }
    }
    // Điều hướng các tab có trên thanh Nav menu
    public void clickToNavTabOnNewsfeed(String nameTab) {
        waitElementToClickAble(driver,NewsFeedPageIU.NAV_FEED_TAB, nameTab);
        clickToElement(driver,NewsFeedPageIU.NAV_FEED_TAB, nameTab);
    }
    // Điều hướng các tab trong Widget My Account
    public void clickToTabOnMyAccount(WebDriver driver, String nameTab) {
        waitElementToClickAble(driver,NewsFeedPageIU.TAB_ITEM_MY_ACCOUNT, nameTab);
        clickToElement(driver,NewsFeedPageIU.TAB_ITEM_MY_ACCOUNT, nameTab);
    }
    // Thực hiện chức năng chỉnh sửa thông tin cá nhân
    public void clickEditProfile() {
        waitElementToClickAble(driver, NewsFeedPageIU.EDIT_PROFILE_BUTTON);
        clickToElement(driver, NewsFeedPageIU.EDIT_PROFILE_BUTTON);
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
