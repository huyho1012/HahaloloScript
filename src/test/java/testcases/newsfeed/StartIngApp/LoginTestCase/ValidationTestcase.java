package testcases.newsfeed.StartIngApp.LoginTestCase;

import actions.PageObject.newsfeed.PageFeed.NewsFeedHomepage;
import actions.PageObject.newsfeed.Starting.NewsFeedLogin;
import actions.common.DriverBrowser.BrowserDriver;
import actions.common.DriverBrowser.DriverManager;
import actions.common.Function.AbstractTest;
import actions.common.Function.PageGenerator;
import actions.common.GlobalVariables;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ValidationTestcase extends AbstractTest {
    WebDriver driver;
    DriverManager driverManager;
    // Khai báo pageObject
    NewsFeedLogin newFeedLoginPage;
    NewsFeedHomepage newsFeedPage;

    @Parameters("browser")
    @BeforeClass
    public void preconditionMethod(String browserName){
        driverManager = BrowserDriver.getBrowser(browserName);
        driver = driverManager.getDriver(GlobalVariables.URL_NEWS_FEED_LOGIN);
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
        newFeedLoginPage.enterUsernameToLogin(GlobalVariables.FEED_EMAIL_ACCOUNT);
        newFeedLoginPage.enterPasswordToLogin(GlobalVariables.FEED_EMAIL_PASSWORD);
        newsFeedPage = newFeedLoginPage.clickToLoginButton();
        verifyTrue(newsFeedPage.checkLoginSuccess());
        newsFeedPage.clickToSettingItem(driver,"ic-logout-c");
    }
    @Test
    public void Login_TC_Login_With_Valid_Phone(){
        newFeedLoginPage.enterUsernameToLogin(GlobalVariables.FEED_PHONE_ACCOUNT);
        newFeedLoginPage.enterPasswordToLogin(GlobalVariables.FEED_PHONE_PASSWORD);
        newsFeedPage = newFeedLoginPage.clickToLoginButton();
        verifyTrue(newsFeedPage.checkLoginSuccess());
        newsFeedPage.clickToSettingItem(driver,"ic-logout-c");
    }
    @AfterTest
    public void closeBrowserAndDriver(){
        closeBrowserAndDriver(driver);
    }
}

