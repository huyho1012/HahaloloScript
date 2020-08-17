package testcases.newsfeed.StartIngApp.LoginTestCase;

import CommonHelper.DriverBrowser.BrowserDriver;
import CommonHelper.DriverBrowser.DriverManager;
import CommonHelper.Function.AbstractTest;
import CommonHelper.Function.PageGenerator;
import CommonHelper.GlobalVariables;
import HeaderMain.HeaderMenu;

import Newsfeed.TabFeed.NewsFeedTabPageObject;
import StartingApp.Login.LoginNewsfeed;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Validation extends AbstractTest {
    WebDriver driver;
    DriverManager driverManager;
    // Khai báo pageObject
    LoginNewsfeed newFeedLoginPage;
    NewsFeedTabPageObject newsFeedPage;
    HeaderMenu headerMenu;
    @Parameters("browser")
    @BeforeClass
    public void preconditionMethod(String browserName){
        driverManager = BrowserDriver.getBrowser(browserName);
        driver = driverManager.getDriver(GlobalVariables.URL_NEWS_FEED_LOGIN);
        newFeedLoginPage = PageGenerator.createLoginNewsfeedPage(driver);
    }
    @Test
    public void Login_TC01_Login_With_Blank_Info(){
        log.info("Enter a Username");
        newFeedLoginPage.enterUsernameToLogin("");
        log.info("Enter a password");
        newFeedLoginPage.enterPasswordToLogin("");
        log.info("Click Login button");
        newFeedLoginPage.clickLoginButton();
        log.info("Verify error message");
        verifyEquals(newFeedLoginPage.getErrorMessageOfUsername(),"Tài khoản là bắt buộc.");
        verifyEquals(newFeedLoginPage.getErrorMessageOfPassword(),"Mật khẩu là bắt buộc.");
    }
    @Test
    public void Login_TC02_Login_With_Blank_Username(){
        log.info("Enter a Username");
        newFeedLoginPage.enterUsernameToLogin("");
        log.info("Enter a password");
        newFeedLoginPage.enterPasswordToLogin("123456");
        log.info("Click Login button");
        newFeedLoginPage.clickLoginButton();
        log.info("Verify error message");
        verifyEquals(newFeedLoginPage.getErrorMessageOfUsername(),"Tài khoản là bắt buộc.");
    }
    @Test
    public void Login_TC03_Login_With_Password_Incorrect(){
        log.info("Enter a Username");
        newFeedLoginPage.enterUsernameToLogin("0936709449");
        log.info("Enter a password");
        newFeedLoginPage.enterPasswordToLogin("123456");
        log.info("Click Login button");
        newFeedLoginPage.clickLoginButton();
        log.info("Verify error message");
        verifyEquals(newFeedLoginPage.getErrorMessageOfPassword(),"Tên tài khoản hoặc mật khẩu sai");
    }
    @Test
    public void Login_TC03_Login_With_Blank_Password(){
        log.info("Enter a Username");
        newFeedLoginPage.enterUsernameToLogin("0936709449");
        log.info("Enter a password");
        newFeedLoginPage.enterPasswordToLogin("");
        log.info("Click Login button");
        newFeedLoginPage.clickLoginButton();
        log.info("Verify error message");
        verifyEquals(newFeedLoginPage.getErrorMessageOfPassword(),"Mật khẩu là bắt buộc.");
    }
    @Test
    public void Login_TC03_Login_With_Invalid_Email(){
        log.info("Enter a Username");
        newFeedLoginPage.enterUsernameToLogin("huyho1210@gmail.");
        log.info("Enter a password");
        newFeedLoginPage.enterPasswordToLogin("123456");
        log.info("Click Login button");
        newFeedLoginPage.clickLoginButton();
        log.info("Verify error message");
        verifyEquals(newFeedLoginPage.getErrorMessageOfUsername(),"Tài khoản không hợp lệ.");
    }
    @Test
    public void Login_TC03_Login_With_Invalid_Phone(){
        log.info("Enter a Username");
        newFeedLoginPage.enterUsernameToLogin("0123456");
        log.info("Enter a password");
        newFeedLoginPage.enterPasswordToLogin("123456");
        log.info("Click Login button");
        newFeedLoginPage.clickLoginButton();
        log.info("Verify error message");
        verifyEquals(newFeedLoginPage.getErrorMessageOfUsername(),"Tài khoản không hợp lệ.");
    }
    @Test
    public void TC04_Login_With_Password_Less_than_6_Chars(){
        log.info("Enter a Username");
        newFeedLoginPage.enterUsernameToLogin("balo_04@mailinator.com");
        log.info("Enter a password");
        newFeedLoginPage.enterPasswordToLogin("12345");
        log.info("Click Login button");
        newFeedLoginPage.clickLoginButton();
        log.info("Verify error message");
        verifyEquals(newFeedLoginPage.getErrorMessageOfPassword(),"Giới hạn tối thiểu của Mật khẩu là 6 kí tự");
    }
    @Test
    public void TC05_Login_With_Password_More_than_129_Chars(){
        log.info("Enter a Username");
        newFeedLoginPage.enterUsernameToLogin("balo_04@mailinator.com");
        log.info("Enter a password");
        newFeedLoginPage.enterPasswordToLogin(randomPassword(129));
        log.info("Click Login button");
        newFeedLoginPage.clickLoginButton();
        log.info("Verify error message");
        verifyEquals(newFeedLoginPage.getErrorMessageOfPassword(),"Giới hạn tối đa của Mật khẩu là 128 kí tự");
    }
    @Test
    public void Login_TC_Login_With_Valid_Email(){
        log.info("Enter a Username");
        newFeedLoginPage.enterUsernameToLogin("balo_04@mailinator.com");
        log.info("Enter a password");
        newFeedLoginPage.enterPasswordToLogin("123456");
        log.info("Click Login button");
        newFeedLoginPage.clickLoginButton();
        newsFeedPage = PageGenerator.getNewsFeedPage(driver);
        verifyTrue(newsFeedPage.checkLoginSuccess());
        log.info("Logout account");
        headerMenu.clickItemOnSettingMenu(driver,"Đăng xuất");
        newFeedLoginPage = PageGenerator.createLoginNewsfeedPage(driver);
        verifyTrue(newFeedLoginPage.checkLoginNewsfeedPageIsDisplay());
    }
    @Test
    public void Login_TC_Login_With_Valid_Phone(){
        log.info("Enter a Username");
        newFeedLoginPage.enterUsernameToLogin("0936709449");
        log.info("Enter a password");
        newFeedLoginPage.enterPasswordToLogin("20b87bis");
        log.info("Click Login button");
        newFeedLoginPage.clickLoginButton();
        newsFeedPage = PageGenerator.getNewsFeedPage(driver);
        verifyTrue(newsFeedPage.checkLoginSuccess());
        log.info("Logout account");
        headerMenu.clickItemOnSettingMenu(driver,"Đăng xuất");
        newFeedLoginPage = PageGenerator.createLoginNewsfeedPage(driver);
        verifyTrue(newFeedLoginPage.checkLoginNewsfeedPageIsDisplay());
    }
    @AfterTest
    public void closeBrowserAndDriver(){
        closeBrowserAndDriver(driver);
    }
}

