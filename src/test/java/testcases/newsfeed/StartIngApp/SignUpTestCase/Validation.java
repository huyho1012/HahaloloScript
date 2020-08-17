package testcases.newsfeed.StartIngApp.SignUpTestCase;

import CommonHelper.DriverBrowser.BrowserDriver;
import CommonHelper.DriverBrowser.DriverManager;
import CommonHelper.Function.AbstractTest;
import CommonHelper.Function.DataHelper;
import CommonHelper.Function.PageGenerator;
import CommonHelper.GlobalVariables;
import Newsfeed.PersonalWall.About.OverviewTab.OverviewPageObject;
import Newsfeed.TabFeed.NewsFeedTabPageObject;
import StartingApp.Login.LoginNewsfeed;
import StartingApp.Register.VerifyAccountPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class Validation extends AbstractTest {
    WebDriver driver;
    DriverManager driverManager;
    DataHelper data = DataHelper.getData();
    // Khai báo PageObject
    VerifyAccountPageObject verifyPage;
    LoginNewsfeed newsfeedLoginPage;
    NewsFeedTabPageObject newsfeedPage;
    OverviewPageObject personalOVerViewTab;
    // Khai báo giá trị nhập vào
    public String email, firstName, lastName, passWord, confirmPass;

    @Parameters("browser")
    @BeforeClass
    public void openBrowser(String urlPage){
        email ="huy.hodoan"+randomEmail()+"@mailinantor.com";
        firstName = data.getFirstName();
        lastName = data.getFirstName();
        confirmPass = "123456";

        log.info("Precondition - Open browser");
        driverManager = BrowserDriver.getBrowser(urlPage);
        log.info("Precondition - Go to NewsFeed Login");
        driver = driverManager.getDriver(GlobalVariables.URL_NEWS_FEED_LOGIN);
        newsfeedLoginPage = PageGenerator.createLoginNewsfeedPage(driver);
        log.info("Precondition - Change language system to Vietnamese");
        newsfeedLoginPage.changeLanguageSystemToVI();
    }
    @Test
    public void TC01_ValidateOfFirstName(){
        log.info("Step 1");
        newsfeedLoginPage.enterLastNameForRegister(lastName);
        newsfeedLoginPage.enterNewAccountForRegister(email);
        newsfeedLoginPage.enterPasswordForRegister("123456");
        newsfeedLoginPage.enterConfirmPasswordForRegister("123456");

        log.info("Step 2 - No input");
        newsfeedLoginPage.clickSignUpButton();
        verifyEquals(newsfeedLoginPage.getErrorValidationOfFirstName(),"Tên là bắt buộc.");

        log.info("Step 3 - All Whitespace");
        newsfeedLoginPage.enterFirstNameForRegister("    ");
        newsfeedLoginPage.clickSignUpButton();
        verifyEquals(newsfeedLoginPage.getErrorValidationOfFirstName(),"Tên là bắt buộc.");

        log.info("Step 4 - Number character");
        newsfeedLoginPage.enterFirstNameForRegister("12345647");
        newsfeedLoginPage.clickSignUpButton();
        verifyEquals(newsfeedLoginPage.getErrorValidationOfFirstName(),"Tên không chứa số.");

        log.info("Step 5 - Alpha number character");
        newsfeedLoginPage.enterFirstNameForRegister("Huy12");
        newsfeedLoginPage.clickSignUpButton();
        verifyEquals(newsfeedLoginPage.getErrorValidationOfFirstName(),"Tên không chứa số.");

        log.info("Step 6 - Special character");
        newsfeedLoginPage.enterFirstNameForRegister("H@ang @anh");
        newsfeedLoginPage.clickSignUpButton();
        verifyEquals(newsfeedLoginPage.getErrorValidationOfFirstName(),"Tên không chứa ký tự đặc biệt.");

        log.info("Step 7 - Script Code");
        newsfeedLoginPage.enterFirstNameForRegister(GlobalVariables.SCRIPT_CODE);
        newsfeedLoginPage.clickSignUpButton();
        verifyEquals(newsfeedLoginPage.getErrorValidationOfFirstName(),"Tên không chứa ký tự đặc biệt.");

        log.info("Step 8 - HTML Code");
        newsfeedLoginPage.enterFirstNameForRegister(GlobalVariables.HTML_CODE);
        newsfeedLoginPage.clickSignUpButton();
        verifyEquals(newsfeedLoginPage.getErrorValidationOfFirstName(),"Tên không chứa ký tự đặc biệt.");
    }
    @Test
    public void TC02_ValidateOfLastName(){
        log.info("Step 1");
        newsfeedLoginPage.enterFirstNameForRegister(firstName);
        newsfeedLoginPage.enterNewAccountForRegister(email);
        newsfeedLoginPage.enterPasswordForRegister("123456");
        newsfeedLoginPage.enterConfirmPasswordForRegister("123456");

        log.info("Step 2 - No input");
        newsfeedLoginPage.clickSignUpButton();
        verifyEquals(newsfeedLoginPage.getErrorValidationOfLastName(),"Họ là bắt buộc.");

        log.info("Step 3 - All Whitespace");
        newsfeedLoginPage.enterLastNameForRegister("    ");
        newsfeedLoginPage.clickSignUpButton();
        verifyEquals(newsfeedLoginPage.getErrorValidationOfLastName(),"Họ là bắt buộc.");

        log.info("Step 4 - Number character");
        newsfeedLoginPage.enterLastNameForRegister("12345647");
        newsfeedLoginPage.clickSignUpButton();
        verifyEquals(newsfeedLoginPage.getErrorValidationOfLastName(),"Họ không chứa số.");

        log.info("Step 5 - Alpha number character");
        newsfeedLoginPage.enterLastNameForRegister("Hồ 12");
        newsfeedLoginPage.clickSignUpButton();
        verifyEquals(newsfeedLoginPage.getErrorValidationOfLastName(),"Họ không chứa số.");

        log.info("Step 6 - Special character");
        newsfeedLoginPage.enterLastNameForRegister("H@ Do@an");
        newsfeedLoginPage.clickSignUpButton();
        verifyEquals(newsfeedLoginPage.getErrorValidationOfLastName(),"Họ không chứa ký tự đặc biệt.");

        log.info("Step 7 - Script Code");
        newsfeedLoginPage.enterLastNameForRegister(GlobalVariables.SCRIPT_CODE);
        newsfeedLoginPage.clickSignUpButton();
        verifyEquals(newsfeedLoginPage.getErrorValidationOfLastName(),"Họ không chứa ký tự đặc biệt.");

        log.info("Step 8 - HTML Code");
        newsfeedLoginPage.enterLastNameForRegister(GlobalVariables.HTML_CODE);
        newsfeedLoginPage.clickSignUpButton();
        verifyEquals(newsfeedLoginPage.getErrorValidationOfLastName(),"Họ không chứa ký tự đặc biệt.");
    }

    @Test
    public void TC03_ValidateOfUsernameWithEmail() {
        log.info("Step 1 - Blank email");
        log.info("Step 1.1 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 1.2 - Check verify error message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfNewUsername(), "Tài khoản là bắt buộc.");

        log.info("Step 2 - Email Contains Whitespace");
        log.info("Step 2.1 - Input email");
        newsfeedLoginPage.enterNewAccountForRegister("   ");
        log.info("Step 2.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 2.3 - Check verify error message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfNewUsername(), "Tài khoản là bắt buộc.");

        log.info("Step 3 - Invalid Email");
        log.info("Step 3.1 - Input email");
        newsfeedLoginPage.enterNewAccountForRegister("huyho12@gmail.");
        log.info("Step 3.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 3.3 - Check verify error message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfNewUsername(), "Tài khoản không hợp lệ.");

        log.info("Step 4 - Existed email");
        log.info("Step 4.1 - Input email");
        newsfeedLoginPage.enterNewAccountForRegister("balo_04@mailinator.com");
        log.info("Step 4.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 4.3 - Check verify error message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfNewUsername(), "Tài khoản đã tồn tại trên hệ thống Hahalolo");

        log.info("Step 5 - Email contains special char");
        log.info("Step 5.1 - Input email");
        newsfeedLoginPage.enterNewAccountForRegister("huy!@hoho@mailinator.com");
        log.info("Step 5.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 5.3 - Check verify error message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfNewUsername(), "Tài khoản không hợp lệ.");

        log.info("Step 6 - Email contains whitespace on first");
        log.info("Step 6.1 - Input email");
        newsfeedLoginPage.enterNewAccountForRegister(" huy@mailinator.com");
        log.info("Step 6.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 6.3 - Check verify error message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfNewUsername(), "Tài khoản không hợp lệ.");

        log.info("Step 7 - Email contains whitespace on middle");
        log.info("Step 7.1 - Input email");
        newsfeedLoginPage.enterNewAccountForRegister("huy ho@mailinator.com");
        log.info("Step 7.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 7.3 - Check verify error message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfNewUsername(), "Tài khoản không hợp lệ.");

        log.info("Step 8 - Email contains whitespace on last");
        log.info("Step 8 - Input email");
        newsfeedLoginPage.enterNewAccountForRegister("huyho@mailinator.com ");
        log.info("Step 8 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 8 - Check verify error message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfNewUsername(), "Tài khoản không hợp lệ.");
    }

    @Test
    public void TC04_ValidateOfUsernameWithPhone() {
        log.info("Step 1 - Invalid Phone");
        log.info("Step 1.1 - Input Phone");
        newsfeedLoginPage.enterNewAccountForRegister("09022222");
        log.info("Step 1.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 1.3 - Check verify error message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfNewUsername(), "Số điện thoại không hợp lệ.");

        log.info("Step 2 - Existed Phone");
        log.info("Step 2.1 - Input Phone");
        newsfeedLoginPage.enterNewAccountForRegister("0936709449");
        log.info("Step 2.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 2.3 - Check verify error message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfNewUsername(), "Tài khoản đã tồn tại trên hệ thống Hahalolo");

        log.info("Step 3 -  Phone number contains phone code(+84)");
        log.info("Step 3.1 - Input Phone");
        newsfeedLoginPage.enterNewAccountForRegister("+840936709449");
        log.info("Step 3.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 3.3 - Check verify error message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfNewUsername(), "Tài khoản không hợp lệ.");
    }
    @Test
    public void TC05_ValidationOFPhoneCode() {
        log.info("Step 1 - Blank Phone Code");
        log.info("Step 1.1 - Input Phone");
        newsfeedLoginPage.enterNewAccountForRegister("840936709449");
        newsfeedLoginPage.removePhoneCode();
        log.info("Step 4.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();
        verifyEquals(newsfeedLoginPage.getErrValidationOfPhoneCode(),"Mã vùng là bắt buộc.");
    }
    @Test
    public void TC06_ValidationOFPasswordField(){
        log.info("Step 1 - Input other field");
        log.info("Step 1.1 - Input FirstName");
        newsfeedLoginPage.enterFirstNameForRegister(firstName);
        log.info("Step 1.2 - Input LastName");
        newsfeedLoginPage.enterLastNameForRegister(lastName);
        log.info("Step 1.3 - Input Username");
        newsfeedLoginPage.enterNewAccountForRegister(email);
        log.info("Step 1.4 - Input ConfirmPassword");
        newsfeedLoginPage.enterConfirmPasswordForRegister("123456");

        log.info("Step 2 - Blank Password");
        log.info("Step 2.1 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 2.2 - Verify error validation message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfNewPassword(),"Mật khẩu là bắt buộc.");

        log.info("Step 3 - Password <6 chars");
        log.info("Step 3.1 Enter Password");
        newsfeedLoginPage.enterPasswordForRegister("12345");
        log.info("Step 3.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 3.3 - Verify error validation message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfNewPassword(),"Giới hạn tối thiểu của Mật khẩu là 6 kí tự");

        log.info("Step 4 - Password > 128 chars");
        log.info("Step 4.1 Enter Password");
        newsfeedLoginPage.enterPasswordForRegister(randomPassword(129));
        log.info("Step 4.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 4.2 - Verify error validation message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfNewPassword(),"Giới hạn tối thiểu của Mật khẩu là 128 kí tự");

        log.info("Step 5 - Password contains whitespace");
        log.info("Step 5.1 Enter Password");
        newsfeedLoginPage.enterPasswordForRegister("123 456");
        log.info("Step 5.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 5.3 - Verify error validation message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfNewPassword(),"Mật khẩu không chứa kí tự trắng.");
    }

    @Test
    public void TC07_ValidationOFConfirmPasswordField(){
        log.info("Step 1 - Blank Confirm Password");
        log.info("Step 1.1 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 1.2 - Verify error validation message");
        verifyEquals(newsfeedLoginPage.getErrValidationOfConfirmPass(),"Mật khẩu xác nhận là bắt buộc.");

        log.info("Step 2 - Confirm Password <6 chars");
        log.info("Step 2.1 Enter Password");
        newsfeedLoginPage.enterConfirmPasswordForRegister("12345");
        log.info("Step 2.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 2.3 - Verify error validation message");
        verifyEquals(newsfeedLoginPage.getErrValidationOfConfirmPass(),"Mật khẩu xác nhận phải trùng với Mật khẩu");

        log.info("Step 3 - ConfirmPassword > 128 chars");
        log.info("Step 3.1 Enter ConfirmPassword");
        newsfeedLoginPage.enterConfirmPasswordForRegister(randomPassword(129));
        log.info("Step 3.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 3.2 - Verify error validation message");
        verifyEquals(newsfeedLoginPage.getErrValidationOfConfirmPass(),"Mật khẩu xác nhận phải trùng với Mật khẩu");

        log.info("Step 4 - ConfirmPassword contains whitespace");
        log.info("Step 4.1 Enter Password");
        newsfeedLoginPage.enterConfirmPasswordForRegister("123 456");
        log.info("Step 4.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 4.3 - Verify error validation message");
        verifyEquals(newsfeedLoginPage.getErrValidationOfConfirmPass(),"Mật khẩu xác nhận không chứa kí tự trắng.");

        log.info("Step 5 - Password not same confirm pass");
        log.info("Step 5.1 Enter Password");
        newsfeedLoginPage.enterPasswordForRegister("1234567");
        log.info("Step 5.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 5.3 - Verify error validation message");
        verifyEquals(newsfeedLoginPage.getErrValidationOfConfirmPass(),"Mật khẩu xác nhận phải trùng với Mật khẩu");
    }

    @Test
    public void TC04() {
        log.info("Step 10 - Email contains Upper char");
        log.info("Step 10.1 - Input email");
        newsfeedLoginPage.enterNewAccountForRegister(email.toUpperCase());
        log.info("Step 10.2 - Click SignUp button and verify email of account display");
        newsfeedLoginPage.clickSignUpButton();
        verifyPage = PageGenerator.createVerifyAccountPage(driver);
        verifyEquals(verifyPage.getAccountDisplayOnRegisterPage(), email);
        log.info("Step 10.4 - Input verify code and verify account");
        verifyPage.copyVerifyCodeOnMail(verifyPage.copyVerifyCodeOnMail(email));
        verifyPage.clickVerifyButton();
        log.info("Step 10.5 - Go to Newsfeed and cancel update info");
        newsfeedPage = PageGenerator.createNewsfeedTab(driver);
        newsfeedPage.setTimeDelay(1);
        newsfeedPage.clickCancelUpdateNewInfo();
        log.info("Step 10.6 - Go To Personal about and check email display on WidgetIntro");
        newsfeedPage.clickEditProfile();
        personalOVerViewTab = PageGenerator.getPersonalOverviewTab(driver);
        verifyEquals(personalOVerViewTab.getEmailOfUserOnWidgetIntro(), email);
        log.info("Step 10.7 - Logout account");
        personalOVerViewTab.clickItemOnSettingMenu(driver, "Đăng xuất");
        newsfeedLoginPage = PageGenerator.createLoginNewsfeedPage(driver);
    }
    @Test
    public void TC05() {
        log.info("Step 11 - Valid email");
        log.info("Step 11.1 - Input FirstName");
        newsfeedLoginPage.enterFirstNameForRegister(firstName);
        log.info("Step 11.2 - Input LastName");
        newsfeedLoginPage.enterLastNameForRegister(lastName);
        log.info("Step 11.3 - Input Password");
        newsfeedLoginPage.enterPasswordToLogin("123456");
        log.info("Step 11.4 - Input ConfirmPass");
        newsfeedLoginPage.enterConfirmPasswordForRegister("123456");
        log.info("Step 11.5 - Input Email");
        newsfeedLoginPage.enterNewAccountForRegister(email);
        log.info("Step 11.6 - Click SignUp button and verify email of account display");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 11.7 - Verify account must be verified display correctly");
        verifyPage = PageGenerator.createVerifyAccountPage(driver);
        verifyEquals(verifyPage.getAccountDisplayOnRegisterPage(), email);
        log.info("Step 5.1 - Input verify code");
        verifyPage.copyVerifyCodeOnMail(verifyPage.copyVerifyCodeOnMail(email));
        log.info("Step 5.1 - Click verify button");
        verifyPage.clickVerifyButton();
        log.info("Step 5.1 - Verify register success and cancel update info");
        newsfeedPage = PageGenerator.createNewsfeedTab(driver);
        newsfeedPage.setTimeDelay(1);
        newsfeedPage.clickCancelUpdateNewInfo();
        log.info("Step 5.1 - Go To Personal about");
        newsfeedPage.clickEditProfile();
        personalOVerViewTab = PageGenerator.getPersonalOverviewTab(driver);
        log.info("Step 5.1 - Check account used on step 5.1 with email display on widget intro");
        verifyEquals(personalOVerViewTab.getEmailOfUserOnWidgetIntro(), email);
        log.info("Step 5.1 - Click Logout");
        personalOVerViewTab.clickItemOnSettingMenu(driver, "Đăng xuất");
        newsfeedLoginPage = PageGenerator.createLoginNewsfeedPage(driver);
    }
    @Test
    public void TC06() {
        log.info("Validate field Username - Email");
        log.info("Step 1 - Input other field");
        log.info("Step 1.1 - Input FirstName");
        newsfeedLoginPage.enterFirstNameForRegister(firstName);
        log.info("Step 1.2 - Input LastName");
        newsfeedLoginPage.enterLastNameForRegister(lastName);
        log.info("Step 1.3 - Input Password");
        newsfeedLoginPage.enterPasswordToLogin("123456");
        log.info("Step 1.4 - Input ConfirmPassword");
        newsfeedLoginPage.enterConfirmPasswordForRegister("123456");
        log.info("Step 1.4 - Input Email");
        newsfeedLoginPage.enterNewAccountForRegister("huy.ho.ho@mailinator.com");
        log.info("Step 1.4 - Click Sign up button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 5.1 - Verify account must be verified display correctly");
        verifyPage = PageGenerator.createVerifyAccountPage(driver);
        verifyEquals(verifyPage.getAccountDisplayOnRegisterPage(), email);
        log.info("Step 5.1 - Input verify code");
        verifyPage.copyVerifyCodeOnMail(verifyPage.copyVerifyCodeOnMail(email));
        log.info("Step 5.1 - Click verify button");
        verifyPage.clickVerifyButton();
        newsfeedPage = PageGenerator.createNewsfeedTab(driver);
        newsfeedPage.setTimeDelay(1);
        log.info("Step 5.1 - Verify register success and cancel update info");
        newsfeedPage.clickCancelUpdateNewInfo();
        log.info("Step 5.1 - Go To Personal about");
        newsfeedPage.clickEditProfile();
        personalOVerViewTab = PageGenerator.getPersonalOverviewTab(driver);
        log.info("Step 5.1 - Check account used on step 5.1 with email display on widget intro");
        verifyEquals(personalOVerViewTab.getEmailOfUserOnWidgetIntro(), email);
        log.info("Step 5.1 - Click Logout");
        personalOVerViewTab.clickItemOnSettingMenu(driver, "Đăng xuất");
        newsfeedLoginPage = PageGenerator.createLoginNewsfeedPage(driver);
    }
    @Test
    public void TC08() {
        log.info("Step 2 -  Phone number contains phone code (84)");
        log.info("Step 2.1 - Input Phone");
        newsfeedLoginPage.enterNewAccountForRegister("840936709449");
        log.info("Step 4.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();
        verifyPage = PageGenerator.createVerifyAccountPage(driver);
        personalOVerViewTab.clickItemOnSettingMenu(driver, "Đăng xuất");
        newsfeedLoginPage = PageGenerator.createLoginNewsfeedPage(driver);
    }
    @AfterTest
    public void closeBrowserAndDriver(){
        closeBrowserAndDriver(driver);
    }
}