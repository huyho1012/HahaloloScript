package Newsfeed.TabFeed;

import Newsfeed.Common.FeedCommon;
import Newsfeed.Widget.SidebarLeft.MyAccount.MyAccountUI;
import Newsfeed.Widget.SidebarRight.Footer.Footer;
import Newsfeed.Widget.SidebarRight.Footer.FooterUI;
import org.openqa.selenium.WebDriver;

public class NewsFeedTab extends FeedCommon {

    WebDriver driver;
    public NewsFeedTab(WebDriver webDriver){
        driver = webDriver;
    }

    public String getFullNameDisplayOnMyAccount() {
        waitElementToVisible(driver, MyAccountUI.FULL_NAME);
        return getTextOfElement(driver,MyAccountUI.FULL_NAME);
    }

    public void changeLanguageDisplayToVietnamese() {
        waitForPageLoading(driver);
        if (getTextOfElement(driver, FooterUI.LANGUAGE_BUTTON) == "English") {
            clickToElement(driver, FooterUI.LANGUAGE_BUTTON);
        }
    }
}
