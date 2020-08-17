package testcases.newsfeed.StartIngApp.SignUpTestCase;

import CommonHelper.DriverBrowser.BrowserDriver;
import CommonHelper.DriverBrowser.DriverManager;
import CommonHelper.Function.AbstractTest;
import CommonHelper.Function.DataHelper;
import CommonHelper.Function.PageGenerator;
import CommonHelper.GlobalVariables;
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
    public void TC_01_ValidateOfFirstName(){
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
    public void TC_02_ValidateOfLastName(){
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
    public void accountValidate_01_SignUp_With_Account_Is_Blank(){
        log.info("Step 1 - Enter First name");
        newsfeedLoginPage.enterFirstNameForRegister(firstName);
        log.info("Step 2 - Enter Last name");
        newsfeedLoginPage.enterLastNameForRegister(lastName);
        log.info("Step 3 - Enter Password");
        newsfeedLoginPage.enterPasswordToLogin("123456");
        log.info("Step 4 - Enter Confirm password");
        newsfeedLoginPage.enterConfirmPasswordForRegister("123456");
        log.info("Step 5 - Click Sign up button");
        newsfeedLoginPage.clickSignUpButton();
        log.info("Step 6 - Verify error validation message");
        verifyEquals(newsfeedLoginPage.getErrorValidationOfNewUsername(),"Tài khoản là bắt buộc.");
    }
//    @Test
//    public void accountValidate_02_SignUp_With_Invalid_Email(){
//        log.info("Enter First name");
//        loginPage.enterDataToTextBoxField(driver,"nv104",firstName);
//        log.info("Enter Last name");
//        loginPage.enterDataToTextBoxField(driver,"nv103",lastName);
//        log.info("Enter Account");
//        loginPage.enterDataToTextBoxField(driver,"nv108","huyho12@gmail.");
//        log.info("Enter Password");
//        loginPage.enterDataToTextBoxField(driver,"nv109","123456");
//        log.info("Enter Confirm Password");
//        loginPage.enterDataToTextBoxField(driver,"repeatPassword","123456");
//        log.info("Click Sign up button");
//        loginPage.clickSignUpButton();
//        log.info("Verify error validation message");
//        verifyEquals(loginPage.getValidateErrMessage(driver,"nv108"),"Tài khoản không hợp lệ.");
//    }
//    @Test
//    public void accountValidate_03_SignUp_With_Existed_Email(){
//        log.info("Enter First name");
//        loginPage.enterDataToTextBoxField(driver,"nv104",firstName);
//        log.info("Enter Last name");
//        loginPage.enterDataToTextBoxField(driver,"nv103",lastName);
//        log.info("Enter Account");
//        loginPage.enterDataToTextBoxField(driver,"nv108","balo_04@mailinator.com");
//        log.info("Enter Password");
//        loginPage.enterDataToTextBoxField(driver,"nv109","123456");
//        log.info("Enter Confirm Password");
//        loginPage.enterDataToTextBoxField(driver,"repeatPassword","123456");
//        log.info("Click Sign up button");
//        loginPage.clickSignUpButton();
//        log.info("Verify error validation message");
//        verifyEquals(loginPage.getValidateErrMessage(driver,"nv108"),"Tài khoản đã tồn tại trên hệ thống Hahalolo");
//    }
//    @Test
//    public void accountValidate_04_SignUp_With_Email_Contains_UppercaseChar(){
//        log.info("Enter First name");
//        loginPage.enterDataToTextBoxField(driver,"nv104",firstName);
//        log.info("Enter Last name");
//        loginPage.enterDataToTextBoxField(driver,"nv103",lastName);
//        log.info("Enter Account");
//        loginPage.enterDataToTextBoxField(driver,"nv108",email.toUpperCase());
//        log.info("Enter Password");
//        loginPage.enterDataToTextBoxField(driver,"nv109","123456");
//        log.info("Enter Confirm Password");
//        loginPage.enterDataToTextBoxField(driver,"repeatPassword","123456");
//        log.info("Click Sign up button");
//        verifyPage =  loginPage.clickSignUpButton();
//        log.info("Verify error validation message");
//        verifyTrue(verifyPage.checkTitlePageVerifyEmail());
////        Assert.assertTrue(verifyPage.checkEmailDisplayOnRegisterPage(email));
//    }
//
//    @Test
//    public void accountValidate_05_SignUp_With_Email_Contains_Diots_More_Than_2(){
//        log.info("Enter First name");
//        loginPage.enterDataToTextBoxField(driver,"nv104",firstName);
//        log.info("Enter Last name");
//        loginPage.enterDataToTextBoxField(driver,"nv103",lastName);
//        log.info("Enter Account");
//        loginPage.enterDataToTextBoxField(driver,"nv108","huy.ho.ho@mailinator.com");
//        log.info("Enter Password");
//        loginPage.enterDataToTextBoxField(driver,"nv109","123456");
//        log.info("Enter Confirm Password");
//        loginPage.enterDataToTextBoxField(driver,"repeatPassword","123456");
//        log.info("Click Sign up button");
//        verifyPage =  loginPage.clickSignUpButton();
//        verifyTrue(verifyPage.checkTitlePageVerifyEmail());
////        verifyTrue(verifyPage.checkEmailDisplayOnRegisterPage(email));
//    }
//    @Test
//    public void accountValidate_06_SignUp_With_Email_Contains_SpecialChar(){
//        log.info("Enter First name");
//        loginPage.enterDataToTextBoxField(driver,"nv104",firstName);
//        log.info("Enter Last name");
//        loginPage.enterDataToTextBoxField(driver,"nv103",lastName);
//        log.info("Enter Account");
//        loginPage.enterDataToTextBoxField(driver,"nv108","huy!@hoho@mailinator.com");
//        log.info("Enter Password");
//        loginPage.enterDataToTextBoxField(driver,"nv109","123456");
//        log.info("Enter Confirm Password");
//        loginPage.enterDataToTextBoxField(driver,"repeatPassword","123456");
//        log.info("Click Sign up button");
//        verifyEquals(loginPage.getValidateErrMessage(driver,"nv108"),"Tài khoản không hợp lệ.");
//    }
//
//    @Test(enabled = false)
//    public void accountValidate_07_SignUp_With_Phone_Is_Difference_PhoneCode(){
//        log.info("Step 1 - Enter First name");
//        loginPage.enterDataToTextBoxField(driver,"nv104",firstName);
//        log.info("Step 2 - Enter Last name");
//        loginPage.enterDataToTextBoxField(driver,"nv103",lastName);
//        log.info("Step 3 - Enter Phone Number");
//        loginPage.enterDataToTextBoxField(driver,"nv108","0936709449");
//        log.info("Step 4 - Enter Password");
//        loginPage.enterDataToTextBoxField(driver,"nv109","123456");
//        log.info("Step 5 - Enter Confirm password");
//        loginPage.enterDataToTextBoxField(driver,"repeatPassword","123456");
//        log.info("Change Phone code");
//        loginPage.changePhoneCode("(+598) Uruguay");
//        log.info("Click Sign up button");
//        loginPage.clickSignUpButton();
//        log.info("Verify error validation message");
//        verifyEquals(loginPage.getValidateErrMessage(driver,"nv108"),"Số điện thoại không hợp lệ.");
//    }
//    @Test(enabled = false)
//    public void accountValidate_08_SignUp_With_Existed_Phone(){
//        log.info("Enter First name");
//        loginPage.enterDataToTextBoxField(driver,"nv104",firstName);
//        log.info("Enter Last name");
//        loginPage.enterDataToTextBoxField(driver,"nv103",lastName);
//        log.info("Enter Account");
//        loginPage.enterDataToTextBoxField(driver,"nv108","0936709449");
//        log.info("Enter Password");
//        loginPage.enterDataToTextBoxField(driver,"nv109","123456");
//        log.info("Enter Confirm Password");
//        loginPage.enterDataToTextBoxField(driver,"repeatPassword","123456");
//        log.info("Click Sign up button");
//        loginPage.clickSignUpButton();
//        log.info("Verify error validation message");
//        verifyEquals(loginPage.getValidateErrMessage(driver,"nv108"),"Tài khoản đã tồn tại trên hệ thống Hahalolo");
//    }
//    @Test(enabled = false)
//    public void accountValidate_09_SignUp_With_Invalid_Phone(){
//        log.info("Enter First name");
//        loginPage.enterDataToTextBoxField(driver,"nv104",firstName);
//        log.info("Enter Last name");
//        loginPage.enterDataToTextBoxField(driver,"nv103",lastName);
//        log.info("Enter Account");
//        loginPage.enterDataToTextBoxField(driver,"nv108","0123432");
//        log.info("Enter Password");
//        loginPage.enterDataToTextBoxField(driver,"nv109","123456");
//        log.info("Enter Confirm Password");
//        loginPage.enterDataToTextBoxField(driver,"repeatPassword","123456");
//        log.info("Click Sign up button");
//        loginPage.clickSignUpButton();
//        log.info("Verify error validation message");
//        verifyEquals(loginPage.getValidateErrMessage(driver,"nv108"),"Tài khoản không hợp lệ.");
//    }
//
//    @Test
//    public void passwordValidate_01_SignUp_With_Password_Is_Blank(){
//        log.info("Enter First name");
//        loginPage.enterDataToTextBoxField(driver,"nv104",firstName);
//        log.info("Enter Last name");
//        loginPage.enterDataToTextBoxField(driver,"nv103",lastName);
//        log.info("Enter Account");
//        loginPage.enterDataToTextBoxField(driver,"nv108",email);
//        log.info("Enter Password");
//        loginPage.enterDataToTextBoxField(driver,"nv109","123456");
//        log.info("Enter Confirm Password");
//        loginPage.enterDataToTextBoxField(driver,"repeatPassword","123456");
//        log.info("Click Sign up button");
//        loginPage.clickSignUpButton();
//        log.info("Verify error validation message");
//        verifyEquals(loginPage.getValidateErrMessage(driver,"nv109"),"Mật khẩu là bắt buộc.");
//    }
//    @Test
//    public void passwordValidate_02_SingUp_With_Password_Less_Than_6_Chars(){
//        log.info("Enter First name");
//        loginPage.enterDataToTextBoxField(driver,"nv104",firstName);
//        log.info("Enter Last name");
//        loginPage.enterDataToTextBoxField(driver,"nv103",lastName);
//        log.info("Enter Account");
//        loginPage.enterDataToTextBoxField(driver,"nv108",email);
//        log.info("Enter Password");
//        loginPage.enterDataToTextBoxField(driver,"nv109","12345");
//        log.info("Enter Confirm Password");
//        loginPage.enterDataToTextBoxField(driver,"repeatPassword","12345");
//        log.info("Click Sign up button");
//        loginPage.clickSignUpButton();
//        log.info("Verify error validation message");
//        verifyEquals(loginPage.getValidateErrMessage(driver,"nv109"),"Giới hạn tối thiểu của Mật khẩu là 6 kí tự");
//    }
//    @Test
//    public void passwordValidate_03_SingUp_With_Password_Greater_Than_128_Chars(){
//        log.info("Enter First name");
//        loginPage.enterDataToTextBoxField(driver,"nv104",firstName);
//        log.info("Enter Last name");
//        loginPage.enterDataToTextBoxField(driver,"nv103",lastName);
//        log.info("Enter Account");
//        loginPage.enterDataToTextBoxField(driver,"nv108",email);
//        log.info("Enter Password");
//        loginPage.enterDataToTextBoxField(driver,"nv109",randomPassword(129));
//        log.info("Enter Confirm Password");
//        loginPage.enterDataToTextBoxField(driver,"repeatPassword",randomPassword(129));
//        log.info("Click Sign up button");
//        loginPage.clickSignUpButton();
//        log.info("Verify error validation message");
//        verifyEquals(loginPage.getValidateErrMessage(driver,"nv109"),"Giới hạn tối thiểu của Mật khẩu là 128 kí tự");
//    }
//    @Test
//    public void passwordValidate_03_SingUp_With_Password_Contains_Whitespace(){
//        log.info("Enter First name");
//        loginPage.enterDataToTextBoxField(driver,"nv104",firstName);
//        log.info("Enter Last name");
//        loginPage.enterDataToTextBoxField(driver,"nv103",lastName);
//        log.info("Enter Account");
//        loginPage.enterDataToTextBoxField(driver,"nv108",email);
//        log.info("Enter Password");
//        loginPage.enterDataToTextBoxField(driver,"nv109","1234 56");
//        log.info("Enter Confirm Password");
//        loginPage.enterDataToTextBoxField(driver,"repeatPassword","123456");
//        log.info("Click Sign up button");
//        loginPage.clickSignUpButton();
//        log.info("Verify error validation message");
//        verifyEquals(loginPage.getValidateErrMessage(driver,"nv109"),"Mật khẩu không chứa kí tự trắng.");
//    }
//    @Test
//    public void passwordValidate_04_SingUp_With_Password_Not_Same_Confirm_Pass(){
//        log.info("Enter First name");
//        loginPage.enterDataToTextBoxField(driver,"nv104",firstName);
//        log.info("Enter Last name");
//        loginPage.enterDataToTextBoxField(driver,"nv103",lastName);
//        log.info("Enter Account");
//        loginPage.enterDataToTextBoxField(driver,"nv108",email);
//        log.info("Enter Password");
//        loginPage.enterDataToTextBoxField(driver,"nv109","1234567");
//        log.info("Enter Confirm Password");
//        loginPage.enterDataToTextBoxField(driver,"repeatPassword","123456");
//        log.info("Click Sign up button");
//        loginPage.clickSignUpButton();
//        log.info("Verify error validation message");
//        verifyEquals(loginPage.getValidateErrMessage(driver,"repeatPassword"),"Mật khẩu xác nhận phải trùng với Mật khẩu");
//    }
//
//    @Test
//    public void confirmPassValidate_01_SignUp_With_Confirm_Password_Is_Blank(){
//        log.info("Enter First name");
//        loginPage.enterDataToTextBoxField(driver,"nv104",firstName);
//        log.info("Enter Last name");
//        loginPage.enterDataToTextBoxField(driver,"nv103",lastName);
//        log.info("Enter Account");
//        loginPage.enterDataToTextBoxField(driver,"nv108",email);
//        log.info("Enter Password");
//        loginPage.enterDataToTextBoxField(driver,"nv109","123456");
//        log.info("Enter Confirm Password");
//        loginPage.enterDataToTextBoxField(driver,"repeatPassword","");
//        log.info("Click Sign up button");
//        loginPage.clickSignUpButton();
//        log.info("Verify error validation message");
//        verifyEquals(loginPage.getValidateErrMessage(driver,"repeatPassword"),"Mật khẩu xác nhận là bắt buộc.");
//    }
//    @Test
//    public void confirmPassValidate_02_SingUp_With_Confirm_Password_Less_Than_6_Chars(){
//        log.info("Enter First name");
//        loginPage.enterDataToTextBoxField(driver,"nv104",firstName);
//        log.info("Enter Last name");
//        loginPage.enterDataToTextBoxField(driver,"nv103",lastName);
//        log.info("Enter Account");
//        loginPage.enterDataToTextBoxField(driver,"nv108",email);
//        log.info("Enter Password");
//        loginPage.enterDataToTextBoxField(driver,"nv109","123456");
//        log.info("Enter Confirm Password");
//        loginPage.enterDataToTextBoxField(driver,"repeatPassword","12345");
//        log.info("Click Sign up button");
//        loginPage.clickSignUpButton();
//        log.info("Verify error validation message");
//        verifyEquals(loginPage.getValidateErrMessage(driver,"repeatPassword"),"Mật khẩu xác nhận phải trùng với Mật khẩu");
//    }
//    @Test
//    public void confirmPassValidate_03_SingUp_With_ConfirmPass_Greater_Than_128_Chars(){
//        log.info("Enter First name");
//        loginPage.enterDataToTextBoxField(driver,"nv104",firstName);
//        log.info("Enter Last name");
//        loginPage.enterDataToTextBoxField(driver,"nv103",lastName);
//        log.info("Enter Account");
//        loginPage.enterDataToTextBoxField(driver,"nv108",email);
//        log.info("Enter Password");
//        loginPage.enterDataToTextBoxField(driver,"nv109","123456");
//        log.info("Enter Confirm Password");
//        loginPage.enterDataToTextBoxField(driver,"repeatPassword",randomPassword(129));
//        log.info("Click Sign up button");
//        loginPage.clickSignUpButton();
//        log.info("Verify error validation message");
//        verifyEquals(loginPage.getValidateErrMessage(driver,"repeatPassword"),"Mật khẩu xác nhận phải trùng với Mật khẩu");
//    }

    @AfterTest
    public void closeBrowserAndDriver(){
        closeBrowserAndDriver(driver);
    }
}