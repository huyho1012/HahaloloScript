package testcases.newsfeed.PostFunction;

import HeaderMain.HeaderMenu;
import Newsfeed.TabFeed.NewsFeedTabPageObject;
import Login.LoginPageObject;
import Register.NewsFeedVerifyAccount;
import actions.common.DriverBrowser.BrowserDriver;
import actions.common.DriverBrowser.DriverManager;
import actions.common.Function.AbstractTest;
import actions.common.Function.DataHelper;
import actions.common.Function.PageGenerator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LikePost extends AbstractTest {
    WebDriver driver;
    DataHelper data = DataHelper.getData();
    DriverManager driverManager;

    HeaderMenu headerMenu;
    NewsFeedVerifyAccount verifyAccountPage;
    NewsFeedTabPageObject newsFeedPage;
    LoginPageObject loginPage;
    String passWord = "123456";
    String confirmPassword = "123456";
    @Parameters("browser")
    @BeforeTest
    public void preconditon(String browserName) {
        driverManager = BrowserDriver.getBrowser(browserName);
        driver = driverManager.getDriver("https://www.hahalolo.com");
        loginPage = PageGenerator.getLoginPage(driver);
    }
    @Test
    public void LikePost(){
        for(int i = 0;  i<100; i++){
            RegisterAccount();
            newsFeedPage.setTimeDelay(2);
            newsFeedPage.openURL(driver,"https://www.hahalolo.com/post/5f3272803862a146b327939c");
            newsFeedPage.clickLike();
            headerMenu.clickItemOnSettingMenu(driver,"Đăng xuất");
        }
    }

    public void RegisterAccount(){
        String firstName = data.getFirstName();
        String lastName = data.getFirstName();
            String email  ="hazogo"+randomEmail()+"@mailinator.com";
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

            newsFeedPage.setTimeDelay(4);
        }
    }
