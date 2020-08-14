package testcases.newsfeed.StartIngApp.LoginTestCase;

import actions.PageObject.Censor.AccountManager.CensorAccountList;
import actions.PageObject.Censor.CensorHomePage;
import actions.PageObject.Censor.CensorLogin;
import actions.PageObject.Newsfeed.Common.HeaderMenu;
import actions.PageObject.Newsfeed.PageFeed.NewsFeedHomepage;
import actions.PageObject.Newsfeed.Starting.NewsFeedLogin;
import actions.PageObject.Newsfeed.Starting.NewsFeedVerifyAccount;
import actions.common.DriverBrowser.BrowserDriver;
import actions.common.DriverBrowser.DriverManager;
import actions.common.Function.AbstractTest;
import actions.common.Function.PageGenerator;
import actions.common.GlobalVariables;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class IntegrationTest extends AbstractTest {
    WebDriver driver;
    DriverManager driverManager;

    // Khai báo pageobject
    NewsFeedLogin loginPage;
    NewsFeedHomepage newsFeedPage;
    CensorLogin censorLoginPage;
    CensorHomePage censorHomePage;
    CensorAccountList censorAccountListPage;
    NewsFeedVerifyAccount verifyAccountPage;
    HeaderMenu headerMenu;

    // Data
    String passWord ="123456";
    String confirmPassword = "123456";
    String firstName = "Huy";
    String lastName = "Hò";
    String email = "tester.hahalolo" + randomEmail() + "@mailinator.com";

    @Parameters("browser")
    @BeforeTest
    public void openBrowser(String browserName){
        driverManager = BrowserDriver.getBrowser(browserName);
        driver = driverManager.getDriver(GlobalVariables.URL_NEWS_FEED_LOGIN);
        loginPage = PageGenerator.getLoginPage(driver);
    }
    @Test
    public void Login_TC01_Login_With_Blocked_Account_Email(){
        log.info("Step 1 - Register Account");

        log.info("Step 1.1 - Register Account - Enter First Name");
        loginPage.enterDataToTextBoxField(driver,"nv104",firstName);

        log.info("Step 1.2 - Register Account - Enter Last Name");
        loginPage.enterDataToTextBoxField(driver,"nv103",lastName);

        log.info("Step 1.3 - Register Account - Enter Email");
        loginPage.enterDataToTextBoxField(driver,"nv108",email);

        log.info("Step 1.4 - Register Account - Enter Password");
        loginPage.enterDataToTextBoxField(driver,"nv109",passWord);

        log.info("Step 1.5 - Register Account - Enter Confirm password");
        loginPage.enterDataToTextBoxField(driver,"repeatPassword",confirmPassword);

        log.info("Step 1.6 - Register Account - Click Register button");
        verifyAccountPage = loginPage.clickSignUpButton();

        log.info("Step 1.7 - Register Account - Check verification account by email display");
        verifyTrue(verifyAccountPage.checkTitlePageVerifyEmail());

        log.info("Step 1.8 - Register Account - Click Verify button");
        verifyAccountPage.inputVerifyDataOnField(verifyAccountPage.getVerificationAccountCode(email));
        newsFeedPage = verifyAccountPage.clickVerifyButton();

        log.info("Step 1.9 - Register Account - Check account verify successfully");
        verifyTrue(newsFeedPage.checkLoginSuccess());

        log.info("Step 2 - Logout account");
        newsFeedPage.setTimeDelay(3);

        log.info("Step 2.1 - Logout account - Cancel update personal information");
        newsFeedPage.clickCancelUpdateNewInfo();

        log.info("Step 2.2 - Logout account - Click logout button");
        headerMenu.clickItemOnSettingMenu(driver,"Đăng xuất");
        loginPage = PageGenerator.getLoginPage(driver);

        log.info("Step 2.3 - Logout account - Click logout button");
        verifyTrue(loginPage.checkLogoutSuccess());

        log.info("Step 3.1 - Block account - Login Censor - Go to Login page");
        censorLoginPage = loginPage.gotoCensorLoginPage();

        log.info("Step 3.2 - Block account - Login Censor - Enter Username");
        censorLoginPage.enterUsername(GlobalVariables.BACKEND_USER_NAME);

        log.info("Step 3.3 - Block account - Login Censor - Enter Password");
        censorLoginPage.enterPassword(GlobalVariables.BACKEND_PASSWORD);

        log.info("Step 3.4 - Block account - Login Censor - Enter Captcha - Delay");
        censorLoginPage.setTimeDelay(10);

        log.info("Step 3.5 - Block account - Login Censor - Click Login Button");
        censorHomePage = censorLoginPage.clickLoginButton();

        log.info("Step 3.5 - Block account - Login Censor - Check Login Censor successfully");
        verifyTrue(censorHomePage.checkLoginCensorSuccess());

        log.info("Step 3.6 - Block account - Censor Dashboard - Change language");
        censorHomePage.checkAndChangeLanguageToVI(driver);

        log.info("Step 3.7 - Block account - Censor Dashboard - Go to Account moderation");
        censorHomePage.clickToItemOnMenu(driver,"Người dùng");
        censorAccountListPage= PageGenerator.getAccountManagerList(driver);

        log.info("Step 3.8 - Block account - Account Moderation - Check Account moderation display successfully");
        verifyTrue(censorAccountListPage.checkAccountManagerPageIsDisplay());

        log.info("Step 3.9 - Block account - Account Moderation - Search Account");
        censorAccountListPage.searchAccount(driver,email);

        log.info("Step 3.10 - Block account - Account Moderation - Block Account");
        censorAccountListPage.clickToBlockAccount(driver,email,"Khóa tài khoản",GlobalVariables.BACKEND_PASSWORD);

        log.info("Step 3.11 - Block account - Account Moderation - Check Account is blocked successfully");
        verifyTrue(censorAccountListPage.checkAccountIsBlockedSuccessfully(driver,email,"Đã bị khóa"));

        log.info("Step 3.12 - Block account - Account Moderation - Logout censor project");
        censorLoginPage= censorAccountListPage.clickLogoutButton();

        verifyTrue(censorLoginPage.checkLogoutSuccess());

        log.info("Step 4.1 - Login - Login with blocked account - Go to NewsFeed Login");
        censorLoginPage.openNewWindow(driver,GlobalVariables.URL_NEWS_FEED_LOGIN);
        loginPage = PageGenerator.getLoginPage(driver);

        log.info("Step 4.2 - Login - Login with blocked account - Enter a Username");
        loginPage.enterDataToTextBoxField(driver,"identity",email);

        log.info("Step 4.3 - Login - Login with blocked account - Enter a password");
        loginPage.enterDataToTextBoxField(driver,"password",passWord);

        log.info("Step 4.4 - Login - Login with blocked account - Click Login button");
        loginPage.clickToLoginButton();

        log.info("Step 4.5 - Login - Login with blocked account - Check message verification");
        verifyEquals(loginPage.getValidateErrMessage(driver,"password"),"Tên tài khoản hoặc mật khẩu sai");
    }

    @AfterTest
    public void closeBrowserAndDriver(){
        closeBrowserAndDriver(driver);
    }
}



