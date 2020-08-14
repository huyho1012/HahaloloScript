package testcases.newsfeed.StartIngApp.LoginTestCase;

import actions.PageObject.Newsfeed.PageFeed.NewsFeedHomepage;
import actions.PageObject.Newsfeed.Starting.NewsFeedLogin;
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

public class Validation extends AbstractTest {
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
        log.info("Enter a Username");
        newFeedLoginPage.enterDataToTextBoxField(driver,"identity","");
        log.info("Enter a password");
        newFeedLoginPage.enterDataToTextBoxField(driver,"password","");
        log.info("Click Login button");
        newFeedLoginPage.clickToLoginButton();
        log.info("Verify error message");
        verifyEquals(newFeedLoginPage.getValidateErrMessage(driver,"identity"),"Tài khoản là bắt buộc.");
        verifyEquals(newFeedLoginPage.getValidateErrMessage(driver,"password"),"Mật khẩu là bắt buộc.");
    }
    @Test
    public void Login_TC02_Login_With_Blank_Username(){
        log.info("Enter a Username");
        newFeedLoginPage.enterDataToTextBoxField(driver,"identity","");
        log.info("Enter a password");
        newFeedLoginPage.enterDataToTextBoxField(driver,"password","123456");
        log.info("Click Login button");
        newFeedLoginPage.clickToLoginButton();
        log.info("Verify error message");
        verifyEquals(newFeedLoginPage.getValidateErrMessage(driver,"identity"),"Tài khoản là bắt buộc.");
    }
    @Test
    public void Login_TC03_Login_With_Password_Incorrect(){
        log.info("Enter a Username");
        newFeedLoginPage.enterDataToTextBoxField(driver,"identity","0936709449");
        log.info("Enter a password");
        newFeedLoginPage.enterDataToTextBoxField(driver,"password","123456");
        log.info("Click Login button");
        newFeedLoginPage.clickToLoginButton();
        log.info("Verify error message");
        verifyEquals(newFeedLoginPage.getValidateErrMessage(driver,"password"),"Tên tài khoản hoặc mật khẩu sai");
    }
    @Test
    public void Login_TC03_Login_With_Blank_Password(){
        log.info("Enter a Username");
        newFeedLoginPage.enterDataToTextBoxField(driver,"identity","0936709449");
        log.info("Enter a password");
        newFeedLoginPage.enterDataToTextBoxField(driver,"password","");
        log.info("Click Login button");
        newFeedLoginPage.clickToLoginButton();
        log.info("Verify error message");
        verifyEquals(newFeedLoginPage.getValidateErrMessage(driver,"password"),"Mật khẩu là bắt buộc.");
    }
    @Test
    public void Login_TC03_Login_With_Invalid_Email(){
        log.info("Enter a Username");
        newFeedLoginPage.enterDataToTextBoxField(driver,"identity","huyho1210@gmail.");
        log.info("Enter a password");
        newFeedLoginPage.enterDataToTextBoxField(driver,"password","123456");
        log.info("Click Login button");
        newFeedLoginPage.clickToLoginButton();
        log.info("Verify error message");
        verifyEquals(newFeedLoginPage.getValidateErrMessage(driver,"identity"),"Tài khoản không hợp lệ.");
    }
    @Test
    public void Login_TC03_Login_With_Invalid_Phone(){
        log.info("Enter a Username");
        newFeedLoginPage.enterDataToTextBoxField(driver,"identity","0123456");
        log.info("Enter a password");
        newFeedLoginPage.enterDataToTextBoxField(driver,"password","123456");
        log.info("Click Login button");
        newFeedLoginPage.clickToLoginButton();
        log.info("Verify error message");
        verifyEquals(newFeedLoginPage.getValidateErrMessage(driver,"identity"),"Tài khoản không hợp lệ.");
    }
    @Test
    public void TC04_Login_With_Password_Less_than_6_Chars(){
        log.info("Enter a Username");
        newFeedLoginPage.enterDataToTextBoxField(driver,"identity","balo_04@mailinator.com");
        log.info("Enter a password");
        newFeedLoginPage.enterDataToTextBoxField(driver,"password","12345");
        log.info("Click Login button");
        newFeedLoginPage.clickToLoginButton();
        log.info("Verify error message");
        verifyEquals(newFeedLoginPage.getValidateErrMessage(driver,"password"),"Giới hạn tối thiểu của Mật khẩu là 6 kí tự");
    }
    @Test
    public void TC05_Login_With_Password_More_than_129_Chars(){
        log.info("Enter a Username");
        newFeedLoginPage.enterDataToTextBoxField(driver,"identity","balo_04@mailinator.com");
        log.info("Enter a password");
        newFeedLoginPage.enterDataToTextBoxField(driver,"password",randomPassword(129));
        log.info("Click Login button");
        newFeedLoginPage.clickToLoginButton();
        log.info("Verify error message");
        verifyEquals(newFeedLoginPage.getValidateErrMessage(driver,"password"),"Giới hạn tối đa của Mật khẩu là 128 kí tự");
    }
    @Test
    public void Login_TC_Login_With_Valid_Email(){
        log.info("Enter a Username");
        newFeedLoginPage.enterDataToTextBoxField(driver,"identity","balo_04@mailinator.com");
        log.info("Enter a password");
        newFeedLoginPage.enterDataToTextBoxField(driver,"password","123456");
        log.info("Click Login button");
        newsFeedPage = newFeedLoginPage.clickToLoginButton();
        verifyTrue(newsFeedPage.checkLoginSuccess());
        log.info("Logout account");
        newsFeedPage.clickToSettingItem(driver,"ic-logout-c");
        newFeedLoginPage = PageGenerator.getLoginPage(driver);
        verifyTrue(newFeedLoginPage.checkNewsFeedLoginPageDisplay());
    }
    @Test
    public void Login_TC_Login_With_Valid_Phone(){
        log.info("Enter a Username");
        newFeedLoginPage.enterDataToTextBoxField(driver,"identity","0936709449");
        log.info("Enter a password");
        newFeedLoginPage.enterDataToTextBoxField(driver,"password","20b87bis");
        log.info("Click Login button");
        newsFeedPage = newFeedLoginPage.clickToLoginButton();
        verifyTrue(newsFeedPage.checkLoginSuccess());
        log.info("Logout account");
        newsFeedPage.clickToSettingItem(driver,"ic-logout-c");
        newFeedLoginPage = PageGenerator.getLoginPage(driver);
        verifyTrue(newFeedLoginPage.checkNewsFeedLoginPageDisplay());
    }
    @AfterTest
    public void closeBrowserAndDriver(){
        closeBrowserAndDriver(driver);
    }
}

