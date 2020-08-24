package testcases.newsfeed.StartIngApp.LoginTestCase;

import CommonHelper.DriverBrowser.BrowserDriver;
import CommonHelper.DriverBrowser.DriverManager;
import CommonHelper.Function.AbstractTest;
import CommonHelper.Function.PageGenerator;
import CommonHelper.GlobalVariables;
import Newsfeed.HeaderMenu.HeaderMenu;

import Newsfeed.TabFeed.NewsFeedTab;
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
    NewsFeedTab newsFeedPage;
    @Parameters("browser")
    @BeforeClass
    public void preconditionMethod(String browserName){
        driverManager = BrowserDriver.getBrowser(browserName);
        driver = driverManager.getDriver(GlobalVariables.URL_NEWS_FEED_LOGIN);
        newFeedLoginPage = PageGenerator.createLoginNewsfeedPage(driver);
    }


    @Test
    public void TC03_Login_With_Blank_Info(){
        log.info("Enter a Username");
        newFeedLoginPage.enterDataOnDynamicTextField("identity","");
        log.info("Enter a password");
        newFeedLoginPage.enterDataOnDynamicTextField("password","");
        log.info("Click Login button");
        newFeedLoginPage.clickLoginButton();
        log.info("Verify error message");
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("identity"),"Tài khoản là bắt buộc.");
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("password"),"Mật khẩu là bắt buộc.");
    }
    @Test
    public void TC03_ValidateOfUsername(){
        log.info("Step 1 - Enter password");
        newFeedLoginPage.enterDataOnDynamicTextField("password","123456");

        log.info("Step 2.1 - Do not input username");
        newFeedLoginPage.enterDataOnDynamicTextField("identity","");
        log.info("Step 2.2 - Click Login button");
        newFeedLoginPage.clickLoginButton();
        log.info("Step 2.3 - Verify error message");
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("identity"),"Tài khoản là bắt buộc.");

        log.info("Step 3.1 - Enter invalid email");
        newFeedLoginPage.enterDataOnDynamicTextField("identity","huyho1210@gmail.");
        log.info("Step 3.2 - Click Login button");
        newFeedLoginPage.clickLoginButton();
        log.info("Step 3.3 -Verify error message");
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("identity"),"Tài khoản không hợp lệ.");

        log.info("Step 4.1 - Enter invalid phone");
        newFeedLoginPage.enterDataOnDynamicTextField("identity","0123456");
        log.info("Step 4.2 - Click Login button");
        newFeedLoginPage.clickLoginButton();
        log.info("Step 4.3 -Verify error message");
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("identity"),"Tài khoản không hợp lệ.");

        log.info("Step 5.1 - Enter phone is not existed on Hahalolo");
        newFeedLoginPage.enterDataOnDynamicTextField("identity","0123456888");
        log.info("Step 5.2 - Click Login button");
        newFeedLoginPage.clickLoginButton();
        log.info("Step 5.3 -Verify error message");
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("password"),"Tên tài khoản hoặc mật khẩu sai");

        log.info("Step 6.1 - Enter email is not existed on Hahalolo");
        newFeedLoginPage.enterDataOnDynamicTextField("identity","hairoman10101010@mailinator.com");
        log.info("Step 6.2 - Click Login button");
        newFeedLoginPage.clickLoginButton();
        log.info("Step 6.3 -Verify error message");
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("password"),"Tên tài khoản hoặc mật khẩu sai");

        log.info("Step 4.1 - Enter phone contains whitespace");
        newFeedLoginPage.enterDataOnDynamicTextField("identity","09367094 49");
        log.info("Step 4.2 - Click Login button");
        newFeedLoginPage.clickLoginButton();
        log.info("Step 4.3 -Verify error message");
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("identity"),"Tài khoản không hợp lệ.");

        log.info("Step 4.1 - Enter email contains whitespace");
        newFeedLoginPage.enterDataOnDynamicTextField("identity","ba lo04@mailinator.com");
        log.info("Step 4.2 - Click Login button");
        newFeedLoginPage.clickLoginButton();
        log.info("Step 4.3 -Verify error message");
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("identity"),"Tài khoản không hợp lệ.");
    }
    @Test
    public void TC03_ValidateOfPassword(){
        log.info("Step 1 - Enter a Username");
        newFeedLoginPage.enterDataOnDynamicTextField("identity","0936709449");
        log.info("Step 2 - Do not enter password");
        newFeedLoginPage.enterDataOnDynamicTextField("password","");
        log.info("Step 2.2 - Click Login button");
        newFeedLoginPage.clickLoginButton();
        log.info("Step 2.3 - Verify error message");
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("password"),"Mật khẩu là bắt buộc.");

        log.info("Step 3.1 - Enter password less than 6 chars");
        newFeedLoginPage.enterDataOnDynamicTextField("password","12345");
        log.info("Step 3.2 - Click Login button");
        newFeedLoginPage.clickLoginButton();
        log.info("Step 3.3 - Verify error message");
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("password"),"Giới hạn tối thiểu của Mật khẩu là 6 kí tự");

        log.info("Step 4.1 - Enter password less than 6 chars");
        newFeedLoginPage.enterDataOnDynamicTextField("password",randomPassword(129));
        log.info("Step 4.2 - Click Login button");
        newFeedLoginPage.clickLoginButton();
        log.info("Step 4.3 - Verify error message");
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("password"),"Giới hạn tối đa của Mật khẩu là 128 kí tự");

        log.info("Step 5.1 - Enter password contains HTML");
        newFeedLoginPage.enterDataOnDynamicTextField("password",GlobalVariables.HTML_CODE);
        log.info("Step 5.2 - Click Login button");
        newFeedLoginPage.clickLoginButton();
        log.info("Step 5.3 - Verify error message");

        log.info("Step 6.1 - Enter password contains Script");
        newFeedLoginPage.enterDataOnDynamicTextField("password",GlobalVariables.SCRIPT_CODE);
        log.info("Step 6.2 - Click Login button");
        newFeedLoginPage.clickLoginButton();
        log.info("Step 6.3 - Verify error message");

        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("password"),"Tên tài khoản hoặc mật khẩu sai");
        log.info("Step 7.1 - Enter password contains whitespace");
        newFeedLoginPage.enterDataOnDynamicTextField("password","1234 56");
        log.info("Step 7.2 - Click Login button");
        newFeedLoginPage.clickLoginButton();
        log.info("Step 7.3 - Verify error message");
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("password"),"Mật khẩu không chứa kí tự trắng.");
    }

    @Test
    public void TC04_Login_With_Valid_Email(){
        newFeedLoginPage.refreshPage(driver);
        log.info("Enter a Username");
        newFeedLoginPage.enterDataOnDynamicTextField("identity","balo_04@mailinator.com");
        log.info("Enter a password");
        newFeedLoginPage.enterDataOnDynamicTextField("password","123456");
        log.info("Click Login button");
        newFeedLoginPage.clickLoginButton();
        newsFeedPage = PageGenerator.getNewsFeedPage(driver);
//        newsFeedPage.changeLanguageDisplay();
        newsFeedPage.setTimeDelay(1);
        log.info("Logout account");
        newsFeedPage.clickItemOnSettingMenu(driver,"Đăng xuất");
        System.out.println("dc ko ta");
        newFeedLoginPage = PageGenerator.createLoginNewsfeedPage(driver);
        verifyTrue(newFeedLoginPage.checkLoginNewsfeedPageIsDisplay());
    }
    @Test
    public void TC05_Login_With_Valid_Phone(){
        log.info("Enter a Username");
        newFeedLoginPage.enterDataOnDynamicTextField("identity","0936709449");
        log.info("Enter a password");
        newFeedLoginPage.enterDataOnDynamicTextField("password","20b87bis");
        log.info("Click Login button");
        newFeedLoginPage.clickLoginButton();
        newsFeedPage = PageGenerator.getNewsFeedPage(driver);
//        newsFeedPage.changeLanguageDisplay();
        log.info("Logout account");
        newsFeedPage.setTimeDelay(1);
        newsFeedPage.clickItemOnSettingMenu(driver,"Đăng xuất");
        newFeedLoginPage = PageGenerator.createLoginNewsfeedPage(driver);
        verifyTrue(newFeedLoginPage.checkLoginNewsfeedPageIsDisplay());
    }
    @AfterTest
    public void closeBrowserAndDriver(){
        closeBrowserAndDriver(driver);
    }
}

