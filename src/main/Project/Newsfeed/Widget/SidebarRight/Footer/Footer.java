package Newsfeed.Widget.SidebarRight.Footer;

import CommonHelper.Function.AbstractPage;
import Newsfeed.TabFeed.NewsFeedPageIU;
import org.openqa.selenium.WebDriver;

public class Footer extends AbstractPage {
    WebDriver driver;

    public void changeLanguageDisplayToVietnamese() {
        waitForPageLoading(driver);
        if (getTextOfElement(driver, FooterUI.LANGUAGE_BUTTON) == "English") {
            clickToElement(driver, FooterUI.LANGUAGE_BUTTON);
        }
    }
    public void changeLanguageDisplayToEng() {
        waitForPageLoading(driver);
        if (getTextOfElement(driver, FooterUI.LANGUAGE_BUTTON) == "English") {
            clickToElement(driver, FooterUI.LANGUAGE_BUTTON);
        }
    }
    public void redirectLinkOnFooterSideBarRight(String urlLink){
        waitElementToClickAble(driver, FooterUI.FOOTER_ITEM, urlLink);
        clickToElement(driver,FooterUI.FOOTER_ITEM,urlLink);
    }
}
