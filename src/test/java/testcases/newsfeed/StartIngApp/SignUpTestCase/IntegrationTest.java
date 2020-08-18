package testcases.newsfeed.StartIngApp.SignUpTestCase;
import CommonHelper.DriverBrowser.BrowserDriver;
import CommonHelper.DriverBrowser.DriverManager;
import CommonHelper.Function.AbstractTest;
import CommonHelper.Function.DataHelper;
import CommonHelper.Function.PageGenerator;
import CommonHelper.GlobalVariables;
import Newsfeed.PersonalWall.About.BasicInfoTab.BasicInfoPageObject;
import Newsfeed.PersonalWall.About.OverviewTab.OverviewPageObject;
import Newsfeed.TabFeed.NewsFeedTab;

import Newsfeed.UserSetting.PageObject.GeneralSettingAccount;
import StartingApp.Login.LoginNewsfeed;
import StartingApp.Register.VerifyAccountPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class IntegrationTest extends AbstractTest {
    WebDriver driver;
    DriverManager driverManager;
    DataHelper data = DataHelper.getData();
    // Khai báo PageObject
    LoginNewsfeed newsfeedLoginPage;
    NewsFeedTab newsFeedPage;
    VerifyAccountPageObject verifyAccountPage;
    OverviewPageObject perOverviewTab;
    BasicInfoPageObject perBasicInfoTab;
    GeneralSettingAccount accGeneralSetting;

    // Khai báo giá trị
    public String firstName, lastName,email, passWord, confirmPassword;
    public String birthday, country, gender, monthBirth, dayBirth, yearBirth;
    public String fullName;

    @Parameters("browser")
    @BeforeClass
    public void preconditionMethod(String browserName){
        // Định nghĩa giá trị khởi tạo
        String middleName = "";
        firstName = data.getFirstName();
        lastName = data.getFirstName();
        email  ="huy.hodoan"+randomEmail()+"@mailinator.com";
        passWord = "123456";
        confirmPassword = "123456";

        gender = "male";
        country = "United States";
        monthBirth = "10";
        dayBirth = "12";
        yearBirth= "1992";
        fullName = getFullName(firstName,lastName);
        birthday = getBirthday(dayBirth,monthBirth,yearBirth);
        driverManager = BrowserDriver.getBrowser(browserName);
        driver = driverManager.getDriver(GlobalVariables.URL_NEWS_FEED_LOGIN);
        newsfeedLoginPage = PageGenerator.createLoginNewsfeedPage(driver);
    }
    @Test
    public void TC_01_SingUp_With_Valid_Email(){
        log.info("Register Account - Step 1");
        log.info("Step 1.1 - Enter First name");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv104",firstName);
        log.info("Step 1.2 - Enter Last name");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv103",lastName);
        log.info("Step 1.3 - Enter Email");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv108",email);
        log.info("Step 1.4 - Enter Password");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv109",passWord);
        log.info("Step 1.5 - Enter Confirm Password");
        newsfeedLoginPage.enterDataOnDynamicTextField("repeatPassword",confirmPassword);
        log.info("Step 1.6 - Click Signup Button");
        newsfeedLoginPage.clickSignUpButton();
        verifyAccountPage = PageGenerator.createVerifyAccountPage(driver);
        log.info("RCheck Account verification page display");
        verifyTrue(verifyAccountPage.checkTitlePageVerifyEmail());
//        verifyTrue(verifyAccountPage.getAccountDisplayOnRegisterPage(email));
        log.info("Enter verification code");
        String verifyCode = verifyAccountPage.copyVerifyCodeOnMail(email);
        verifyAccountPage.inputVerifyDataOnField(verifyCode);
        log.info("Click verify button");
        verifyAccountPage.clickVerifyButton();
        newsFeedPage = PageGenerator.getNewsFeedPage(driver);
        log.info("Step 3 - Update Personal Information");
        log.info("Step 3.1 - Update birthday");
        newsFeedPage.updateBirthday(driver,"12","10","1992");
        log.info("Step 3.2 - Update gender");
        newsFeedPage.updateGender(driver,"male");
        log.info("Step 3.3 - Update country");
        newsFeedPage.updateCountry(driver,"United States");
        log.info("Step 3.4 - Click Update Button");
        newsFeedPage.clickUpdateButton();
        log.info("Register Account - Step 4.1 - Check AccountInfo");
        newsFeedPage.clickEditProfile();
        perOverviewTab = PageGenerator.getPersonalOverviewTab(driver);
        perOverviewTab.clickToBasicInfoTab();
        perBasicInfoTab = PageGenerator.getPersonalAboutBasicInfo(driver);
        verifyTrue(perBasicInfoTab.checkDataValueAccount(driver,"Email",email));
        verifyTrue(perBasicInfoTab.checkDataValueAccount(driver,"Ngày sinh",birthday));
        verifyTrue(perBasicInfoTab.checkDataValueAccount(driver,"Giới tính","Nam"));
        perBasicInfoTab.clickItemOnSettingMenu(driver,"Đăng xuất");
        accGeneralSetting = PageGenerator.createAccountSettingGeneralTab(driver);
        verifyEquals(accGeneralSetting.getFullNameIsDisplay(),fullName);
        log.info("Check Update Info - Step 3.1 - ");
    }
//    @AfterTest
//    public void closeBrowserAndDriver(){
//        closeBrowserAndDriver(driver);
//    }
}
