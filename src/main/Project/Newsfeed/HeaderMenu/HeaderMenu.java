package Newsfeed.HeaderMenu;

import CommonHelper.Function.AbstractPage;
import org.openqa.selenium.WebDriver;

public class HeaderMenu extends AbstractPage {
    public void clickFunctionOnHelping(WebDriver driver,String pageLink){
        waitElementToClickAble(driver, HeaderPageUI.MENU_HELPER);
        clickToElement(driver, HeaderPageUI.MENU_HELPER);
        setTimeDelay(1);
        clickToElement(driver, HeaderPageUI.MENU_HELPER_ITEM, pageLink);
    }
    public void clickItemOnSettingMenu(WebDriver driver,String setFunction){
        waitElementToClickAble(driver, HeaderPageUI.MENU_SETTING);
        clickToElement(driver, HeaderPageUI.MENU_SETTING);
        setTimeDelay(1);
        clickToElement(driver, HeaderPageUI.MENU_SETTING_ITEM, setFunction);
    }

    public void goToNewsfeedHomePage(WebDriver driver){
        waitElementToVisible(driver,HeaderPageUI.HOMEPAGE_LINK);
        clickToElement(driver,HeaderPageUI.HOMEPAGE_LINK);
    }

    public void clickToUserHomePage(WebDriver driver) {
        waitElementToVisible(driver, HeaderPageUI.PERSONAL_URL_LINK);
        clickToElement(driver,HeaderPageUI.PERSONAL_URL_LINK);
    }

    public void goToWalletLoginPage(WebDriver driver){
        waitElementToVisible(driver,HeaderPageUI.WALLET_FUNCTION);
        clickToElement(driver,HeaderPageUI.WALLET_FUNCTION);
    }

    public void clickToLogoPage(WebDriver driver){
        waitElementToClickAble(driver,HeaderPageUI.LOGO_HALO);
        clickToElement(driver, HeaderPageUI.LOGO_HALO);
    }
    public void clickToAvatarUser(WebDriver driver){
        waitElementToClickAble(driver,HeaderPageUI.AVATAR_USER);
        clickToElement(driver, HeaderPageUI.AVATAR_USER);
    }
    public void enterKeyWordOnSearchMain(WebDriver driver,String keyWord){
        waitElementToVisible(driver,HeaderPageUI.MAIN_SEARCH_FIELD);
        sendKeyToElement(driver,HeaderPageUI.MAIN_SEARCH_FIELD,keyWord);
    }
    public void clickNotificationIcon(WebDriver driver){
        waitElementToClickAble(driver, HeaderPageUI.SYS_NOTIFICATION_FUNCTION);
        clickToElement(driver,HeaderPageUI.SYS_NOTIFICATION_FUNCTION);
    }
    public void clickCartIcon(WebDriver driver){
        waitElementToClickAble(driver, HeaderPageUI.CART_FUNCTION);
        clickToElement(driver,HeaderPageUI.CART_FUNCTION);
    }
    public void goToMessagePage(WebDriver driver){
        waitElementToClickAble(driver, HeaderPageUI.CART_FUNCTION);
        clickToElement(driver,HeaderPageUI.CART_FUNCTION);
        clickToElement(driver,HeaderPageUI.MESSAGE_LINK_FUNCTION);
    }
}
