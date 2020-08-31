package Newsfeed.Widget.SidebarLeft.MyAccount;

import CommonHelper.Function.AbstractPage;
import org.openqa.selenium.WebDriver;

public class WidgetMyAccount extends AbstractPage {
    WebDriver driver;
    public void clickToTabOnMyAccount(WebDriver driver, String nameTab) {
        waitElementToClickAble(driver, MyAccountUI.TAB_ITEM_MY_ACCOUNT, nameTab);
        clickToElement(driver,MyAccountUI.TAB_ITEM_MY_ACCOUNT, nameTab);
    }

    public void clickEditProfile() {
        waitElementToClickAble(driver, MyAccountUI.EDIT_PROFILE_BUTTON);
        clickToElement(driver, MyAccountUI.EDIT_PROFILE_BUTTON);
    }

    public String getFullNameOfUserLogin(){
        waitElementToVisible(driver,MyAccountUI.FULL_NAME);
        return getTextOfElement(driver,MyAccountUI.FULL_NAME);
    }
}
