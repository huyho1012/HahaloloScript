package actions.PageObject.newsfeed.PageFeed;

import actions.PageObject.newsfeed.Common.HeaderMenu;
import actions.PageObject.newsfeed.PageFeed.PostFunction.EditorFunction;
import actions.PageObject.newsfeed.PersonalWall.PersonalTimelinePageObject;
import actions.common.Function.PageGenerator;
import interfaces.Newsfeed.Common.HeaderPageUI;
import interfaces.Newsfeed.Common.sidebarRightUI;
import interfaces.Newsfeed.PageFeed.NewsFeedPageIU;
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

    public EditorFunction clickToNormalPostFunction() {
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
        driver.switchTo().alert();
        setTimeDelay(1);
        selectItemInCustomDropdown(driver,NewsFeedPageIU.SELECTED_DAY_DROP_DOWN,NewsFeedPageIU.SELECTED_DAY_ITEM,dayItem);
        setTimeDelay(1);
        selectItemInCustomDropdown(driver,NewsFeedPageIU.SELECTED_MONTH_DROP_DOWN,NewsFeedPageIU.SELECTED_MONTH_ITEM,monthItem);
        setTimeDelay(1);
        selectItemInCustomDropdown(driver,NewsFeedPageIU.SELECTED_YEAR_DROP_DOWN,NewsFeedPageIU.SELECTED_YEAR_ITEM,yearItem);
    }

    public void updateGender() {
    }
    public void updateCountry() {
    }

    public void clickUpdateButton() {
    }
}
