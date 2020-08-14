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

    public void clickFunctionOnHelping(WebDriver driver, String helperItem){
        selectItemInCustomDropdown(driver,HeaderPageUI.MENU_HELPER,HeaderPageUI.MENU_HELPER_ITEM,helperItem);
    }
    public void clickItemOnSettingMenu(WebDriver driver, String settingITem){
        selectItemInCustomDropdown(driver,HeaderPageUI.MENU_SETTING,HeaderPageUI.MENU_SETTING_ITEM,settingITem);
    }

    public void GoToNewsfeedHomePage(WebDriver driver){
        waitElementToVisible(driver,HeaderPageUI.HOMEPAGE_LINK);
        clickToElement(driver,HeaderPageUI.HOMEPAGE_LINK);
    }

    public WalletLoginPageObject goToWalletLoginPage(WebDriver driver){
        waitElementToVisible(driver,HeaderPageUI.WALLET_FUNCTION);
        clickToElement(driver,HeaderPageUI.WALLET_FUNCTION);
        return PageGenerator.createWalletLoginPage(driver);
    }

    public void clickToLogoHahalolo(WebDriver driver){
        waitElementToClickAble(driver,HeaderPageUI.LOGO_HAHALOLO);
        clickToElement(driver, HeaderPageUI.LOGO_HAHALOLO);
    }
    public PersonalTimelinePageObject clickToAvatarUser(WebDriver driver){
        waitElementToClickAble(driver,HeaderPageUI.AVATAR_USER);
        clickToElement(driver, HeaderPageUI.AVATAR_USER);
        return PageGenerator.getPersonalTimeLinePage(driver);
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
