package testcases.newsfeed.StartIngApp.SignUpTestCase;

import CommonHelper.DriverBrowser.BrowserDriver;
import CommonHelper.DriverBrowser.DriverManager;
import CommonHelper.Function.AbstractTest;
import CommonHelper.Function.DataHelper;
import CommonHelper.Function.PageGenerator;
import CommonHelper.GlobalVariables;
import Newsfeed.PersonalWall.About.OverviewTab.OverviewPageObject;
import Newsfeed.TabFeed.NewsFeedTab;
import StartingApp.Login.LoginNewsfeed;
import StartingApp.Register.VerifyAccountPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class Validation extends AbstractTest {
    WebDriver driver;
    DriverManager driverManager;
    DataHelper data = DataHelper.getData();
    VerifyAccountPageObject verifyPage;
    LoginNewsfeed newsfeedLoginPage;
    NewsFeedTab newsfeedPage;
    OverviewPageObject personalOVerViewTab;
    // Khai báo giá trị nhập vào
    String email ="huy.hodoan" + randomEmail() + "@mailinator.com";
    String firstName = data.getFirstName();
    String lastName = data.getFirstName();
    String confirmPass,password;

    @Parameters("browser")
    @BeforeClass
    public void openBrowser(String urlPage){
        log.info("Precondition - Create driver browser");
        driverManager = BrowserDriver.getBrowser(urlPage);
        log.info("Precondition - Go to NewsFeed Login");
        driver = driverManager.getDriver(GlobalVariables.URL_NEWS_FEED_LOGIN);
        newsfeedLoginPage = PageGenerator.createLoginNewsfeedPage(driver);
        log.info("Precondition - Change language system to Vietnamese");
        newsfeedLoginPage.changeLanguageSystemToVI();
    }
    @Test
    public void TC01_CheckValidationFirstName(){
        log.info("Step 1 - Prepaid and input data on other field except FirstName");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv103",lastName);
        newsfeedLoginPage.enterDataOnDynamicTextField("nv108",email);
        newsfeedLoginPage.enterDataOnDynamicTextField("nv109","123456");
        newsfeedLoginPage.enterDataOnDynamicTextField("repeatPassword","123456");

        log.info("Step 2.1 - Do Input First name");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv104","");
        log.info("Step 2.2 - Click to signup button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 2.3 - Verify error message on Firstname");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("nv104"),"Tên là bắt buộc.");

        log.info("Step 3.1 - Input First name with data contains whitespace");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv104","    ");
        log.info("Step 3.2 - Click to signup button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 3.3 - Verify error message on Firstname");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("nv104"),"Tên là bắt buộc.");

        log.info("Step 4 - Input First name contains numChar");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv104","12345647");
        log.info("Step 4.2 - Click to signup button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 4.3 - Verify error message on Firstname");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("nv104"),"Tên không chứa số.");

        log.info("Step 5 - Input First name contains AlphaNumberChar");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv104","Huy12");
        log.info("Step 5.2 - Click to signup button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 5.3 - Verify error message on Firstname");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("nv104"),"Tên không chứa số.");

        log.info("Step 6.1 - Input First name contains SpecialChar");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv104","H@ang @anh");
        log.info("Step 6.2 - Click to signup button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 6.3 - Verify error message on Firstname");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("nv104"),"Tên không chứa ký tự đặc biệt.");

        log.info("Step 7 - Input First name is Script");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv104", GlobalVariables.SCRIPT_CODE);
        log.info("Step 7.2 - Click to signup button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 7.3 - Verify error message on Firstname");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("nv104"),"Tên không chứa ký tự đặc biệt.");

        log.info("Step 8 - Input First name is HTML Code");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv104",GlobalVariables.HTML_CODE);
        log.info("Step 8.2 - Click to signup button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 8.3 - Verify error message on Firstname");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("nv104"),"Tên không chứa ký tự đặc biệt.");
    }
    @Test
    public void TC02_CheckValidationLastName(){
        newsfeedLoginPage.enterDataOnDynamicTextField("nv104",firstName);
        log.info("Step 1.1 - Do not input Last name");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv103","");
        log.info("Step 1.2 - Click to signup button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 1.3 - Verify error message on Lastname");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("nv103"),"Họ là bắt buộc.");

        log.info("Step 2.1 - Input Last name with data contains whitespace");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv103","    ");
        log.info("Step 2.2 - Click to signup button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 2.3 - Verify error message on Lastname");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("nv103"),"Họ là bắt buộc.");

        log.info("Step 3.1 - Input Last name contains NumChar");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv103","12345647");
        log.info("Step 3.2 - Click to signup button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 3.3 - Verify error message on Lastname");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("nv103"),"Họ không chứa số.");

        log.info("Step 4.1 - Input Last name contains Alpha number character");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv103","Hồ 12");
        log.info("Step 4.2 - Click to signup button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 4.3 - Verify error message on Lastname");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("nv103"),"Họ không chứa số.");

        log.info("Step 5.1 - Input Last name contains specialChar");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv103","H@ Do@an");
        log.info("Step 5.2 - Click to signup button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 5.3 - Verify error message on Lastname");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("nv103"),"Họ không chứa ký tự đặc biệt.");

        log.info("Step 6.1 - Input Last name contains Script Code");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv103", GlobalVariables.SCRIPT_CODE);
        log.info("Step 6.2 - Click to signup button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 6.3 - Verify error message on Lastname");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("nv103"),"Họ không chứa ký tự đặc biệt.");

        log.info("Step 7.1 - Input Last name contains HTML Code");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv103",GlobalVariables.HTML_CODE);
        log.info("Step 7.2 - Click to signup button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 7.3 - Verify error message on Lastname");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("nv103"),"Họ không chứa ký tự đặc biệt.");
    }

    @Test
    public void  TC03_ValidationOfEmail() {
        newsfeedLoginPage.enterDataOnDynamicTextField("nv103",lastName);
        log.info("Step 1.1 - Do not input Email");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv108","");
        log.info("Step 1.1 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 1.2 - Check verify error message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("nv108"), "Tài khoản là bắt buộc.");

        log.info("Step 2.1 - Input email contains Whitespace");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv108","   ");
        log.info("Step 2.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 2.3 - Check verify error message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("nv108"), "Tài khoản là bắt buộc.");

        log.info("Step 3.1 - Input invalid email");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv108","huyho12@gmail.");
        log.info("Step 3.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 3.3 - Check verify error message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("nv108"), "Tài khoản không hợp lệ.");

        log.info("Step 4.1 - Input existed email");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv108","balo_04@mailinator.com");
        log.info("Step 4.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 4.3 - Check verify error message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("nv108"), "Tài khoản đã tồn tại trên hệ thống Hahalolo");

        log.info("Step 5.1 - Input email contains special char");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv108","huy!@hoho@mailinator.com");
        log.info("Step 5.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 5.3 - Check verify error message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("nv108"), "Tài khoản không hợp lệ.");

        log.info("Step 6.1 - Input email contains whitespace on first");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv108"," huy@mailinator.com");
        log.info("Step 6.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 6.3 - Check verify error message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("nv108"), "Tài khoản không hợp lệ.");

        log.info("Step 7.1 - Input email contains whitespace on middle");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv108","huy ho@mailinator.com");
        log.info("Step 7.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 7.3 - Check verify error message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("nv108"), "Tài khoản không hợp lệ.");

        log.info("Step 8.1 - Input email contains whitespace on last");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv108","huyho@mailinator.com ");
        log.info("Step 8.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 8.3 - Check verify error message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("nv108"), "Tài khoản không hợp lệ.");
    }

    @Test
    public void TC04_ValidateOfUsernameWithPhone() {
        log.info("Step 1.1 - Input invalid Phone");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv108","09022222");
        log.info("Step 1.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 1.3 - Check verify error message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("nv108"), "Số điện thoại không hợp lệ.");

        log.info("Step 2 - Existed Phone");
        log.info("Step 2.1 - Input Phone");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv108","0936709449");
        log.info("Step 2.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 2.3 - Check verify error message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("nv108"), "Tài khoản đã tồn tại trên hệ thống Hahalolo");

        log.info("Step 3 -  Phone number contains phone code(+84)");
        log.info("Step 3.1 - Input Phone");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv108","+840936709449");
        log.info("Step 3.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 3.3 - Check verify error message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("nv108"), "Tài khoản không hợp lệ.");
    }

    @Test
    public void TC05_ValidationOFPasswordField(){
        log.info("Step 1 - Input Email");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv108",email);
        log.info("Step 2.2 - Do not Input Blank Password");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv109","");
        log.info("Step 2.1 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 2.3 - Verify error validation message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("nv109"),"Mật khẩu là bắt buộc.");

        log.info("Step 3.1 - Enter Password <6 chars");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv109","12345");
        log.info("Step 3.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 3.3 - Verify error validation message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("nv109"),"Giới hạn tối thiểu của Mật khẩu là 6 kí tự");

        log.info("Step 4.1 - Enter Password > 128 chars");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv109",randomPassword(129));
        log.info("Step 4.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 4.2 - Verify error validation message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("nv109"),"Giới hạn tối đa của Mật khẩu là 128 kí tự");

        log.info("Step 5.1 Enter Password contains whitespace");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv109","123 456");
        log.info("Step 5.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 5.3 - Verify error validation message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("nv109"),"Mật khẩu không chứa kí tự trắng.");
    }

    @Test
    public void TC06_ValidationOFConfirmPasswordField(){
        newsfeedLoginPage.enterDataOnDynamicTextField("nv109","123456");
        log.info("Step 1 - Do not input Confirm Password");
        newsfeedLoginPage.enterDataOnDynamicTextField("repeatPassword","");
        log.info("Step 1.1 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 1.2 - Verify error validation message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("repeatPassword"),"Mật khẩu xác nhận là bắt buộc.");

        log.info("Step 2 - Confirm Password <6 chars");
        log.info("Step 2.1 Enter Password");
        newsfeedLoginPage.enterDataOnDynamicTextField("repeatPassword","12345");
        log.info("Step 2.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 2.3 - Verify error validation message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("repeatPassword"),"Mật khẩu xác nhận phải trùng với Mật khẩu");

        log.info("Step 3 - ConfirmPassword > 128 chars");
        log.info("Step 3.1 Enter ConfirmPassword");
        newsfeedLoginPage.enterDataOnDynamicTextField("repeatPassword",randomPassword(129));
        log.info("Step 3.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 3.2 - Verify error validation message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("repeatPassword"),"Mật khẩu xác nhận phải trùng với Mật khẩu");

        log.info("Step 4 - ConfirmPassword contains whitespace");
        log.info("Step 4.1 Enter Password");
        newsfeedLoginPage.enterDataOnDynamicTextField("repeatPassword","123 456");
        log.info("Step 4.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 4.3 - Verify error validation message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("repeatPassword"),"Mật khẩu xác nhận không chứa kí tự trắng.");

        log.info("Step 5 - Password not same confirm pass");
        log.info("Step 5.1 Enter Password");
        newsfeedLoginPage.enterDataOnDynamicTextField("repeatPassword","1234567");
        log.info("Step 5.2 - Click SignUp button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 5.3 - Verify error validation message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfTextField("repeatPassword"),"Mật khẩu xác nhận phải trùng với Mật khẩu");
    }
//    @Test
//    public void TC07_ValidationOFPhoneCode() {
//        newsfeedLoginPage.enterDataOnDynamicTextField("repeatPassword","123456");
//        log.info("Step 1.1 - Input Phone");
//        newsfeedLoginPage.enterDataOnDynamicTextField("nv108","840936709449");
//        log.info("Step 2.1 - Phone area code");
//        newsfeedLoginPage.removePhoneCode();
//        log.info("Step 4.2 - Click SignUp button");
//        newsfeedLoginPage.clickSignUpButton();
//        verifyEquals(newsfeedLoginPage.getErrValidationOfPhoneCode(),"Mã vùng là bắt buộc.");
//    }
    @Test
    public void TC08_RegisterAccountWithEmailIsUppercase() {
        newsfeedLoginPage.refreshPage(driver);
        log.info("Step 1 - Input FirstName");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv104", firstName);
        log.info("Step 2 - Input LastName");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv103", lastName);
        log.info("Step 3 - Input email");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv108",email.toUpperCase());
        log.info("Step 4 - Input Password");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv109","123456");
        log.info("Step 5 - Input ConfirmPass");
        newsfeedLoginPage.enterDataOnDynamicTextField("repeatPassword","123456");
        log.info("Step 6 - Click SignUp button and verify email of account display");
        newsfeedLoginPage.clickSignUpButton();
        verifyPage = PageGenerator.createVerifyAccountPage(driver);
        verifyTrue(verifyPage.checkTitlePageVerifyEmail());
        verifyEquals(verifyPage.getAccountDisplayOnRegisterPage(), email);
        log.info("Step 7 - Input verify code and verify account");
        verifyPage.inputVerifyDataOnField(verifyPage.copyVerifyCodeOnMail(email));
        verifyPage.clickVerifyButton();
        log.info("Step 8 - Go to Newsfeed and cancel update info");
        newsfeedPage = PageGenerator.createNewsfeedTab(driver);
        newsfeedPage.setTimeDelay(1);
        newsfeedPage.clickCancelUpdateNewInfo();
        log.info("Step 9 - Go To Personal about and check email display on WidgetIntro");
        newsfeedPage.clickEditProfile();
        personalOVerViewTab = PageGenerator.getPersonalOverviewTab(driver);
        verifyEquals(personalOVerViewTab.getEmailOfUserOnWidgetIntro(), email);
        log.info("Step 10 - Logout account");
        personalOVerViewTab.clickItemOnSettingMenu(driver,"Đăng xuất");
        newsfeedLoginPage = PageGenerator.createLoginNewsfeedPage(driver);
    }
    @Test
    public void TC09_RegisterAccountWithEmailContainsMoreThan2Idots() {
        log.info("Step 1 - Input FirstName");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv104", firstName);
        log.info("Step 2 - Input LastName");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv103", lastName);
        log.info("Step 3 - Input Email");
        email ="huy.ho.ho"+randomEmail()+"@mailinator.com";
        newsfeedLoginPage.enterDataOnDynamicTextField("nv108",email);
        log.info("Step 4 - Input Password");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv109","123456");
        log.info("Step 5 - Input ConfirmPass");
        newsfeedLoginPage.enterDataOnDynamicTextField("repeatPassword","123456");
        log.info("Step 6 - Click SignUp button and verify email of account display");
        newsfeedLoginPage.clickSignUpButton();
        verifyPage = PageGenerator.createVerifyAccountPage(driver);
        verifyTrue(verifyPage.checkTitlePageVerifyEmail());
        verifyEquals(verifyPage.getAccountDisplayOnRegisterPage(), email);
        log.info("Step 7 - Input verify code and verify account");
        verifyPage.inputVerifyDataOnField(verifyPage.copyVerifyCodeOnMail(email));
        verifyPage.clickVerifyButton();
        log.info("Step 8 - Go to Newsfeed and cancel update info");
        newsfeedPage = PageGenerator.createNewsfeedTab(driver);
        newsfeedPage.setTimeDelay(1);
        newsfeedPage.clickCancelUpdateNewInfo();
        log.info("Step 9 - Go To Personal about and check email display on WidgetIntro");
        newsfeedPage.clickEditProfile();
        personalOVerViewTab = PageGenerator.getPersonalOverviewTab(driver);
        verifyEquals(personalOVerViewTab.getEmailOfUserOnWidgetIntro(), email);
        log.info("Step 5.1 - Click Logout");
        personalOVerViewTab.clickItemOnSettingMenu(driver,"Đăng xuất");
        newsfeedLoginPage = PageGenerator.createLoginNewsfeedPage(driver);
    }
    @Test (enabled = false)
    public void TC10_RegisterAccountWithPhoneHaveAreaCode() {
        log.info("Step 1 - Input FirstName");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv104", firstName);
        log.info("Step 2 - Input LastName");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv103", lastName);
        log.info("Step 3 - Input Phone");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv108","840936709449");
        log.info("Step 4 - Input Password");
        newsfeedLoginPage.enterDataOnDynamicTextField("nv109","123456");
        log.info("Step 5 - Input ConfirmPass");
        newsfeedLoginPage.enterDataOnDynamicTextField("repeatPassword","123456");
        log.info("Step 6 - Click SignUp button and verify phone of account display");
        newsfeedLoginPage.clickSignUpButton();
        verifyPage = PageGenerator.createVerifyAccountPage(driver);
        verifyTrue(verifyPage.checkTitlePageVerifyPhone());
        verifyEquals(verifyPage.getAccountDisplayOnRegisterPage(), "840936709449");
        log.info("Step 7 - Input verify code and verify account");
        verifyPage.copyVerifyCodeOnMail(verifyPage.copyVerifyCodeOnMail(email));
        verifyPage.clickVerifyButton();
        log.info("Step 8 - Go to Newsfeed and cancel update info");
        newsfeedPage = PageGenerator.createNewsfeedTab(driver);
        newsfeedPage.setTimeDelay(1);
        newsfeedPage.clickCancelUpdateNewInfo();
        log.info("Step 9 - Go To Personal about and check email display on WidgetIntro");
        newsfeedPage.clickEditProfile();
        personalOVerViewTab = PageGenerator.getPersonalOverviewTab(driver);
        verifyEquals(personalOVerViewTab.getEmailOfUserOnWidgetIntro(), email);
        log.info("Step 5.1 - Click Logout");
        personalOVerViewTab.clickItemOnSettingMenu(driver,"ic ic-logout-c");
        newsfeedLoginPage = PageGenerator.createLoginNewsfeedPage(driver);
    }
    @AfterTest
    public void closeBrowserAndDriver(){
        closeBrowserAndDriver(driver);
    }
}