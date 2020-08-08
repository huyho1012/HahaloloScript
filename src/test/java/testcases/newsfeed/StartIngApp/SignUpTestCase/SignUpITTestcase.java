package testcases.newsfeed.StartIngApp.SignUpTestCase;
import actions.PageObject.newsfeed.AccountSetting.NewsFeedAccSettingGeneral;
import actions.PageObject.newsfeed.PageFeed.NewsFeedHomepage;
import actions.PageObject.newsfeed.PersonalWall.PersonalAbout;
import actions.PageObject.newsfeed.Starting.NewsFeedLogin;
import actions.PageObject.newsfeed.Starting.NewsFeedVerifyAccount;
import actions.common.DriverBrowser.BrowserDriver;
import actions.common.DriverBrowser.DriverManager;
import actions.common.Function.AbstractTest;
import actions.common.Function.DataHelper;
import actions.common.Function.PageGenerator;
import actions.common.GlobalVariables;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class SignUpITTestcase extends AbstractTest {
    WebDriver driver;
    DriverManager driverManager;
    DataHelper data = DataHelper.getData();
    // Khai báo PageObject
    NewsFeedLogin loginPage;
    NewsFeedHomepage newsFeedPage;
    NewsFeedVerifyAccount verifyAccountPage;
    PersonalAbout perAboutPage;
    NewsFeedAccSettingGeneral accountSettingPage;

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
        loginPage = PageGenerator.getLoginPage(driver);
    }
    @Test
    public void TC_01_SingUp_With_Valid_Email(){
        log.info("Register Account - Step 1");
        log.info("Register Account - Step 1.1 - Enter First name");
        loginPage.enterDataToTextBoxField(driver,"nv104", firstName);

        log.info("Register Account - Step 1.2 - Enter Last name");
        loginPage.enterDataToTextBoxField(driver,"nv103",lastName);

        log.info("Register Account - Step 1.3 - Enter Email");
        loginPage.enterDataToTextBoxField(driver,"nv108",email);

        log.info("Register Account - Step 1.4 - Password");
        loginPage.enterDataToTextBoxField(driver,"nv109",passWord);

        log.info("Register Account - Step 1.5 - Enter Confirm Password");
        loginPage.enterDataToTextBoxField(driver,"repeatPassword",confirmPassword);

        log.info("Register Account - Step 1.6 - Click Signup Button");
        verifyAccountPage = loginPage.clickSignUpButton();

        log.info("Register Account - Step 2.1 - Check Account verification");
        verifyTrue(verifyAccountPage.checkTitlePageVerifyEmail());
        verifyTrue(verifyAccountPage.checkAccountDisplayOnRegisterPage(email));

        log.info("Register Account - Step 2.2 - Enter verification code");
        verifyAccountPage.inputVerifyDataOnField(verifyAccountPage.getVerificationAccountCode(email));

        log.info("Register Account - Step 2.3 - Click verify button");
        verifyAccountPage.clickVerifyButton();

        log.info("Register Account - Step 2.5 - Check verify account successfully");
        newsFeedPage = PageGenerator.getNewsFeedPage(driver);

        log.info("Register Account - Step 3.1 - Update Personal Information - Update birthday");
        newsFeedPage.updateBirthday(driver,"12","10","1992");


        log.info("Register Account - Step 3.2 - Update Personal Information - Update gender");
        newsFeedPage.updateGender(driver,"male");

        log.info("Register Account - Step 3.3 - Update Personal Information - Update country");
        newsFeedPage.updateCountry(driver,"United States");

        log.info("Register Account - Step 3.4 - Update Personal Information - Click Update Button");
        newsFeedPage.clickUpdateButton();

        log.info("Register Account - Step 4.1 - Check AccountInfo");
        perAboutPage = newsFeedPage.clickEditProfile();
        perAboutPage.clickToBasicInfo();
        verifyTrue(perAboutPage.checkDataValueAccount(driver,"Email",email));
        verifyTrue(perAboutPage.checkDataValueAccount(driver,"Ngày sinh",birthday));
        verifyTrue(perAboutPage.checkDataValueAccount(driver,"Giới tính","Nam"));
        perAboutPage.clickToSettingItem(driver,"ic-cog-c");
        accountSettingPage = PageGenerator.getAccountSettingPage(driver);
        verifyTrue(accountSettingPage.checkFullNameIsDisplay(driver,fullName));
        log.info("Check Update Info - Step 3.1 - ");
    }
//    @AfterTest
//    public void closeBrowserAndDriver(){
//        closeBrowserAndDriver(driver);
//    }
}
