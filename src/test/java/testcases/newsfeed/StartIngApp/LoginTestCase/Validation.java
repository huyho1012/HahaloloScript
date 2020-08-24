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

        log.info("Step 2 - Blank Username");
        newFeedLoginPage.enterDataOnDynamicTextField("identity","");
        newFeedLoginPage.clickLoginButton();
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("identity"),"Tài khoản là bắt buộc.");

        log.info("Step 3 - Invalid email(End with is dot");
        newFeedLoginPage.enterDataOnDynamicTextField("identity","huyho1210@gmail.");
        newFeedLoginPage.clickLoginButton();
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("identity"),"Tài khoản không hợp lệ.");

        log.info("Step 4 - Invalid email (Contain whitespace on first position");
        newFeedLoginPage.enterDataOnDynamicTextField("identity"," huyho1210@gmail.com");
        newFeedLoginPage.clickLoginButton();
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("identity"),"Tài khoản không hợp lệ.");

        log.info("Step 5 - Invalid email (Contain whitespace on last position");
        newFeedLoginPage.enterDataOnDynamicTextField("identity","huyho1210@gmail.com ");
        newFeedLoginPage.clickLoginButton();
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("identity"),"Tài khoản không hợp lệ.");

        log.info("Step 6 - Invalid email (Contain whitespace on middle position");
        newFeedLoginPage.enterDataOnDynamicTextField("identity","huyho 1210@gmail.com");
        newFeedLoginPage.clickLoginButton();
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("identity"),"Tài khoản không hợp lệ.");

        log.info("Step 7 - Invalid email (Contain special character");
        newFeedLoginPage.enterDataOnDynamicTextField("identity","huyh@1210@gmail.com");
        newFeedLoginPage.clickLoginButton();
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("identity"),"Tài khoản không hợp lệ.");

        log.info("Step 8 - Invalid phone (Less than 8 number chars ");
        newFeedLoginPage.enterDataOnDynamicTextField("identity","0123451");
        newFeedLoginPage.clickLoginButton();
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("identity"),"Tài khoản không hợp lệ.");

        log.info("Step 9 - Invalid phone (Greater than 20 number chars ");
        newFeedLoginPage.enterDataOnDynamicTextField("identity",String.valueOf(randomNumber(21)));
        newFeedLoginPage.clickLoginButton();
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("identity"),"Tài khoản không hợp lệ.");

        log.info("Step 10 - Invalid phone (Contains phone Area with Character '+'");
        newFeedLoginPage.enterDataOnDynamicTextField("identity","+840936709449");
        newFeedLoginPage.clickLoginButton();
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("identity"),"Tài khoản không hợp lệ.");

        log.info("Step 11 - Not Existed account - Email address");
        newFeedLoginPage.enterDataOnDynamicTextField("identity","hai.rom.an10101010@mailinator.com");
        newFeedLoginPage.clickLoginButton();
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("password"),"Tên tài khoản hoặc mật khẩu sai");

        log.info("Step 12 - Not existed account - Phone");
        newFeedLoginPage.enterDataOnDynamicTextField("identity","01237897845646");
        newFeedLoginPage.clickLoginButton();
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("password"),"Tên tài khoản hoặc mật khẩu sai");

    }
    @Test
    public void TC03_ValidateOfPassword(){
        log.info("Step 1 - Enter a Username");
        newFeedLoginPage.enterDataOnDynamicTextField("identity","0936709449");

        log.info("Step 2 - Blank password");
        newFeedLoginPage.enterDataOnDynamicTextField("password","");
        newFeedLoginPage.clickLoginButton();
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("password"),"Mật khẩu là bắt buộc.");

        log.info("Step 3 - Invalid Password (Less than 6 chars)");
        newFeedLoginPage.enterDataOnDynamicTextField("password","12345");
        newFeedLoginPage.clickLoginButton();
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("password"),"Giới hạn tối thiểu của Mật khẩu là 6 kí tự");

        log.info("Step 4 - Invalid Password (More than 129 chars)");
        newFeedLoginPage.enterDataOnDynamicTextField("password",randomPassword(129));
        newFeedLoginPage.clickLoginButton();
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("password"),"Giới hạn tối đa của Mật khẩu là 128 kí tự");

        log.info("Step 5 - Invalid Password (Contains HTML Code)");
        newFeedLoginPage.enterDataOnDynamicTextField("password",GlobalVariables.HTML_CODE);
        newFeedLoginPage.clickLoginButton();
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("password"),"Mật khẩu không chứa kí tự trắng.");

        log.info("Step 6 - Invalid Password (Contains Script Code)");
        newFeedLoginPage.enterDataOnDynamicTextField("password",GlobalVariables.SCRIPT_CODE);
        newFeedLoginPage.clickLoginButton();
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("password"),"Mật khẩu không chứa kí tự trắng.");

        log.info("Step 7 - Invalid Password (Contains white space)");
        newFeedLoginPage.enterDataOnDynamicTextField("password","1234 56");
        newFeedLoginPage.clickLoginButton();
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("password"),"Mật khẩu không chứa kí tự trắng.");

        log.info("Step 8 - Invalid Password (Contains all white space)");
        newFeedLoginPage.enterDataOnDynamicTextField("password","      ");
        newFeedLoginPage.clickLoginButton();
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("password"),"Mật khẩu là bắt buộc.");
    }

    @Test
    public void TC04_Login_With_Valid_Email(){
        log.info("Step 1 - Enter username");
        newFeedLoginPage.enterDataOnDynamicTextField("identity","balo_04@mailinator.com");
        log.info("Step 2 - Enter password");
        newFeedLoginPage.enterDataOnDynamicTextField("password","123456");
        log.info("Step 3 - Click Login button");
        newFeedLoginPage.clickLoginButton();
        newsFeedPage = PageGenerator.getNewsFeedPage(driver);
        log.info("Step 4 - Change system language to VI");
        newsFeedPage.changeLanguageDisplayToVietnamese();
        newsFeedPage.setTimeDelay(1);
        log.info("Step 5 - Logout account");
        newsFeedPage.clickItemOnSettingMenu(driver,"Đăng xuất");
        newFeedLoginPage = PageGenerator.createLoginNewsfeedPage(driver);
        log.info("Step 5 - Check Logout account success");
        verifyTrue(newFeedLoginPage.checkLoginNewsfeedPageIsDisplay());
    }

    @Test
    public void TC05_Login_With_Uppercase_Email(){
        log.info("Step 1 - Enter username");
        newFeedLoginPage.enterDataOnDynamicTextField("identity","BALO_04@mailinator.com");

        log.info("Step 2 - Enter password");
        newFeedLoginPage.enterDataOnDynamicTextField("password","123456");

        log.info("Step 3 - Click Login button");
        newFeedLoginPage.clickLoginButton();
        newsFeedPage = PageGenerator.getNewsFeedPage(driver);

        log.info("Step 4 - Change system language to VI");
        newsFeedPage.changeLanguageDisplayToVietnamese();
        newsFeedPage.setTimeDelay(1);

        log.info("Step 5 - Logout account");
        newsFeedPage.clickItemOnSettingMenu(driver,"Đăng xuất");
        newFeedLoginPage = PageGenerator.createLoginNewsfeedPage(driver);

        log.info("Step 6 - Check Logout account success");
        verifyTrue(newFeedLoginPage.checkLoginNewsfeedPageIsDisplay());
    }
    @Test
    public void TC05_Login_With_Valid_Phone(){
        log.info("Step 1 - Enter username");
        newFeedLoginPage.enterDataOnDynamicTextField("identity","0936709449");

        log.info("Step 2 - Enter password");
        newFeedLoginPage.enterDataOnDynamicTextField("password","20b87bis");

        log.info("Step 3 - Click Login button");
        newFeedLoginPage.clickLoginButton();
        newsFeedPage = PageGenerator.getNewsFeedPage(driver);

        log.info("Step 4 - Change system language to VI");
        newsFeedPage.changeLanguageDisplayToVietnamese();
        newsFeedPage.setTimeDelay(1);

        log.info("Step 5 - Logout account");
        newsFeedPage.clickItemOnSettingMenu(driver,"Đăng xuất");
        newFeedLoginPage = PageGenerator.createLoginNewsfeedPage(driver);

        log.info("Step 6 - Check Logout account success");
        verifyTrue(newFeedLoginPage.checkLoginNewsfeedPageIsDisplay());
    }
    @Test
    public void TC06_Login_With_Valid_Phone_CONTAIN_PHONECODE(){
        log.info("Step 1 - Enter username");
        newFeedLoginPage.enterDataOnDynamicTextField("identity","84936709449");

        log.info("Step 2 - Enter password");
        newFeedLoginPage.enterDataOnDynamicTextField("password","20b87bis");

        log.info("Step 3 - Click Login button");
        newFeedLoginPage.clickLoginButton();
        newsFeedPage = PageGenerator.getNewsFeedPage(driver);

        log.info("Step 4 - Change system language to VI");
        newsFeedPage.changeLanguageDisplayToVietnamese();
        newsFeedPage.setTimeDelay(1);

        log.info("Step 5 - Logout account");
        newsFeedPage.clickItemOnSettingMenu(driver,"Đăng xuất");
        newFeedLoginPage = PageGenerator.createLoginNewsfeedPage(driver);

        log.info("Step 6 - Check Logout account success");
        verifyTrue(newFeedLoginPage.checkLoginNewsfeedPageIsDisplay());
    }
    @AfterTest
    public void closeBrowserAndDriver(){
        closeBrowserAndDriver(driver);
    }
}

