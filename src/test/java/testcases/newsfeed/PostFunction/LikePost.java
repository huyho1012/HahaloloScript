package testcases.newsfeed.PostFunction;

import CommonHelper.DriverBrowser.BrowserDriver;
import CommonHelper.DriverBrowser.DriverManager;
import CommonHelper.Function.AbstractTest;
import CommonHelper.Function.DataHelper;
import CommonHelper.Function.PageGenerator;
import HeaderMain.HeaderMenu;
import Newsfeed.TabFeed.NewsFeedTab;
import StartingApp.Login.LoginNewsfeed;
import StartingApp.Register.VerifyAccountPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LikePost extends AbstractTest {
    WebDriver driver;
    DataHelper data = DataHelper.getData();
    DriverManager driverManager;

    HeaderMenu headerMenu;
    VerifyAccountPageObject verifyAccountPage;
    NewsFeedTab newsFeedPage;
    LoginNewsfeed loginPage;
    String passWord = "123456";
    String confirmPassword = "123456";
    @Parameters("browser")
    @BeforeTest
    public void preconditon(String browserName) {
        driverManager = BrowserDriver.getBrowser(browserName);
        driver = driverManager.getDriver("https://www.hahalolo.com");
        loginPage = PageGenerator.createLoginNewsfeedPage(driver);
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
            loginPage.enterDataOnDynamicTextField("nv104",firstName);

            log.info("Step 1.2 - Register Account - Enter Last Name");
            loginPage.enterDataOnDynamicTextField("nv103",lastName);

            log.info("Step 1.3 - Register Account - Enter Email");
            loginPage.enterDataOnDynamicTextField("nv108",email);

            log.info("Step 1.4 - Register Account - Enter Password");
            loginPage.enterDataOnDynamicTextField("nv109", passWord);

            log.info("Step 1.5 - Register Account - Enter Confirm password");
            loginPage.enterDataOnDynamicTextField("repeatPassword",confirmPassword);

            log.info("Step 1.6 - Register Account - Click Register button");
            loginPage.clickSignUpButton();
            verifyAccountPage = PageGenerator.createVerifyAccountPage(driver);

            log.info("Step 1.7 - Register Account - Check verification account by email display");
            verifyTrue(verifyAccountPage.checkTitlePageVerifyEmail());
            log.info("Step 1.8 - Register Account - Click Verify button");
            verifyAccountPage.inputVerifyDataOnField(verifyAccountPage.copyVerifyCodeOnMail(email));
            verifyAccountPage.clickVerifyButton();
            newsFeedPage = PageGenerator.getNewsFeedPage(driver);

            log.info("Step 1.9 - Register Account - Check account verify successfully");
            verifyTrue(newsFeedPage.checkLoginSuccess());
            newsFeedPage.setTimeDelay(4);
        }
    }
