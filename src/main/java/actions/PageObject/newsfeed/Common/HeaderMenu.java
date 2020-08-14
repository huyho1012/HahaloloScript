package actions.PageObject.Newsfeed.Common;

import actions.PageObject.Wallet.WalletLoginPageObject;
import actions.PageObject.Business.Business.BusinessOverviewPageObject;
import actions.PageObject.Newsfeed.PersonalWall.Handnote.UserHandNotePageObject;
import actions.PageObject.Newsfeed.PersonalWall.TimeLine.PersonalTimelinePageObject;
import actions.PageObject.Newsfeed.Starting.NewsFeedLogin;
import actions.common.Function.AbstractPage;
import actions.common.Function.PageGenerator;
import interfaces.Newsfeed.Common.HeaderPageUI;
import org.openqa.selenium.WebDriver;

public class HeaderMenu extends AbstractPage {
    WebDriver driver;
//    public void clickToElementOnMenu(WebDriver driver, String menuItem) {
//        waitElementToClickAble(driver, HeaderPageUI.NEWS_FEED_MENU, menuItem);
//        clickToElement(driver, HeaderPageUI.NEWS_FEED_MENU, menuItem);
//        setTimeDelay(1);
//    }
    public void clickFunctionOnHelping(WebDriver driver, String helperItem){
        selectItemInCustomDropdown(driver,HeaderPageUI.MENU_HELPER,HeaderPageUI.MENU_HELPER_ITEM,helperItem);
    }
    public UserHandNotePageObject goToUserHandNotePage(WebDriver driver){
        selectItemInCustomDropdown(driver,HeaderPageUI.MENU_SETTING,HeaderPageUI.MENU_SETTING_ITEM,"Sổ tay");
        return PageGenerator.createUserHandnotePage(driver);
    }
    public BusinessOverviewPageObject gotoBusinessOverviewPage(WebDriver driver){
        selectItemInCustomDropdown(driver,HeaderPageUI.MENU_SETTING,HeaderPageUI.MENU_SETTING_ITEM,"Tài khoản kinh doanh");
        return PageGenerator.createBusinessOverviewPage(driver);
    }
    public UserAccountSettingPageObject gotoAccountSettingPage(WebDriver driver){
        selectItemInCustomDropdown(driver,HeaderPageUI.MENU_SETTING,HeaderPageUI.MENU_SETTING_ITEM,"Thiết lập tài khoản");
        return PageGenerator.createAccountSettingPage(driver);
    }
    public NewsFeedLogin logoutAccount(WebDriver driver){
        selectItemInCustomDropdown(driver,HeaderPageUI.MENU_SETTING,HeaderPageUI.MENU_SETTING_ITEM,"Đăng xuất");
        return PageGenerator.getLoginPage(driver);
    }

    public void GoToNewsfeedHomePage(){
        waitElementToVisible(driver,HeaderPageUI.HOMEPAGE_LINK);
        clickToElement(driver,HeaderPageUI.HOMEPAGE_LINK);
    }

    public WalletLoginPageObject goToWalletLoginPage(){
        waitElementToVisible(driver,HeaderPageUI.WALLET_FUNCTION);
        clickToElement(driver,HeaderPageUI.WALLET_FUNCTION);
        return PageGenerator.createWalletLoginPage(driver);
    }

    public void clickToLogoHahalolo(){
        waitElementToClickAble(driver,HeaderPageUI.LOGO_HAHALOLO);
        clickToElement(driver, HeaderPageUI.LOGO_HAHALOLO);
    }
    public PersonalTimelinePageObject clickToAvatarUser(WebDriver driver){
        waitElementToClickAble(driver,HeaderPageUI.AVATAR_USER);
        clickToElement(driver, HeaderPageUI.AVATAR_USER);
        return PageGenerator.getPersonalTimeLinePage(driver);
    }
    public void enterKeyWordOnSearchMain(String keyWord){
        waitElementToVisible(driver,HeaderPageUI.MAIN_SEARCH_FIELD);
        sendKeyToElement(driver,HeaderPageUI.MAIN_SEARCH_FIELD,keyWord);
    }
    public void clickNotificationIcon(){
        waitElementToClickAble(driver, HeaderPageUI.SYS_NOTIFICATION_FUNCTION);
        clickToElement(driver,HeaderPageUI.SYS_NOTIFICATION_FUNCTION);
    }
    public void clickCartIcon(){
        waitElementToClickAble(driver, HeaderPageUI.CART_FUNCTION);
        clickToElement(driver,HeaderPageUI.CART_FUNCTION);
    }
    public void goToMessagePage(){
        waitElementToClickAble(driver, HeaderPageUI.CART_FUNCTION);
        clickToElement(driver,HeaderPageUI.CART_FUNCTION);
        clickToElement(driver,HeaderPageUI.MESSAGE_LINK_FUNCTION);
    }
}
