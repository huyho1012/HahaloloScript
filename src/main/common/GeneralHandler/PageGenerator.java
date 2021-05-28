package common.GeneralHandler;

import PageObject.Login_PageObject;
import PageObject.Newsfeed.Newsfeed_PageObject;
import PageObject.Register_PageObject;
import org.openqa.selenium.WebDriver;

public class PageGenerator {
    public static Login_PageObject createLoginNewsfeedPage(WebDriver driver) {
        return new Login_PageObject(driver);
    }

    public static Register_PageObject createRegisterForm(WebDriver driver) {
        return new Register_PageObject(driver);
    }

    public static Newsfeed_PageObject createNewsfeedPage(WebDriver driver) {
        return new Newsfeed_PageObject(driver);
    }
    // Khởi tạo Newsfeed Start App

}


