package testcases.newsfeed.StartIngApp.LoginTestCase;

import CommonHelper.DriverBrowser.BrowserDriver;
import CommonHelper.DriverBrowser.DriverManager;
import CommonHelper.Function.AbstractTest;
import CommonHelper.Function.PageGenerator;
import CommonHelper.GlobalVariables;

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

    String loginURL = GlobalVariables.URL_NEWS_FEED_LOGIN;
    String htmlCode = GlobalVariables.HTML_CODE;
    String scriptCode = GlobalVariables.SCRIPT_CODE;

    // Khai báo pageObject
    LoginNewsfeed newFeedLoginPage;
    NewsFeedTab newsFeedHomePage;

    @Parameters("browser")
    @BeforeClass
    public void preconditionMethod(String browserName){
        log.info("Precondition - Step 1 - Create browser driver");
        driverManager = BrowserDriver.getBrowser(browserName);

        log.info("Precondition - Step 2 - Open browser and go to Newsfeed login");
        driver = driverManager.getDriver(loginURL);
        newFeedLoginPage = PageGenerator.createLoginNewsfeedPage(driver);

        log.info("Precondition - Step 3 - Verify Newsfeed login is display");
        verifyTrue(newFeedLoginPage.checkLoginNewsfeedPageIsDisplay());
    }

    @Test
    public void TC03_Login_With_Blank_Info(){
        log.info("Step 1 - Enter username (Blank - No Input");
        newFeedLoginPage.enterUserNameToLogin(driver,"");

        log.info("Step 2 - Enter password (Blank - No Input)");
        newFeedLoginPage.enterPasswordToLogin(driver,"");

        log.info("Step 3 - Click Login button");
        newFeedLoginPage.clickLoginButton();

        log.info("Step 4 - Verify error message");
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("identity"),"Tài khoản là bắt buộc.");
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("password"),"Mật khẩu là bắt buộc.");
    }
    @Test
    public void TC03_ValidateOfUsername(){
        log.info("Step 1 - Enter password");
        newFeedLoginPage.enterPasswordToLogin(driver,"123456");

        log.info("Step 2 - Blank Username");
        newFeedLoginPage.enterUserNameToLogin(driver,"");
        newFeedLoginPage.clickLoginButton();
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("identity"),"Tài khoản là bắt buộc.");

        log.info("Step 3 - Invalid email(End with is dot");
        newFeedLoginPage.enterUserNameToLogin(driver,"huyho1210@gmail.");
        newFeedLoginPage.clickLoginButton();
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("identity"),"Tài khoản không hợp lệ.");

        log.info("Step 4 - Invalid email (Contain whitespace on first position");
        newFeedLoginPage.enterUserNameToLogin(driver," huyho1210@gmail.com");
        newFeedLoginPage.clickLoginButton();
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("identity"),"Tài khoản không hợp lệ.");

        log.info("Step 5 - Invalid email (Contain whitespace on last position");
        newFeedLoginPage.enterUserNameToLogin(driver,"huyho1210@gmail.com ");
        newFeedLoginPage.clickLoginButton();
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("identity"),"Tài khoản không hợp lệ.");

        log.info("Step 6 - Invalid email (Contain whitespace on middle position");
        newFeedLoginPage.enterUserNameToLogin(driver,"huyho 1210@gmail.com");
        newFeedLoginPage.clickLoginButton();
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("identity"),"Tài khoản không hợp lệ.");

        log.info("Step 7 - Invalid email (Contain special character");
        newFeedLoginPage.enterUserNameToLogin(driver,"huyh@1210@gmail.com");
        newFeedLoginPage.clickLoginButton();
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("identity"),"Tài khoản không hợp lệ.");

        log.info("Step 8 - Invalid phone (Less than 8 number chars ");
        newFeedLoginPage.enterUserNameToLogin(driver,"0123451");
        newFeedLoginPage.clickLoginButton();
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("identity"),"Tài khoản không hợp lệ.");

        log.info("Step 9 - Invalid phone (Greater than 20 number chars ");
        newFeedLoginPage.enterUserNameToLogin(driver,String.valueOf(randomNumber(21)));
        newFeedLoginPage.clickLoginButton();
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("identity"),"Tài khoản không hợp lệ.");

        log.info("Step 10 - Invalid phone (Contains phone Area with Character '+'");
        newFeedLoginPage.enterUserNameToLogin(driver,"+840936709449");
        newFeedLoginPage.clickLoginButton();
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("identity"),"Tài khoản không hợp lệ.");

        log.info("Step 11 - Not Existed account - Email address");
        newFeedLoginPage.enterUserNameToLogin(driver,"hai.rom.an10101010@mailinator.com");
        newFeedLoginPage.clickLoginButton();
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("password"),"Tên tài khoản hoặc mật khẩu sai");

        log.info("Step 12 - Not existed account - Phone");
        newFeedLoginPage.enterUserNameToLogin(driver,"01237897845646");
        newFeedLoginPage.clickLoginButton();
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("password"),"Tên tài khoản hoặc mật khẩu sai");

    }
    @Test
    public void TC03_ValidateOfPassword(){
        log.info("Step 1 - Enter a Username");
        newFeedLoginPage.enterUserNameToLogin(driver,"0936709449");

        log.info("Step 2 - Blank password");
        newFeedLoginPage.enterPasswordToLogin(driver,"");
        newFeedLoginPage.clickLoginButton();
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("password"),"Mật khẩu là bắt buộc.");

        log.info("Step 3 - Invalid Password (Less than 6 chars)");
        newFeedLoginPage.enterPasswordToLogin(driver,"12345");
        newFeedLoginPage.clickLoginButton();
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("password"),"Giới hạn tối thiểu của Mật khẩu là 6 kí tự");

        log.info("Step 4 - Invalid Password (More than 129 chars)");
        newFeedLoginPage.enterPasswordToLogin(driver, randomPassword(129));
        newFeedLoginPage.clickLoginButton();
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("password"),"Giới hạn tối đa của Mật khẩu là 128 kí tự");

        log.info("Step 5 - Invalid Password (Contains HTML Code)");
        newFeedLoginPage.enterPasswordToLogin(driver, htmlCode);
        newFeedLoginPage.clickLoginButton();
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("password"),"Mật khẩu không chứa kí tự trắng.");

        log.info("Step 6 - Invalid Password (Contains Script Code)");
        newFeedLoginPage.enterPasswordToLogin(driver,scriptCode);
        newFeedLoginPage.clickLoginButton();
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("password"),"Mật khẩu không chứa kí tự trắng.");

        log.info("Step 7 - Invalid Password (Contains white space)");
        newFeedLoginPage.enterPasswordToLogin(driver,"1234 56");
        newFeedLoginPage.clickLoginButton();
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("password"),"Mật khẩu không chứa kí tự trắng.");

        log.info("Step 8 - Invalid Password (Contains all white space)");
        newFeedLoginPage.enterPasswordToLogin(driver,"      ");
        newFeedLoginPage.clickLoginButton();
        verifyEquals(newFeedLoginPage.getErrorValidationOfTextField("password"),"Mật khẩu là bắt buộc.");
    }

    @Test
    public void TC04_Login_With_Valid_Email(){
        log.info("Step 1 - Enter username");
        newFeedLoginPage.enterUserNameToLogin(driver,"balo_04@mailinator.com");

        log.info("Step 2 - Enter password");
        newFeedLoginPage.enterPasswordToLogin(driver,"123456");

        log.info("Step 3 - Click Login button");
        newFeedLoginPage.clickLoginButton();
        newsFeedHomePage = PageGenerator.getNewsFeedPage(driver);

        log.info("Step 4 - Change system language to VI");
        newsFeedHomePage.changeLanguageDisplayToVietnamese();
        newsFeedHomePage.setTimeDelay(1);

        log.info("Step 5 - Logout account");
        newsFeedHomePage.clickItemOnSettingMenu(driver,"ic-logout-c");
        newFeedLoginPage = PageGenerator.createLoginNewsfeedPage(driver);

        log.info("Step 6 - Check Logout account success");
        verifyTrue(newFeedLoginPage.checkLoginNewsfeedPageIsDisplay());
    }

    @Test
    public void TC05_Login_With_Uppercase_Email(){
        log.info("Step 1 - Enter username");
        newFeedLoginPage.enterUserNameToLogin(driver,"BALO_04@mailinator.com");

        log.info("Step 2 - Enter password");
        newFeedLoginPage.enterPasswordToLogin(driver,"123456");

        log.info("Step 3 - Click Login button");
        newFeedLoginPage.clickLoginButton();
        newsFeedHomePage = PageGenerator.getNewsFeedPage(driver);

        log.info("Step 4 - Change system language to VI");
        newsFeedHomePage.changeLanguageDisplayToVietnamese();
        newsFeedHomePage.setTimeDelay(1);

        log.info("Step 5 - Logout account");
        newsFeedHomePage.clickItemOnSettingMenu(driver,"Đăng xuất");
        newFeedLoginPage = PageGenerator.createLoginNewsfeedPage(driver);

        log.info("Step 6 - Check Logout account success");
        verifyTrue(newFeedLoginPage.checkLoginNewsfeedPageIsDisplay());
    }
    @Test
    public void TC05_Login_With_Valid_Phone(){
        log.info("Step 1 - Enter username");
        newFeedLoginPage.enterUserNameToLogin(driver,"0936709449");

        log.info("Step 2 - Enter password");
        newFeedLoginPage.enterPasswordToLogin(driver,"20b87bis");

        log.info("Step 3 - Click Login button");
        newFeedLoginPage.clickLoginButton();
        newsFeedHomePage = PageGenerator.getNewsFeedPage(driver);

        log.info("Step 4 - Change system language to VI");
        newsFeedHomePage.changeLanguageDisplayToVietnamese();
        newsFeedHomePage.setTimeDelay(1);

        log.info("Step 5 - Logout account");
        newsFeedHomePage.clickItemOnSettingMenu(driver,"Đăng xuất");
        newFeedLoginPage = PageGenerator.createLoginNewsfeedPage(driver);

        log.info("Step 6 - Check Logout account success");
        verifyTrue(newFeedLoginPage.checkLoginNewsfeedPageIsDisplay());
    }
    @Test
    public void TC06_Login_With_Valid_Phone_CONTAIN_PHONECODE(){
        log.info("Step 1 - Enter username");
        newFeedLoginPage.enterUserNameToLogin(driver,"84936709449");

        log.info("Step 2 - Enter password");
        newFeedLoginPage.enterPasswordToLogin(driver,"20b87bis");

        log.info("Step 3 - Click Login button");
        newFeedLoginPage.clickLoginButton();
        newsFeedHomePage = PageGenerator.getNewsFeedPage(driver);

        log.info("Step 4 - Change system language to VI");
        newsFeedHomePage.changeLanguageDisplayToVietnamese();
        newsFeedHomePage.setTimeDelay(1);

        log.info("Step 5 - Logout account");
        newsFeedHomePage.clickItemOnSettingMenu(driver,"Đăng xuất");
        newFeedLoginPage = PageGenerator.createLoginNewsfeedPage(driver);

        log.info("Step 6 - Check Logout account success");
        verifyTrue(newFeedLoginPage.checkLoginNewsfeedPageIsDisplay());
    }
    @AfterTest
    public void closeBrowserAndDriver(){
        closeBrowserAndDriver(driver);
    }
}

