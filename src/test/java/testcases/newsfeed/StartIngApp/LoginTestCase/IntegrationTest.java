package testcases.newsfeed.StartIngApp.LoginTestCase;

import Censor.AccountManager.CensorAccountList;
import Censor.Dashboard.CensorDashboard;
import CommonHelper.DriverBrowser.BrowserDriver;
import CommonHelper.DriverBrowser.DriverManager;
import CommonHelper.Function.AbstractTest;
import CommonHelper.Function.DataHelper;
import CommonHelper.Function.PageGenerator;
import CommonHelper.GlobalVariables;
import Newsfeed.Common.UpdateInfo.FirstUpdateInfo;
import Newsfeed.TabFeed.NewsFeedTab;
import StartingApp.Login.LoginCensor;
import StartingApp.Login.LoginNewsfeed;
import StartingApp.Register.VerifyAccountPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class IntegrationTest extends AbstractTest {
    WebDriver driver;
    DriverManager driverManager;
    DataHelper dataHelper = DataHelper.getData();

    // PageObject Model
    NewsFeedTab newsFeedPage;
    LoginCensor censorLoginPage;
    CensorDashboard censorHomePage;
    CensorAccountList censorAccountListPage;
    VerifyAccountPageObject verifyAccountPage;
    LoginNewsfeed loginNewsFeedPage;
    FirstUpdateInfo updateInfo;

    // Data Driven
    String verifyCode;
    String adminUser = GlobalVariables.BACKEND_USER_NAME;
    String adminPass = GlobalVariables.BACKEND_PASSWORD;
    String urlNewFeed = GlobalVariables.URL_NEWS_FEED_LOGIN;
    String passWord ="123456";
    String confirmPassword = "123456";
    // Random data
    String firstName = dataHelper.getFirstName();
    String lastName = dataHelper.getLastName();
    String email = createVirtualMail();



    @Parameters("browser")
    @BeforeTest
    public void openBrowser(String browserName){
        log.info("Precondition - Step 1 - Create driver browser");
        driverManager = BrowserDriver.getBrowser(browserName);

        log.info("Precondition - Step 2 - Open Browser and Go to Login Newsfeed");
        driver = driverManager.getDriver(urlNewFeed);
        loginNewsFeedPage = PageGenerator.createLoginNewsfeedPage(driver);

        log.info("Precondition - Step 3 - Verify Login Newsfeed display success");
        loginNewsFeedPage.checkLoginNewsfeedPageIsDisplay();
    }
    @Test
    public void TC01_Login_With_Blocked_Account_Email(){
        log.info("Step 1.1 - Newsfeed - Register Account - Enter First Name");
        loginNewsFeedPage.enterDataOnDynamicTextField("nv104",firstName);

        log.info("Step 1.2 - Newsfeed - Register Account - Enter Last Name");
        loginNewsFeedPage.enterDataOnDynamicTextField("nv103",lastName);

        log.info("Step 1.3 - Newsfeed - Register Account - Enter Email");
        loginNewsFeedPage.enterDataOnDynamicTextField("nv108",email);

        log.info("Step 1.4 - Newsfeed - Register Account - Enter Password");
        loginNewsFeedPage.enterDataOnDynamicTextField("nv109",passWord);

        log.info("Step 1.5 - Newsfeed - Register Account - Enter Confirm password");
        loginNewsFeedPage.enterDataOnDynamicTextField("repeatPassword",confirmPassword);

        log.info("Step 1.6 - Newsfeed - Register Account - Click Register button and check verify account display");
        loginNewsFeedPage.clickSignUpButton();
        verifyAccountPage = PageGenerator.createVerifyAccountPage(driver);
        verifyTrue(verifyAccountPage.checkTitlePageVerifyEmail());
        verifyEquals(verifyAccountPage.getAccountDisplayOnRegisterPage(),email);

        log.info("Step 1.7 - Newsfeed - Register Account - Enter a code and click verify");
        verifyAccountPage.inputVerifyDataOnField(verifyAccountPage.copyVerifyCodeOnMail(email));
        verifyAccountPage.clickVerifyButton();
        newsFeedPage = PageGenerator.createTabNewsfeed(driver);

        log.info("Step 2.1 - Newsfeed - Finish verify account -  Cancel Update information");
        newsFeedPage.setTimeDelay(1);
        updateInfo = newsFeedPage.targetToFirstUpdateInfoPopup(driver);
        updateInfo.clickCancelUpdateNewInfo();
        newsFeedPage.changeLanguageDisplayToVietnamese();
        newsFeedPage.setTimeDelay(1);

        log.info("Step 2.2 - Newsfeed - Finish verify account -  Click logout button");
        newsFeedPage.clickItemOnSettingMenu(driver,"Đăng xuất");
        loginNewsFeedPage = PageGenerator.createLoginNewsfeedPage(driver);

        log.info("Step 3.1 - Censor - Login Admin - Go to Login page");
        loginNewsFeedPage.openNewWindow(driver,GlobalVariables.URL_CENSOR_LINK);
        censorLoginPage = PageGenerator.getCensorLoginPage(driver);

        log.info("Step 3.2 - Censor - Login Admin - Enter Admin Username");
        censorLoginPage.enterUsername(GlobalVariables.BACKEND_USER_NAME);

        log.info("Step 3.3 - Censor - Login Admin - Enter Password");
        censorLoginPage.enterPassword(GlobalVariables.BACKEND_PASSWORD);

        log.info("Step 3.4 - Enter - Censor - Login Admin - Captcha code - Delay");
        censorLoginPage.setTimeDelay(10);

        log.info("Step 3.5 - Censor - Login Admin - Click Login Button");
        censorLoginPage.clickLoginButton();
        censorHomePage = PageGenerator.createCensorDashboardPage(driver);

        log.info("Step 4.1 - Censor - Block Account - Go To Account Morderator");
        verifyTrue(censorHomePage.checkLoginCensorSuccess());
        censorHomePage.checkAndChangeLanguageToVI(driver);
        censorHomePage.clickToItemOnMenu(driver,"Người dùng");
        censorAccountListPage= PageGenerator.getAccountManagerList(driver);

        log.info("Step 4.2 - Censor - Block Account - Search Account");
        verifyTrue(censorAccountListPage.checkAccountManagerPageIsDisplay());
        censorAccountListPage.searchAccount(driver,email);

        log.info("Step 4.3 - Censor - Block Account - Do action block Account");
        censorAccountListPage.clickToBlockAccount(driver,email,"Khóa tài khoản",GlobalVariables.BACKEND_PASSWORD);
        verifyTrue(censorAccountListPage.checkAccountIsBlockedSuccessfully(driver,email,"Đã bị khóa"));

        log.info("Step 5.1 - Newsfeed - Check Login Blocked Account - Go to Newsfeed Login");
        censorAccountListPage.openNewWindow(driver,GlobalVariables.URL_NEWS_FEED_LOGIN);
        loginNewsFeedPage = PageGenerator.createLoginNewsfeedPage(driver);

        log.info("Step 5.2 - Newsfeed - Check Login Blocked Account - Enter Username");
        loginNewsFeedPage.enterDataOnDynamicTextField("identity",email);

        log.info("Step 5.3 - Newsfeed - Check Login Blocked Account - Enter password");
        loginNewsFeedPage.enterDataOnDynamicTextField("password",passWord);

        log.info("Step 5.4 - Newsfeed - Check Login Blocked Account -Click Login button");
        loginNewsFeedPage.clickLoginButton();
        verifyEquals(loginNewsFeedPage.getErrorValidationOfTextField("password"),"Tên tài khoản hoặc mật khẩu sai");
    }

    @AfterTest
    public void closeBrowserAndDriver(){
        closeBrowserAndDriver(driver);
    }
}



