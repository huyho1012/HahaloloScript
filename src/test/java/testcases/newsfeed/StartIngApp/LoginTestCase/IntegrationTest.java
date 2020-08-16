package testcases.newsfeed.StartIngApp.LoginTestCase;


import Censor.AccountManager.CensorAccountList;
import Censor.Dashboard.CensorDashboardPageObject;
import CommonHelper.DriverBrowser.BrowserDriver;
import CommonHelper.DriverBrowser.DriverManager;
import CommonHelper.Function.AbstractTest;
import CommonHelper.Function.PageGenerator;
import CommonHelper.GlobalVariables;
import HeaderMain.HeaderMenu;
import Newsfeed.TabFeed.NewsFeedTabPageObject;
import StartingApp.Login.LoginCensor;
import StartingApp.Login.LoginNewsfeed;
import StartingApp.Register.RegisterAccount;
import StartingApp.Register.VerifyAccountPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class IntegrationTest extends AbstractTest {
    WebDriver driver;
    DriverManager driverManager;

    // Khai báo pageobject

    RegisterAccount signUpPage;
    NewsFeedTabPageObject newsFeedPage;
    LoginCensor censorLoginPage;
    CensorDashboardPageObject censorHomePage;
    CensorAccountList censorAccountListPage;
    VerifyAccountPageObject verifyAccountPage;
    HeaderMenu headerMenu;
    LoginNewsfeed loginNewsFeedPage;

    // Data
    String passWord ="123456";
    String confirmPassword = "123456";
    String firstName = "Huy";
    String lastName = "Hò";
    String email = "tester.hahalolo" + randomEmail() + "@mailinator.com";

    @Parameters("browser")
    @BeforeTest
    public void openBrowser(String browserName){
        log.info("Precondition - Step 1 - Create driver browser");
        driverManager = BrowserDriver.getBrowser(browserName);
        log.info("Precondition - Step 2 - Open Newsfeed Login");
        driver = driverManager.getDriver(GlobalVariables.URL_NEWS_FEED_LOGIN);
        loginNewsFeedPage = PageGenerator.createLoginNewsfeedPage(driver);
    }
    @Test
    public void Login_TC01_Login_With_Blocked_Account_Email(){
        log.info("Step 1 - Register Account");
        log.info("Step 1.1 - Enter First Name");
        loginNewsFeedPage.enterFirstNameForRegister(firstName);
        log.info("Step 1.2 -  Enter Last Name");
        loginNewsFeedPage.enterLastNameForRegister(lastName);
        log.info("Step 1.3 - Enter Email");
        loginNewsFeedPage.enterNewAccountForRegister(email);
        log.info("Step 1.4 - Enter Password");
        loginNewsFeedPage.enterPasswordForRegister(passWord);
        log.info("Step 1.5 - Enter Confirm password");
        loginNewsFeedPage.enterConfirmPasswordForRegister(confirmPassword);
        log.info("Step 1.6 - Click Register button");
        loginNewsFeedPage.clickSignUpButton();
        verifyAccountPage = PageGenerator.createVerifyAccountPage(driver);
        log.info("Step 1.7 - Check verification page is displayed");
        verifyTrue(verifyAccountPage.checkTitlePageVerifyEmail());
        log.info("Step 1.8 - Enter a verify code");
        verifyAccountPage.inputVerifyDataOnField(verifyAccountPage.copyVerifyCodeOnMail(email));
        log.info("Step 1.9 - Click verify account");
        verifyAccountPage.clickVerifyButton();
        newsFeedPage = PageGenerator.createNewsfeedTab(driver);
        verifyTrue(newsFeedPage.checkLoginSuccess());
        log.info("Step 2 - Logout account");
        log.info("Step 2.1 - Wait page loading success");
        newsFeedPage.setTimeDelay(3);
        log.info("Step 2.1 - Cancel Update Info");
        newsFeedPage.clickCancelUpdateNewInfo();
        log.info("Step 2.2 - Click logout button");
        headerMenu.clickItemOnSettingMenu(driver,"Đăng xuất");
        loginNewsFeedPage = PageGenerator.createLoginNewsfeedPage(driver);
        log.info("Step 2.3 - Check Logout success");
        verifyTrue(loginNewsFeedPage.checkLoginNewsfeedPageIsDisplay());
        log.info("Step 2 - Block account");
        log.info("Step 3.1 - Go to Censor Login page");
        loginNewsFeedPage.openNewWindow(driver,GlobalVariables.URL_CENSOR_LINK);
        censorLoginPage = PageGenerator.getCensorLoginPage(driver);
        log.info("Step 3.2 - Enter Admin Username");
        censorLoginPage.enterUsername(GlobalVariables.BACKEND_USER_NAME);
        log.info("Step 3.3 - Enter Password");
        censorLoginPage.enterPassword(GlobalVariables.BACKEND_PASSWORD);
        log.info("Step 3.4 - Enter Captcha code - Delay");
        censorLoginPage.setTimeDelay(10);
        log.info("Step 3.5 - Click Login Button");
        censorLoginPage.clickLoginButton();
        censorHomePage = PageGenerator.createCensorDashboardPage(driver);
        log.info("Step 3.5 - Check Login Censor success");
        verifyTrue(censorHomePage.checkLoginCensorSuccess());
        log.info("Step 3.6 - Check default language and Change language to VI");
        censorHomePage.checkAndChangeLanguageToVI(driver);
        log.info("Step 3.7 - Go to Account moderation");
        censorHomePage.clickToItemOnMenu(driver,"Người dùng");
        censorAccountListPage= PageGenerator.getAccountManagerList(driver);
        log.info("Step 3.8 -Check Account moderation page is displayed successfully");
        verifyTrue(censorAccountListPage.checkAccountManagerPageIsDisplay());
        log.info("Step 3.9 - Search Account to block");
        censorAccountListPage.searchAccount(driver,email);
        log.info("Step 3.10 - Block Account");
        censorAccountListPage.clickToBlockAccount(driver,email,"Khóa tài khoản",GlobalVariables.BACKEND_PASSWORD);
        log.info("Step 3.11 - Verify Account blocked");
        verifyTrue(censorAccountListPage.checkAccountIsBlockedSuccessfully(driver,email,"Đã bị khóa"));
        log.info("Step 4 - Login with blocked account");
        log.info("Step 4.1 - Open Newsfeed Login");
        censorAccountListPage.openNewWindow(driver,GlobalVariables.URL_NEWS_FEED_LOGIN);
        loginNewsFeedPage = PageGenerator.createLoginNewsfeedPage(driver);
        log.info("Step 4.2 - Enter Username");
        loginNewsFeedPage.enterUsernameToLogin(email);
        log.info("Step 4.3 - Enter password");
        loginNewsFeedPage.enterPasswordToLogin(passWord);
        log.info("Step 4.4 - Click Login button");
        loginNewsFeedPage.clickLoginButton();
        log.info("Step 4.5 - Login - Login with blocked account - Check message verification");
        verifyEquals(loginNewsFeedPage.getErrorMessageOfPassword(),"Tên tài khoản hoặc mật khẩu sai");
    }

    @AfterTest
    public void closeBrowserAndDriver(){
        closeBrowserAndDriver(driver);
    }
}



