package Newsfeed.TabFeed;

import HeaderMain.HeaderMenu;
import HeaderMain.HeaderPageUI;
import Newsfeed.Common.WidgetRight.sidebarRightUI;
import Newsfeed.Editor.ExperiencePost.ExperiencePostUI;
import Newsfeed.Editor.NormalPost.NormalPostUI;
import org.openqa.selenium.WebDriver;

public class NewsFeedTab extends HeaderMenu {
    WebDriver driver;
    public NewsFeedTab(WebDriver webDriver){
        driver = webDriver;
    }

    // Hàm thay đổi ngôn ngữ hiển thị
    public void changeLanguageDisplay() {
        waitForPageLoading(driver);
        if(getTextOfElement(driver,NewsFeedPageIU.LANGUAGE_BUTTON)== "English"){
            clickToElement(driver,NewsFeedPageIU.LANGUAGE_BUTTON);
        }
    }

    // Điều hướng các tab có trên thanh Nav menu
    public void clickToNavTabOnNewsfeed(WebDriver driver, String nameTab) {
        waitElementToClickAble(driver,NewsFeedPageIU.NAV_FEED_TAB, nameTab);
        clickToElement(driver,NewsFeedPageIU.NAV_FEED_TAB, nameTab);
    }

    // Điều hướng các tab trong Widget My Account

    public void clickToTabOnMyAccount(WebDriver driver, String nameTab) {
        waitElementToClickAble(driver,NewsFeedPageIU.TAB_ITEM_MY_ACCOUNT, nameTab);
        clickToElement(driver,NewsFeedPageIU.TAB_ITEM_MY_ACCOUNT, nameTab);
    }

    public void clickEditProfile() {
        waitElementToClickAble(driver, NewsFeedPageIU.EDIT_PROFILE_BUTTON);
        clickToElement(driver, NewsFeedPageIU.EDIT_PROFILE_BUTTON);
    }

    public void clickToNormalPostFunction() {
        waitElementToClickAble(driver, NormalPostUI.TITLE_POPUP);
        clickToElement(driver, NormalPostUI.TITLE_POPUP);
    }

    public void clickToExperiencePost() {
        waitElementToClickAble(driver, ExperiencePostUI.EXPERIENCE_MODE);
        clickToElement(driver, ExperiencePostUI.EXPERIENCE_MODE);
    }

    public void clickToUserHomePage() {
        waitElementToVisible(driver, HeaderPageUI.PERSONAL_URL_LINK);
        clickToElement(driver,HeaderPageUI.PERSONAL_URL_LINK);
    }

    public void clickCancelUpdateNewInfo() {
        waitElementToClickAble(driver, NewsFeedPageIU.CANCEL_UPDATE_NEW_INFO_BUTTON);
        clickToElement(driver,NewsFeedPageIU.CANCEL_UPDATE_NEW_INFO_BUTTON);
    }

    public void updateBirthday(WebDriver driver, String dayItem, String monthItem, String yearItem) {
        waitElementToClickAble(driver,NewsFeedPageIU.SELECTED_DATE_DROP_DOWN,"Ngày");
        clickToElement(driver, NewsFeedPageIU.SELECTED_DATE_DROP_DOWN,"Ngày");
        clickToElement(driver, NewsFeedPageIU.SELECTED_DATE_ITEM,"Ngày",dayItem);
        setTimeDelay(1);
        clickToElement(driver, NewsFeedPageIU.SELECTED_DATE_DROP_DOWN,"Tháng");
        clickToElement(driver, NewsFeedPageIU.SELECTED_DATE_ITEM,"Tháng",monthItem);
        setTimeDelay(1);
        clickToElement(driver, NewsFeedPageIU.SELECTED_DATE_DROP_DOWN,"Năm");
        clickToElement(driver, NewsFeedPageIU.SELECTED_DATE_ITEM,"Năm",yearItem);
    }

    public void updateGender(WebDriver driver , String genderValue) {
        waitElementToClickAble(driver,NewsFeedPageIU.GENDER_OPTION,genderValue);
        clickToElement(driver,NewsFeedPageIU.GENDER_OPTION,genderValue);
    }
    public void updateCountry(WebDriver driver, String countryItem) {
        selectItemInCustomDropdown(driver,NewsFeedPageIU.COUNTRY_DROPDOWN,NewsFeedPageIU.COUNTRY_ITEM,countryItem);
    }
    public void clickUpdateButton() {
        waitElementToClickAble(driver,NewsFeedPageIU.UPLOAD_BUTTON);
        clickToElement(driver,NewsFeedPageIU.UPLOAD_BUTTON);
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
