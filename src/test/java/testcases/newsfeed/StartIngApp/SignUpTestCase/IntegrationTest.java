package testcases.newsfeed.StartIngApp.SignUpTestCase;
import CommonHelper.DriverBrowser.BrowserDriver;
import CommonHelper.DriverBrowser.DriverManager;
import CommonHelper.Function.AbstractTest;
import CommonHelper.Function.DataHelper;
import CommonHelper.Function.PageGenerator;
import CommonHelper.GlobalVariables;
import Newsfeed.Common.UpdateInfo.FirstUpdateInfo;
import Newsfeed.PersonalWall.About.BasicInfoTab.BasicInfoPageObject;
import Newsfeed.PersonalWall.About.OverviewTab.OverviewPageObject;
import Newsfeed.TabFeed.NewsFeedTab;

import Newsfeed.HeaderMenu.GeneralSettting.GeneralSetting;
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
    GeneralSetting accGeneralSetting;
    FirstUpdateInfo  updateInfoPopup;

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

        log.info("Step 1 - Enter First name");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv104",firstName);

        log.info("Step 2 - Enter Last name");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv103",lastName);

        log.info("Step 3 - Enter Email");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv108",email);

        log.info("Step 4 - Enter Password");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv109",passWord);

        log.info("Step 5 - Enter Confirm Password");
        newsfeedLoginPage.enterDataOnDynamicTextField("repeatPassword",confirmPassword);

        log.info("Step 6 - Click Signup Button and check verified account display correct");
        newsfeedLoginPage.clickSignUpButton();
        verifyAccountPage = PageGenerator.createVerifyAccountPage(driver);
        verifyTrue(verifyAccountPage.checkTitlePageVerifyEmail());
        verifyEquals(verifyAccountPage.getAccountDisplayOnRegisterPage(), email);

        log.info("Step 7 - Input verify code and verify account");
        verifyAccountPage.inputVerifyDataOnField(verifyAccountPage.copyVerifyCodeOnMail(email));
        verifyAccountPage.clickVerifyButton();
        newsFeedPage = PageGenerator.getNewsFeedPage(driver);

        log.info("Step 8 - Update Personal Information");
        newsFeedPage.targetToFirstUpdateInfoPopup(driver);
        updateInfoPopup = PageGenerator.createUpdateInfoPopup(driver);
        updateInfoPopup.updateBirthday(driver,"12","10","1992");
        updateInfoPopup.updateGender(driver,"male");
        updateInfoPopup.updateCountry(driver,"United States");
        updateInfoPopup.clickUpdateButton();

        log.info("Step 9 - Go to Personal - and verify data display with data user input");
        newsFeedPage.clickEditProfile();
        perOverviewTab = PageGenerator.getPersonalOverviewTab(driver);
        verifyEquals(perOverviewTab.getUserEmailDisplayOnIntroduceWidget(),email);
        verifyEquals(perOverviewTab.getUserBirthdayDisplayOnIntroduceWidget(),birthday);
        verifyEquals(perOverviewTab.getUserGenderDisplayOnIntroduceWidget(),"Nam");

        log.info("Step 10 - Logout account");
        perOverviewTab.clickItemOnSettingMenu(driver,"Đăng xuất");
        accGeneralSetting = PageGenerator.createAccountSettingGeneralTab(driver);
        verifyEquals(accGeneralSetting.getFullNameIsDisplay(),fullName);;
    }
//    @AfterTest
//    public void closeBrowserAndDriver(){
//        closeBrowserAndDriver(driver);
//    }
}
