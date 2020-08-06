package actions.PageObject.newsfeed.Common;

import actions.common.Function.AbstractPage;
import interfaces.Newsfeed.Common.HeaderPageUI;
import org.openqa.selenium.WebDriver;

public class HeaderMenu extends AbstractPage {
    public void clickToElementOnMenu(WebDriver driver, String menuItem) {
        waitElementToClickAble(driver, HeaderPageUI.NEWS_FEED_MENU, menuItem);
        clickToElement(driver, HeaderPageUI.NEWS_FEED_MENU, menuItem);
        setTimeDelay(1);
    }
    public void clickFunctionOnHelping(WebDriver driver, String itemFunction){
        setTimeDelay(1);
        waitElementToClickAble(driver,HeaderPageUI.HELPER_FUNCTION);
        clickToElement(driver,HeaderPageUI.HELPER_FUNCTION);
        clickToElement(driver,HeaderPageUI.HELPER_ITEM_FUNCTION,itemFunction);
    }
}
