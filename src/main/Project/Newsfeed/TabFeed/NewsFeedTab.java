package Newsfeed.TabFeed;

import Newsfeed.Common.FeedCommon;
import Newsfeed.HeaderMenu.HeaderPageUI;
import Newsfeed.Widget.SidebarLeft.MyAccount.MyAccountUI;
import Newsfeed.Widget.SidebarRight.Footer.Footer;
import Newsfeed.Widget.SidebarRight.Footer.FooterUI;
import org.openqa.selenium.WebDriver;

public class NewsFeedTab extends FeedCommon {

    WebDriver driver;
    public NewsFeedTab(WebDriver webDriver){
        driver = webDriver;
    }

    public String getFullNameDisplayOnMyAccount(WebDriver driver) {
        waitElementToVisible(driver, MyAccountUI.FULL_NAME);
        return getTextOfElement(driver,MyAccountUI.FULL_NAME);
    }

    public void changeLanguageDisplayToVietnamese() {
        waitForPageLoading(driver);
        if (getTextOfElement(driver, FooterUI.LANGUAGE_BUTTON) == "English") {
            clickToElement(driver, FooterUI.LANGUAGE_BUTTON);
        }
    }

    public void clickEditProfile() {
        waitElementToClickAble(driver,MyAccountUI.EDIT_PROFILE_BUTTON);
        clickToElement(driver,MyAccountUI.EDIT_PROFILE_BUTTON);
    }
    

    public void clickToItemOnFooter(WebDriver driver, String pageLink) {
        waitElementToClickAble(driver, FooterUI.FOOTER_ITEM,pageLink);
        clickToElement(driver, FooterUI.FOOTER_ITEM, pageLink);
    }

    public void clickToTabDisplayOnMyAccountWidget(WebDriver driver, String nameTab) {
        waitElementToClickAble(driver, MyAccountUI.TAB_ITEM_MY_ACCOUNT,nameTab);
        clickToElement(driver, MyAccountUI.TAB_ITEM_MY_ACCOUNT, nameTab);
    }
}
