package testcases.newsfeed.StartIngApp;

import actions.PageObject.newsfeed.Starting.NewsFeedLogin;
import actions.PageObject.newsfeed.Starting.NewsFeedVerifyAccount;
import actions.common.DriverBrowser.BrowserDriver;
import actions.common.DriverBrowser.DriverManager;
import actions.common.Function.AbstractTest;
import actions.common.Function.DataHelper;
import actions.common.Function.PageGenerator;
import actions.common.GlobalVariables;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class SignUpTestcase extends AbstractTest {
    WebDriver driver;
    DriverManager driverManager;
    DataHelper data = DataHelper.getData();
    // Khai báo PageObject
    NewsFeedVerifyAccount verifyPage;
    NewsFeedLogin loginPage;
    // Khai báo giá trị nhập vào
    public String email, firstName, lastName, passWord, confirmPass;

    @Parameters("browser")
    @BeforeClass
    public void openBrowser(String urlPage){
        email ="huy.hodoan"+randomEmail()+"@mailinantor.com";
        firstName = data.getFirstName();
        lastName = data.getFirstName();
        passWord = "123456";
        confirmPass = "123456";

        log.info("Precondition - Open browser");
        driverManager = BrowserDriver.getBrowser(urlPage);
        log.info("Precondition - Go to NewsFeed Login");
        driver = driverManager.getDriver(GlobalVariables.URL_NEWS_FEED_LOGIN);
        loginPage = PageGenerator.getLoginPage(driver);
        log.info("Precondition - Change language system to Vietnamese");
        loginPage.changeLanguageSystemToVI();
    }
    @Test
    public void TC_01_SingUp_With_Blank_First_Name(){
        log.info("Step 1 - Enter Last name");
        loginPage.enterDataToTextBoxField(driver,"nv103",lastName);
        log.info("Step 2 - Enter Account");
        loginPage.enterDataToTextBoxField(driver,"nv108",email);
        log.info("Step 3 - Enter Password");
        loginPage.enterDataToTextBoxField(driver,"nv109","123456");
        log.info("Step 4 - Enter Confirm password");
        loginPage.enterDataToTextBoxField(driver,"repeatPassword","123456");
        log.info("Step 5 - Click Sign up button");
        loginPage.clickSignUpButton();
        log.info("Step 6 - Verify error validation message");
        verifyEquals(loginPage.getValidateErrMessage(driver,"nv104"),"Tên là bắt buộc.");
    }
    @Test
    public void TC_02_SingUp_With_FirstName_Contain_NumChar(){
        log.info("Step 1 - Enter First name");
        loginPage.enterDataToTextBoxField(driver,"nv104","12345647");
        log.info("Step 2 - Enter Last name");
        loginPage.enterDataToTextBoxField(driver,"nv103",lastName);
        log.info("Step 3 - Enter Account");
        loginPage.enterDataToTextBoxField(driver,"nv108",email);
        log.info("Step 4 - Enter Password");
        loginPage.enterDataToTextBoxField(driver,"nv109",passWord);
        log.info("Step 5 - Enter Confirm Password");
        loginPage.enterDataToTextBoxField(driver,"repeatPassword",confirmPass);
        log.info("Step 6 - Click Sign up button");
        loginPage.clickSignUpButton();
        log.info("Step 7 - Verify error validation message");
        verifyEquals(loginPage.getValidateErrMessage(driver,"nv104"),"Tên không chứa số.");
    }
    @Test
    public void TC_03_SingUp_With_FirstName_Contain_AlphaNumChar(){
        log.info("Step 1 - Enter First name");
        loginPage.enterDataToTextBoxField(driver,"nv104","Huy12");
        log.info("Step 2 - Enter Last name");
        loginPage.enterDataToTextBoxField(driver,"nv103",lastName);
        log.info("Step 3 - Enter Account");
        loginPage.enterDataToTextBoxField(driver,"nv108",email);
        log.info("Step 4 - Enter Password");
        loginPage.enterDataToTextBoxField(driver,"nv109",passWord);
        log.info("Step 5 - Enter Confirm Password");
        loginPage.enterDataToTextBoxField(driver,"repeatPassword",confirmPass);
        log.info("Step 6 - Click Sign up button");
        loginPage.clickSignUpButton();
        log.info("Step 7 - Verify error validation message");
        verifyEquals(loginPage.getValidateErrMessage(driver,"nv104"),"Tên không chứa số.");
    }
    @Test
    public void TC_04_SingUp_With_FirstName_Contains_SpecChar(){
        log.info("Step 1 - Enter First name");
        loginPage.enterDataToTextBoxField(driver,"nv104","H@ang @anh");
        log.info("Step 2 - Enter Last name");
        loginPage.enterDataToTextBoxField(driver,"nv103",lastName);
        log.info("Step 3 - Enter Account");
        loginPage.enterDataToTextBoxField(driver,"nv108",email);
        log.info("Step 4 - Enter Password");
        loginPage.enterDataToTextBoxField(driver,"nv109",passWord);
        log.info("Step 5 - Enter Confirm Password");
        loginPage.enterDataToTextBoxField(driver,"repeatPassword",confirmPass);
        log.info("Step 6 - Click Sign up button");
        loginPage.clickSignUpButton();
        log.info("Step 7 - Verify error validation message");
        verifyEquals(loginPage.getValidateErrMessage(driver,"nv104"),"Tên không chứa ký tự đặc biệt.");
    }
    @Test
    public void TC_05_SingUp_With_FirstName_Contains_Only_Whitespace(){
        log.info("Step 1 - Enter First name");
        loginPage.enterDataToTextBoxField(driver,"nv104","  ");
        log.info("Step 2 - Enter Last name");
        loginPage.enterDataToTextBoxField(driver,"nv103",lastName);
        log.info("Step 3 - Enter Account");
        loginPage.enterDataToTextBoxField(driver,"nv108",email);
        log.info("Step 4 - Enter Password");
        loginPage.enterDataToTextBoxField(driver,"nv109",passWord);
        log.info("Step 5 - Enter Confirm Password");
        loginPage.enterDataToTextBoxField(driver,"repeatPassword",confirmPass);
        log.info("Step 6 - Click Sign up button");
        loginPage.clickSignUpButton();
        log.info("Step 7 - Verify error validation message");
        verifyEquals(loginPage.getValidateErrMessage(driver,"nv104"),"Tên là bắt buộc.");
    }
    @Test
    public void TC_06_SingUp_With_FirstName_Contains_Script(){
        log.info("Step 1 - Enter First name");
        loginPage.enterDataToTextBoxField(driver,"nv104",GlobalVariables.SCRIPT_CODE);
        log.info("Step 2 - Enter Last name");
        loginPage.enterDataToTextBoxField(driver,"nv103",lastName);
        log.info("Step 3 - Enter Account");
        loginPage.enterDataToTextBoxField(driver,"nv108",email);
        log.info("Step 4 - Enter Password");
        loginPage.enterDataToTextBoxField(driver,"nv109",passWord);
        log.info("Step 5 - Enter Confirm Password");
        loginPage.enterDataToTextBoxField(driver,"repeatPassword",confirmPass);
        log.info("Step 6 - Click Sign up button");
        loginPage.clickSignUpButton();
        log.info("Step 7 - Verify error validation message");
        verifyEquals(loginPage.getValidateErrMessage(driver,"nv104"),"Tên không chứa ký tự đặc biệt.");
    }
    @Test
    public void TC_07_SingUp_With_First_Name_Contains_HTML(){
        log.info("Step 1 - Enter First name");
        loginPage.enterDataToTextBoxField(driver,"nv104",GlobalVariables.HTML_CODE);
        log.info("Step 2 - Enter Last name");
        loginPage.enterDataToTextBoxField(driver,"nv103",lastName);
        log.info("Step 3 - Enter Account");
        loginPage.enterDataToTextBoxField(driver,"nv108",email);
        log.info("Step 4 - Enter Password");
        loginPage.enterDataToTextBoxField(driver,"nv109",passWord);
        log.info("Step 5 - Enter Confirm Password");
        loginPage.enterDataToTextBoxField(driver,"repeatPassword",confirmPass);
        log.info("Step 6 - Click Sign up button");
        loginPage.clickSignUpButton();
        log.info("Step 7 - Verify error validation message");
        verifyEquals(loginPage.getValidateErrMessage(driver,"nv104"),"Tên không chứa ký tự đặc biệt.");
    }

    @Test
    public void TC_01_SingUp_With_Last_Name_Is_Blank(){
        log.info("Step 1 - Enter First name");
        loginPage.enterDataToTextBoxField(driver,"nv104",firstName);
        log.info("Step 2 - Enter Account");
        loginPage.enterDataToTextBoxField(driver,"nv108",email);
        log.info("Step 3 - Enter Password");
        loginPage.enterDataToTextBoxField(driver,"nv109",passWord);
        log.info("Step 4 - Enter Confirm Password");
        loginPage.enterDataToTextBoxField(driver,"repeatPassword",confirmPass);
        log.info("Step 5 - Click Sign up button");
        loginPage.clickSignUpButton();
        log.info("Step 6 - Verify error validation message");
        verifyEquals(loginPage.getValidateErrMessage(driver,"nv103"),"Họ là bắt buộc.");
    }
    @Test
    public void TC_02_SingUp_With_Last_Name_Contains_Number_Char(){
        log.info("Step 1 - Enter First name");
        loginPage.enterDataToTextBoxField(driver,"nv104","H@ang @anh");
        log.info("Step 2 - Enter Last name");
        loginPage.enterDataToTextBoxField(driver,"nv103",lastName);
        log.info("Step 3 - Enter Account");
        loginPage.enterDataToTextBoxField(driver,"nv108",email);
        log.info("Step 4 - Enter Password");
        loginPage.enterDataToTextBoxField(driver,"nv109","123456");
        log.info("Step 5 - Enter Confirm Password");
        loginPage.enterDataToTextBoxField(driver,"repeatPassword","123456");
        log.info("Step 6 - Click Sign up button");
        loginPage.clickSignUpButton();
        log.info("Step 7 - Verify error validation message");
        verifyEquals(loginPage.getValidateErrMessage(driver,"nv103"),"Họ không chứa số.");
    }
    @Test
    public void TC_03_SingUp_With_Last_Name_Contains_Alpha_Number_Char(){
        log.info("Step 1 - Enter First name");
        loginPage.enterDataToTextBoxField(driver,"nv104","H@ang @anh");
        log.info("Step 2 - Enter Last name");
        loginPage.enterDataToTextBoxField(driver,"nv103",lastName);
        log.info("Step 3 - Enter Account");
        loginPage.enterDataToTextBoxField(driver,"nv108",email);
        log.info("Step 4 - Enter Password");
        loginPage.enterDataToTextBoxField(driver,"nv109","123456");
        log.info("Step 5 - Enter Confirm Password");
        loginPage.enterDataToTextBoxField(driver,"repeatPassword","123456");
        log.info("Step 6 - Click Sign up button");
        loginPage.clickSignUpButton();
        log.info("Step 7 - Verify error validation message");
        verifyEquals(loginPage.getValidateErrMessage(driver,"nv103"),"Họ không chứa số.");
    }
    @Test
    public void TC_04_SingUp_With_Last_Name_Contains_Special_Char(){
        log.info("Step 1 - Enter First name");
        loginPage.enterDataToTextBoxField(driver,"nv104","H@ang @anh");
        log.info("Step 2 - Enter Last name");
        loginPage.enterDataToTextBoxField(driver,"nv103",lastName);
        log.info("Step 3 - Enter Account");
        loginPage.enterDataToTextBoxField(driver,"nv108",email);
        log.info("Step 4 - Enter Password");
        loginPage.enterDataToTextBoxField(driver,"nv109","123456");
        log.info("Step 5 - Enter Confirm Password");
        loginPage.enterDataToTextBoxField(driver,"repeatPassword","123456");
        log.info("Step 6 - Click Sign up button");
        loginPage.clickSignUpButton();
        log.info("Step 7 - Verify error validation message");
        verifyEquals(loginPage.getValidateErrMessage(driver,"nv103"),"Họ không chứa ký tự đặc biệt.");
    }
    @Test
    public void TC_05_SingUp_With_Last_Name_Contains_All_Whitespace(){
        log.info("Step 1 - Enter First name");
        loginPage.enterDataToTextBoxField(driver,"nv104","H@ang @anh");
        log.info("Step 2 - Enter Last name");
        loginPage.enterDataToTextBoxField(driver,"nv103",lastName);
        log.info("Step 3 - Enter Account");
        loginPage.enterDataToTextBoxField(driver,"nv108",email);
        log.info("Step 4 - Enter Password");
        loginPage.enterDataToTextBoxField(driver,"nv109","123456");
        log.info("Step 5 - Enter Confirm Password");
        loginPage.enterDataToTextBoxField(driver,"repeatPassword","123456");
        log.info("Step 6 - Click Sign up button");
        loginPage.clickSignUpButton();
        log.info("Step 7- Verify error validation message");
        verifyEquals(loginPage.getValidateErrMessage(driver,"nv103"),"Họ là bắt buộc.");
    }
    @Test
    public void TC_06_SingUp_With_Last_Name_Contains_Scriptcode(){
        log.info("Step 1 - Enter First name");
        loginPage.enterDataToTextBoxField(driver,"nv104","H@ang @anh");
        log.info("Step 2 - Enter Last name");
        loginPage.enterDataToTextBoxField(driver,"nv103",lastName);
        log.info("Step 3 - Enter Account");
        loginPage.enterDataToTextBoxField(driver,"nv108",email);
        log.info("Step 4 - Enter Password");
        loginPage.enterDataToTextBoxField(driver,"nv109","123456");
        log.info("Step 5 - Enter Confirm Password");
        loginPage.enterDataToTextBoxField(driver,"repeatPassword","123456");
        log.info("Step 6 - Click Sign up button");
        loginPage.clickSignUpButton();
        log.info("Step 7 - Verify error validation message");
        verifyEquals(loginPage.getValidateErrMessage(driver,"nv103"),"Họ không chứa ký tự đặc biệt.");
    }
    @Test
    public void TC_07_SingUp_With_Last_Name_Contains_HTMLCode(){
        log.info("Step 1 - Enter First name");
        loginPage.enterDataToTextBoxField(driver,"nv104","H@ang @anh");
        log.info("Step 2 - Enter Last name");
        loginPage.enterDataToTextBoxField(driver,"nv103",lastName);
        log.info("Step 3 - Enter Account");
        loginPage.enterDataToTextBoxField(driver,"nv108",email);
        log.info("Step 4 - Enter Password");
        loginPage.enterDataToTextBoxField(driver,"nv109","123456");
        log.info("Step 5 - Enter Confirm Password");
        loginPage.enterDataToTextBoxField(driver,"repeatPassword","123456");
        log.info("Step 6 - Click Sign up button");
        loginPage.clickSignUpButton();
        log.info("Step 7 - Verify error validation message");
        verifyEquals(loginPage.getValidateErrMessage(driver,"nv103"),"Họ không chứa ký tự đặc biệt.");
    }

    @Test
    public void TC_01_SingUp_With_Phone_Email_Blank(){
        log.info("Step 1 - Enter First name");
        loginPage.enterDataToTextBoxField(driver,"nv104",firstName);
        log.info("Step 2 - Enter Last name");
        loginPage.enterDataToTextBoxField(driver,"nv103",lastName);
        log.info("Step 3 - Enter Password");
        loginPage.enterDataToTextBoxField(driver,"nv109","123456");
        log.info("Step 4 - Enter Confirm password");
        loginPage.enterDataToTextBoxField(driver,"repeatPassword","123456");
        log.info("Step 5 - Click Sign up button");
        loginPage.clickSignUpButton();
        log.info("Step 6 - Verify error validation message");
        verifyEquals(loginPage.getValidateErrMessage(driver,"nv108"),"Tài khoản là bắt buộc.");
    }
    @Test(enabled = false)
    public void TC_02_SingUp_With_Phone_Other_Area(){
        log.info("Step 1 - Enter First name");
        loginPage.enterDataToTextBoxField(driver,"nv104",firstName);
        log.info("Step 2 - Enter Last name");
        loginPage.enterDataToTextBoxField(driver,"nv103",lastName);
        log.info("Step 3 - Enter Phone Number");
        loginPage.enterDataToTextBoxField(driver,"nv108","0936709449");
        log.info("Step 4 - Enter Password");
        loginPage.enterDataToTextBoxField(driver,"nv109","123456");
        log.info("Step 5 - Enter Confirm password");
        loginPage.enterDataToTextBoxField(driver,"repeatPassword","123456");
        log.info("Change Phone code");
        loginPage.changePhoneCode("(+598) Uruguay");
        log.info("Click Sign up button");
        loginPage.clickSignUpButton();
        log.info("Verify error validation message");
        verifyEquals(loginPage.getValidateErrMessage(driver,"nv108"),"Số điện thoại không hợp lệ.");
    }
    @Test
    public void TC_03_SingUp_With_Existed_Phone(){
        log.info("Enter First name");
        loginPage.enterDataToTextBoxField(driver,"nv104","H@ang @anh");
        log.info("Enter Last name");
        loginPage.enterDataToTextBoxField(driver,"nv103",lastName);
        log.info("Enter Account");
        loginPage.enterDataToTextBoxField(driver,"nv108",email);
        log.info("Enter Password");
        loginPage.enterDataToTextBoxField(driver,"nv109","123456");
        log.info("Enter Confirm Password");
        loginPage.enterDataToTextBoxField(driver,"repeatPassword","123456");
        log.info("Click Sign up button");
        loginPage.clickSignUpButton();
        log.info("Verify error validation message");
        verifyEquals(loginPage.getValidateErrMessage(driver,"nv108"),"Tài khoản đã tồn tại trên hệ thống Hahalolo");
    }
    @Test
    public void TC_03_SingUp_With_Invalid_Phone(){
        log.info("Enter First name");
        loginPage.enterDataToTextBoxField(driver,"nv104","H@ang @anh");
        log.info("Enter Last name");
        loginPage.enterDataToTextBoxField(driver,"nv103",lastName);
        log.info("Enter Account");
        loginPage.enterDataToTextBoxField(driver,"nv108",email);
        log.info("Enter Password");
        loginPage.enterDataToTextBoxField(driver,"nv109","123456");
        log.info("Enter Confirm Password");
        loginPage.enterDataToTextBoxField(driver,"repeatPassword","123456");
        log.info("Click Sign up button");
        loginPage.clickSignUpButton();
        log.info("Verify error validation message");
        verifyEquals(loginPage.getValidateErrMessage(driver,"nv108"),"Tài khoản không hợp lệ.");
    }

    @Test
    public void TC_03_SingUp_With_Invalid_Email(){
        log.info("Enter First name");
        loginPage.enterDataToTextBoxField(driver,"nv104","H@ang @anh");
        log.info("Enter Last name");
        loginPage.enterDataToTextBoxField(driver,"nv103",lastName);
        log.info("Enter Account");
        loginPage.enterDataToTextBoxField(driver,"nv108",email);
        log.info("Enter Password");
        loginPage.enterDataToTextBoxField(driver,"nv109","123456");
        log.info("Enter Confirm Password");
        loginPage.enterDataToTextBoxField(driver,"repeatPassword","123456");
        log.info("Click Sign up button");
        loginPage.clickSignUpButton();
        log.info("Verify error validation message");
        verifyEquals(loginPage.getValidateErrMessage(driver,"nv108"),"Tài khoản không hợp lệ.");
    }
    @Test
    public void TC_03_SingUp_With_Existed_Email(){
        log.info("Enter First name");
        loginPage.enterDataToTextBoxField(driver,"nv104","H@ang @anh");
        log.info("Enter Last name");
        loginPage.enterDataToTextBoxField(driver,"nv103",lastName);
        log.info("Enter Account");
        loginPage.enterDataToTextBoxField(driver,"nv108",email);
        log.info("Enter Password");
        loginPage.enterDataToTextBoxField(driver,"nv109","123456");
        log.info("Enter Confirm Password");
        loginPage.enterDataToTextBoxField(driver,"repeatPassword","123456");
        log.info("Click Sign up button");
        loginPage.clickSignUpButton();
        log.info("Verify error validation message");
        verifyEquals(loginPage.getValidateErrMessage(driver,"nv108"),"Tài khoản đã tồn tại trên hệ thống Hahalolo");
    }
    @Test
    public void TC_03_SingUp_With_Email_Has_Uppercase(){
        log.info("Enter First name");
        loginPage.enterDataToTextBoxField(driver,"nv104","H@ang @anh");
        log.info("Enter Last name");
        loginPage.enterDataToTextBoxField(driver,"nv103",lastName);
        log.info("Enter Account");
        loginPage.enterDataToTextBoxField(driver,"nv108",email);
        log.info("Enter Password");
        loginPage.enterDataToTextBoxField(driver,"nv109","123456");
        log.info("Enter Confirm Password");
        loginPage.enterDataToTextBoxField(driver,"repeatPassword","123456");
        log.info("Click Sign up button");
        loginPage.clickSignUpButton();
        log.info("Verify error validation message");
        verifyTrue(verifyPage.checkTitlePageVerifyEmail());
//        Assert.assertTrue(verifyPage.checkEmailDisplayOnRegisterPage(email));
    }

    @Test
    public void TC_01_SingUp_With_Password_Is_Blank(){
        log.info("Enter First name");
        loginPage.enterDataToTextBoxField(driver,"nv104","H@ang @anh");
        log.info("Enter Last name");
        loginPage.enterDataToTextBoxField(driver,"nv103",lastName);
        log.info("Enter Account");
        loginPage.enterDataToTextBoxField(driver,"nv108",email);
        log.info("Enter Password");
        loginPage.enterDataToTextBoxField(driver,"nv109","123456");
        log.info("Enter Confirm Password");
        loginPage.enterDataToTextBoxField(driver,"repeatPassword","123456");
        log.info("Click Sign up button");
        loginPage.clickSignUpButton();
        log.info("Verify error validation message");
        verifyEquals(loginPage.getValidateErrMessage(driver,"nv109"),"Mật khẩu là bắt buộc.");
    }
    @Test
    public void TC_02_SingUp_With_Password_Less_Than_6_Chars(){
        log.info("Enter First name");
        loginPage.enterDataToTextBoxField(driver,"nv104","H@ang @anh");
        log.info("Enter Last name");
        loginPage.enterDataToTextBoxField(driver,"nv103",lastName);
        log.info("Enter Account");
        loginPage.enterDataToTextBoxField(driver,"nv108",email);
        log.info("Enter Password");
        loginPage.enterDataToTextBoxField(driver,"nv109","123456");
        log.info("Enter Confirm Password");
        loginPage.enterDataToTextBoxField(driver,"repeatPassword","123456");
        log.info("Click Sign up button");
        loginPage.clickSignUpButton();
        log.info("Verify error validation message");
        verifyEquals(loginPage.getValidateErrMessage(driver,"nv109"),"Giới hạn tối thiểu của Mật khẩu là 6 kí tự");
    }
    @Test
    public void TC_03_SingUp_With_Password_Greater_Than_128_Chars(){
        log.info("Enter First name");
        loginPage.enterDataToTextBoxField(driver,"nv104","H@ang @anh");
        log.info("Enter Last name");
        loginPage.enterDataToTextBoxField(driver,"nv103",lastName);
        log.info("Enter Account");
        loginPage.enterDataToTextBoxField(driver,"nv108",email);
        log.info("Enter Password");
        loginPage.enterDataToTextBoxField(driver,"nv109","123456");
        log.info("Enter Confirm Password");
        loginPage.enterDataToTextBoxField(driver,"repeatPassword","123456");
        log.info("Click Sign up button");
        loginPage.clickSignUpButton();
        log.info("Verify error validation message");
        verifyEquals(loginPage.getValidateErrMessage(driver,"nv109"),"Giới hạn tối thiểu của Mật khẩu là 128 kí tự");
    }
    @Test
    public void TC_03_SingUp_With_Password_Contains_Whitespace(){
        log.info("Enter First name");
        loginPage.enterDataToTextBoxField(driver,"nv104","H@ang @anh");
        log.info("Enter Last name");
        loginPage.enterDataToTextBoxField(driver,"nv103",lastName);
        log.info("Enter Account");
        loginPage.enterDataToTextBoxField(driver,"nv108",email);
        log.info("Enter Password");
        loginPage.enterDataToTextBoxField(driver,"nv109","123456");
        log.info("Enter Confirm Password");
        loginPage.enterDataToTextBoxField(driver,"repeatPassword","123456");
        log.info("Click Sign up button");
        loginPage.clickSignUpButton();
        log.info("Verify error validation message");
        verifyEquals(loginPage.getValidateErrMessage(driver,"nv109"),"Giới hạn tối thiểu của Mật khẩu là 128 kí tự");
    }
    @Test
    public void TC_04_SingUp_With_Password_Not_Same_Confirm_Pass(){
        log.info("Enter First name");
        loginPage.enterDataToTextBoxField(driver,"nv104","H@ang @anh");
        log.info("Enter Last name");
        loginPage.enterDataToTextBoxField(driver,"nv103",lastName);
        log.info("Enter Account");
        loginPage.enterDataToTextBoxField(driver,"nv108",email);
        log.info("Enter Password");
        loginPage.enterDataToTextBoxField(driver,"nv109","123456");
        log.info("Enter Confirm Password");
        loginPage.enterDataToTextBoxField(driver,"repeatPassword","123456");
        log.info("Click Sign up button");
        loginPage.clickSignUpButton();
        log.info("Verify error validation message");
        verifyEquals(loginPage.getValidateErrMessage(driver,"repeatPassword"),"Mật khẩu xác nhận phải trùng với Mật khẩu");
    }

    @Test
    public void TC_01_SingUp_With_Confirm_Password_Is_Blank(){
        log.info("Enter First name");
        loginPage.enterDataToTextBoxField(driver,"nv104","H@ang @anh");
        log.info("Enter Last name");
        loginPage.enterDataToTextBoxField(driver,"nv103",lastName);
        log.info("Enter Account");
        loginPage.enterDataToTextBoxField(driver,"nv108",email);
        log.info("Enter Password");
        loginPage.enterDataToTextBoxField(driver,"nv109","123456");
        log.info("Enter Confirm Password");
        loginPage.enterDataToTextBoxField(driver,"repeatPassword","123456");
        log.info("Click Sign up button");
        loginPage.clickSignUpButton();
        log.info("Verify error validation message");
        verifyEquals(loginPage.getValidateErrMessage(driver,"repeatPassword"),"Mật khẩu xác nhận là bắt buộc.");
    }
    @Test
    public void TC_02_SingUp_With_Confirm_Password_Less_Than_6_Chars(){
        log.info("Enter First name");
        loginPage.enterDataToTextBoxField(driver,"nv104","H@ang @anh");
        log.info("Enter Last name");
        loginPage.enterDataToTextBoxField(driver,"nv103",lastName);
        log.info("Enter Account");
        loginPage.enterDataToTextBoxField(driver,"nv108",email);
        log.info("Enter Password");
        loginPage.enterDataToTextBoxField(driver,"nv109","123456");
        log.info("Enter Confirm Password");
        loginPage.enterDataToTextBoxField(driver,"repeatPassword","123456");
        log.info("Click Sign up button");
        loginPage.clickSignUpButton();
        log.info("Verify error validation message");
        verifyEquals(loginPage.getValidateErrMessage(driver,"repeatPassword"),"Mật khẩu xác nhận là bắt buộc.");
    }
    @Test
    public void TC_03_SingUp_With_Confirm_Password_Greater_Than_128_Chars(){
        log.info("Enter First name");
        loginPage.enterDataToTextBoxField(driver,"nv104","H@ang @anh");
        log.info("Enter Last name");
        loginPage.enterDataToTextBoxField(driver,"nv103",lastName);
        log.info("Enter Account");
        loginPage.enterDataToTextBoxField(driver,"nv108",email);
        log.info("Enter Password");
        loginPage.enterDataToTextBoxField(driver,"nv109","123456");
        log.info("Enter Confirm Password");
        loginPage.enterDataToTextBoxField(driver,"repeatPassword","123456");
        log.info("Click Sign up button");
        loginPage.clickSignUpButton();
        log.info("Verify error validation message");
        verifyEquals(loginPage.getValidateErrMessage(driver,"repeatPassword"),"Mật khẩu xác nhận là bắt buộc.");
    }
    @AfterTest
    public void closeBrowserAndDriver(){
        closeBrowserAndDriver(driver);
    }
}