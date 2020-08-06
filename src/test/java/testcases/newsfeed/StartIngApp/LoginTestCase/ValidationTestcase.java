package testcases.newsfeed.StartIngApp.LoginTestCase;

import PageObject.newsfeed.PageFeed.NewsfeedTabPageObject;
import PageObject.newsfeed.Starting.NewsFeed_Login;
import common.DriverBrowser.BrowserDriver;
import common.DriverBrowser.DriverManager;
import common.Function.AbstractTest;
import common.Function.PageGenerator;
import common.Global_Constant;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ValidationTestcase extends AbstractTest {
    WebDriver driver;
    NewsFeed_Login newFeedLoginPage;
    DriverManager driverManager;
    NewsfeedTabPageObject newsFeedPage;
    @Parameters("browser")
    @BeforeClass
    public void preconditionMethod(String browserName){
        driverManager = BrowserDriver.getBrowser(browserName);
        driver = driverManager.getDriver(Global_Constant.URL_NEWS_FEED_LOGIN);
        newFeedLoginPage = PageGenerator.getLoginPage(driver);
    }
    @Test
    public void Login_TC01_Login_With_Blank_Info(){
        newFeedLoginPage.enterUsernameToLogin("");
        newFeedLoginPage.enterPasswordToLogin("");
        newFeedLoginPage.clickToLoginButton();
        verifyEquals(newFeedLoginPage.getValidateErrUsernameLogin(),"Tài khoản là bắt buộc.");
        verifyEquals(newFeedLoginPage.getValidateErrPassLogin(),"Mật khẩu là bắt buộc.");
    }
    @Test
    public void Login_TC02_Login_With_Blank_Username(){
        newFeedLoginPage.enterUsernameToLogin("");
        newFeedLoginPage.enterPasswordToLogin("123456");
        newFeedLoginPage.clickToLoginButton();
        verifyEquals(newFeedLoginPage.getValidateErrUsernameLogin(),"Tài khoản là bắt buộc.");
    }
    @Test
    public void Login_TC03_Login_With_Blank_Password(){
        newFeedLoginPage.enterUsernameToLogin("0936709449");
        newFeedLoginPage.enterPasswordToLogin("");
        newFeedLoginPage.clickToLoginButton();
        verifyEquals(newFeedLoginPage.getValidateErrPassLogin(),"Mật khẩu là bắt buộc.");
    }
    @Test
    public void Login_TC03_Login_With_Invalid_Email(){
        newFeedLoginPage.enterUsernameToLogin("huyho1210@gmail.");
        newFeedLoginPage.enterPasswordToLogin("123456");
        newFeedLoginPage.clickToLoginButton();
        verifyEquals(newFeedLoginPage.getValidateErrUsernameLogin(),"Tài khoản không hợp lệ.");
    }
    @Test
    public void Login_TC03_Login_With_Invalid_Phone(){
        newFeedLoginPage.enterUsernameToLogin("0123456");
        newFeedLoginPage.enterPasswordToLogin("123456");
        newFeedLoginPage.clickToLoginButton();
        verifyEquals(newFeedLoginPage.getValidateErrUsernameLogin(),"Tài khoản không hợp lệ.");
    }

    @Test
    public void TC04_Login_With_Password_Less_than_6_Chars(){
        newFeedLoginPage.enterUsernameToLogin("balo_04@mailinator.com");
        newFeedLoginPage.enterPasswordToLogin("12345");
        newFeedLoginPage.clickToLoginButton();
        verifyEquals(newFeedLoginPage.getValidateErrPassLogin(),"Giới hạn tối thiểu của Mật khẩu là 6 kí tự");
    }

    @Test
    public void TC05_Login_With_Password_More_than_129_Chars(){
        newFeedLoginPage.enterUsernameToLogin("balo_04@mailinator.com");
        newFeedLoginPage.enterPasswordToLogin(randomPassword(129));
        newFeedLoginPage.clickToLoginButton();
        verifyEquals(newFeedLoginPage.getValidateErrPassLogin(),"Giới hạn tối đa của Mật khẩu là 128 kí tự");
    }

    @Test
    public void TC06_Login_With_Valid_Username(){
        newFeedLoginPage.enterUsernameToLogin("balo_04@mailinator.com");
        newFeedLoginPage.enterPasswordToLogin("123456");
        newsFeedPage= newFeedLoginPage.clickToLoginButton();
        verifyTrue(newsFeedPage.checkLoginSuccess());
    }

    @Test
    public void Login_TC_Login_With_Valid_Email(){
        newFeedLoginPage.enterUsernameToLogin(Global_Constant.FEED_EMAIL_ACCOUNT);
        newFeedLoginPage.enterPasswordToLogin(Global_Constant.FEED_EMAIL_PASSWORD);
        newsFeedPage = newFeedLoginPage.clickToLoginButton();
        verifyTrue(newsFeedPage.checkLoginSuccess());
        newsFeedPage.clickToSettingItem(driver,"ic-logout-c");
    }
    @Test
    public void Login_TC_Login_With_Valid_Phone(){
        newFeedLoginPage.enterUsernameToLogin(Global_Constant.FEED_PHONE_ACCOUNT);
        newFeedLoginPage.enterPasswordToLogin(Global_Constant.FEED_PHONE_PASSWORD);
        newsFeedPage = newFeedLoginPage.clickToLoginButton();
        verifyTrue(newsFeedPage.checkLoginSuccess());
        newsFeedPage.clickToSettingItem(driver,"ic-logout-c");
    }
    @AfterTest
    public void closeBrowserAndDriver(){
        closeBrowserAndDriver(driver);
    }
}

