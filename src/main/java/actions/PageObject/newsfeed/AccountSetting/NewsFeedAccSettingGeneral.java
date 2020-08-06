package actions.PageObject.newsfeed.AccountSetting;

import actions.PageObject.newsfeed.Common.HeaderMenu;
import org.openqa.selenium.WebDriver;

public class NewsFeedAccSettingGeneral extends HeaderMenu {
    WebDriver driver;
    public NewsFeedAccSettingGeneral(WebDriver webDriver){
        driver = webDriver;
    }
}
