package actions.PageObject.Newsfeed.PageFeed;

import actions.PageObject.Newsfeed.Common.HeaderMenu;
import actions.PageObject.Newsfeed.PageFeed.PostFunction.NormalPostEditor;
import actions.PageObject.Newsfeed.PersonalWall.About.OverviewPageObject;
import actions.PageObject.Newsfeed.PersonalWall.TimeLine.PersonalTimelinePageObject;
import actions.common.Function.PageGenerator;
import interfaces.Newsfeed.Common.HeaderPageUI;
import interfaces.Newsfeed.Common.sidebarLeftUI;
import interfaces.Newsfeed.Common.sidebarRightUI;
import interfaces.Newsfeed.TabFeed.NewsFeedPageIU;
import org.openqa.selenium.WebDriver;

public class NewsFeedHomepage extends HeaderMenu {
    WebDriver driver;
    public NewsFeedHomepage(WebDriver webDriver){
        driver = webDriver;
    }

    // Hàm thay đổi ngôn ngữ hiển thị
    public void changeLanguageDisplay() {
        waitForPageLoading(driver);
        if(!checkIsDisplayedElement(driver, sidebarRightUI.VI_LANGUAGE_BUTTON)){
            clickToElement(driver,sidebarRightUI.VI_LANGUAGE_BUTTON);
        } else if(checkIsDisplayedElement(driver,sidebarRightUI.ENG_LANGUAGE_BUTTON)){
            clickToElement(driver,sidebarRightUI.VI_LANGUAGE_BUTTON);
        }
    }

    // Hàm kiểm tra đang ở tab Newsfeed
    public boolean checkNewsFeedTabSelected(){
        waitElementToVisible(driver, NewsFeedPageIU.NORMAL_POST_FUNCTION);
        return checkIsDisplayedElement(driver, NewsFeedPageIU.NORMAL_POST_FUNCTION);
    }

    // Hàm kiểm tra đã login thành công hay chưa
    public boolean checkLoginSuccess() {
        waitElementToVisible(driver, HeaderPageUI.CART_FUNCTION);
        return checkIsDisplayedElement(driver, HeaderPageUI.CART_FUNCTION);
    }

    public NormalPostEditor clickToNormalPostFunction() {
        waitElementToClickAble(driver, NewsFeedPageIU.NORMAL_POST_FUNCTION);
        clickToElement(driver, NewsFeedPageIU.NORMAL_POST_FUNCTION);
        return PageGenerator.openNormalPostEditor(driver);
    }

    public PersonalTimelinePageObject clickToUserHomePage() {
        waitElementToVisible(driver, HeaderPageUI.PERSONAL_URL_LINK);
        clickToElement(driver,HeaderPageUI.PERSONAL_URL_LINK);
        return PageGenerator.getPersonalTimeLinePage(driver);
    }

    public void clickCancelUpdateNewInfo() {
        waitElementToClickAble(driver, NewsFeedPageIU.CANCEL_UPDATE_NEW_INFO_BUTTON);
        clickToElement(driver,NewsFeedPageIU.CANCEL_UPDATE_NEW_INFO_BUTTON);
    }

    public void updateBirthday(WebDriver driver, String dayItem, String monthItem, String yearItem) {
        selectItemInCustomDropdown(driver,NewsFeedPageIU.SELECTED_DAY_DROP_DOWN,NewsFeedPageIU.SELECTED_DAY_ITEM,dayItem);
        selectItemInCustomDropdown(driver,NewsFeedPageIU.SELECTED_MONTH_DROP_DOWN,NewsFeedPageIU.SELECTED_MONTH_ITEM,monthItem);
        selectItemInCustomDropdown(driver,NewsFeedPageIU.SELECTED_YEAR_DROP_DOWN,NewsFeedPageIU.SELECTED_YEAR_ITEM,yearItem);
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

    public OverviewPageObject clickEditProfile() {
        waitElementToClickAble(driver, sidebarLeftUI.EDIT_PROFILE_BUTTON);
        clickToElement(driver, sidebarLeftUI.EDIT_PROFILE_BUTTON);
        return PageGenerator.getPersonalOverviewTab(driver);
    }

    public void clickLike() {
        setTimeDelay(2);
        scrollToElement(driver,NewsFeedPageIU.React_Button);
        waitElementToClickAble(driver,NewsFeedPageIU.React_Button);
        clickToElement(driver,NewsFeedPageIU.React_Button);
    }

}
