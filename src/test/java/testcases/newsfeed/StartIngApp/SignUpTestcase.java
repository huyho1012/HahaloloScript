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
import org.testng.Assert;
import org.testng.annotations.*;

public class SignUpTestcase extends AbstractTest {
    WebDriver driver;
    DriverManager driverManager;
    DataHelper data = DataHelper.getData();

    // Khai báo PageObject
    NewsFeedVerifyAccount verifyPage;
    NewsFeedLogin loginPage;

    // Khai báo giá trị nhập vào
    public String email ="huy.hodoan"+randomEmail()+"@mailinantor.com";
    public String firstName = data.getFirstName();
    public String lastName = data.getFirstName();

    @Parameters("browser")
    @BeforeClass
    public void openBrowser(String urlPage){
        driverManager = BrowserDriver.getBrowser(urlPage);
        driver = driverManager.getDriver(GlobalVariables.URL_NEWS_FEED_LOGIN);
        loginPage = PageGenerator.getLoginPage(driver);
        loginPage.checkLanguageButton();
    }
    @Test
    public void TC_01_SingUp_With_Blank_First_Name(){
        loginPage.inputDataOnFirstNameSignUp("");
        loginPage.inputDataOnLastNameSignUp(lastName);
        loginPage.inputDataOnPhoneEmailSignUp(email);
        loginPage.inputDataOnPasswordSignUp("123456");
        loginPage.inputDataOnConfirmPasswordSignUp("123456");
        loginPage.clickSignUpButton();
        verifyEquals(loginPage.getValidateFirstNameSignUp(),"Tên là bắt buộc.");
    }
    @Test
    public void TC_02_SingUp_With_First_Name_Contains_Number_Char(){
        loginPage.inputDataOnFirstNameSignUp("12345647");
        loginPage.inputDataOnLastNameSignUp(lastName);
        loginPage.inputDataOnPhoneEmailSignUp(email);
        loginPage.inputDataOnPasswordSignUp("123456");
        loginPage.inputDataOnConfirmPasswordSignUp("123456");
        loginPage.clickSignUpButton();
        verifyEquals(loginPage.getValidateFirstNameSignUp(),"Tên không chứa số.");
    }
    @Test
    public void TC_03_SingUp_With_First_Name_Contains_Alpha_Number_Char(){
        loginPage.inputDataOnFirstNameSignUp("Huy12");
        loginPage.inputDataOnLastNameSignUp(lastName);
        loginPage.inputDataOnPhoneEmailSignUp(email);
        loginPage.inputDataOnPasswordSignUp("123456");
        loginPage.inputDataOnConfirmPasswordSignUp("123456");
        loginPage.clickSignUpButton();
        verifyEquals(loginPage.getValidateFirstNameSignUp(),"Tên không chứa số.");
    }
    @Test
    public void TC_04_SingUp_With_First_Name_Contains_Special_Char(){
        loginPage.inputDataOnFirstNameSignUp("H@ang @anh");
        loginPage.inputDataOnLastNameSignUp(lastName);
        loginPage.inputDataOnPhoneEmailSignUp(email);
        loginPage.inputDataOnPasswordSignUp("123456");
        loginPage.inputDataOnConfirmPasswordSignUp("123456");
        loginPage.clickSignUpButton();
        verifyEquals(loginPage.getValidateFirstNameSignUp(),"Tên không chứa ký tự đặc biệt.");
    }
    @Test
    public void TC_05_SingUp_With_First_Name_Contains_All_WhiteSpace_Char(){
        loginPage.inputDataOnFirstNameSignUp("           ");
        loginPage.inputDataOnLastNameSignUp("Hồ");
        loginPage.inputDataOnPhoneEmailSignUp(email);
        loginPage.inputDataOnPasswordSignUp("123456");
        loginPage.inputDataOnConfirmPasswordSignUp("123456");
        loginPage.clickSignUpButton();
        verifyEquals(loginPage.getValidateFirstNameSignUp(),"Tên là bắt buộc.");
    }
    @Test
    public void TC_06_SingUp_With_First_Name_Contains_Script_Code(){
        loginPage.inputDataOnFirstNameSignUp(GlobalVariables.SCRIPT_CODE);
        loginPage.inputDataOnLastNameSignUp(lastName);
        loginPage.inputDataOnPhoneEmailSignUp(email);
        loginPage.inputDataOnPasswordSignUp("123456");
        loginPage.inputDataOnConfirmPasswordSignUp("123456");
        loginPage.clickSignUpButton();
        verifyEquals(loginPage.getValidateFirstNameSignUp(),"Tên không chứa ký tự đặc biệt.");
    }
    @Test
    public void TC_07_SingUp_With_First_Name_Contains_HTML_Code(){
        loginPage.inputDataOnFirstNameSignUp(GlobalVariables.HTML_CODE);
        loginPage.inputDataOnLastNameSignUp(lastName);
        loginPage.inputDataOnPhoneEmailSignUp(email);
        loginPage.inputDataOnPasswordSignUp("123456");
        loginPage.inputDataOnConfirmPasswordSignUp("123456");
        loginPage.clickSignUpButton();
        verifyEquals(loginPage.getValidateFirstNameSignUp(),"Tên không chứa ký tự đặc biệt.");
    }

    @Test
    public void TC_01_SingUp_With_Blank_Last_Name(){
        loginPage.inputDataOnFirstNameSignUp(firstName);
        loginPage.inputDataOnLastNameSignUp("");
        loginPage.inputDataOnPhoneEmailSignUp(email);
        loginPage.inputDataOnPasswordSignUp("123456");
        loginPage.inputDataOnConfirmPasswordSignUp("123456");
        loginPage.clickSignUpButton();
        verifyEquals(loginPage.getValidateLastNameSignUp(),"Họ là bắt buộc.");
    }
    @Test
    public void TC_02_SingUp_With_Last_Name_Contains_Number_Char(){
        loginPage.inputDataOnFirstNameSignUp(firstName);
        loginPage.inputDataOnLastNameSignUp("123456");
        loginPage.inputDataOnPhoneEmailSignUp(email);
        loginPage.inputDataOnPasswordSignUp("123456");
        loginPage.inputDataOnConfirmPasswordSignUp("123456");
        loginPage.clickSignUpButton();
        verifyEquals(loginPage.getValidateLastNameSignUp(),"Họ không chứa số.");
    }
    @Test
    public void TC_03_SingUp_With_Last_Name_Contains_Alpha_Number_Char(){
        loginPage.inputDataOnFirstNameSignUp(firstName);
        loginPage.inputDataOnLastNameSignUp("Hồ 12");
        loginPage.inputDataOnPhoneEmailSignUp(email);
        loginPage.inputDataOnPasswordSignUp("123456");
        loginPage.inputDataOnConfirmPasswordSignUp("123456");
        loginPage.clickSignUpButton();
        verifyEquals(loginPage.getValidateLastNameSignUp(),"Họ không chứa số.");
    }
    @Test
    public void TC_04_SingUp_With_Last_Name_Contains_Special_Char(){
        loginPage.inputDataOnFirstNameSignUp(firstName);
        loginPage.inputDataOnLastNameSignUp("H@ang");
        loginPage.inputDataOnPhoneEmailSignUp(email);
        loginPage.inputDataOnPasswordSignUp("123456");
        loginPage.inputDataOnConfirmPasswordSignUp("123456");
        loginPage.clickSignUpButton();
        verifyEquals(loginPage.getValidateLastNameSignUp(),"Họ không chứa ký tự đặc biệt.");
    }
    @Test
    public void TC_05_SingUp_With_Last_Name_Contains_All_WhiteSpace_Char(){
        loginPage.inputDataOnFirstNameSignUp("Huy");
        loginPage.inputDataOnLastNameSignUp("       ");
        loginPage.inputDataOnPhoneEmailSignUp(email);
        loginPage.inputDataOnPasswordSignUp("123456");
        loginPage.inputDataOnConfirmPasswordSignUp("123456");
        loginPage.clickSignUpButton();
        verifyEquals(loginPage.getValidateLastNameSignUp(),"Họ là bắt buộc.");
    }
    @Test
    public void TC_06_SingUp_With_Last_Name_Contains_Script_Code(){
        loginPage.inputDataOnFirstNameSignUp(firstName);
        loginPage.inputDataOnLastNameSignUp(GlobalVariables.SCRIPT_CODE);
        loginPage.inputDataOnPhoneEmailSignUp(email);
        loginPage.inputDataOnPasswordSignUp("123456");
        loginPage.inputDataOnConfirmPasswordSignUp("123456");
        loginPage.clickSignUpButton();
        verifyEquals(loginPage.getValidateLastNameSignUp(),"Họ không chứa ký tự đặc biệt.");
    }
    @Test
    public void TC_07_SingUp_With_Last_Name_Contains_HTML_Code(){
        loginPage.inputDataOnFirstNameSignUp(firstName);
        loginPage.inputDataOnLastNameSignUp(GlobalVariables.HTML_CODE);
        loginPage.inputDataOnPhoneEmailSignUp(email);
        loginPage.inputDataOnPasswordSignUp("123456");
        loginPage.inputDataOnConfirmPasswordSignUp("123456");
        loginPage.clickSignUpButton();
        verifyEquals(loginPage.getValidateLastNameSignUp(),"Họ không chứa ký tự đặc biệt.");
    }
    @Test
    public void TC_01_SingUp_With_Phone_Email_Blank(){
        loginPage.inputDataOnFirstNameSignUp(firstName);
        loginPage.inputDataOnLastNameSignUp(lastName);
        loginPage.inputDataOnPhoneEmailSignUp("");
        loginPage.inputDataOnPasswordSignUp("123456");
        loginPage.inputDataOnConfirmPasswordSignUp("123456");
        loginPage.clickSignUpButton();
        verifyEquals(loginPage.getValidatePhoneEmailSignUp(),"Tài khoản là bắt buộc.");
    }
    @Test(enabled = false)
    public void TC_02_SingUp_With_Phone_Other_Area(){
        loginPage.inputDataOnFirstNameSignUp(firstName);
        loginPage.inputDataOnLastNameSignUp(lastName);
        loginPage.inputDataOnPhoneEmailSignUp("0936709449");
        loginPage.inputDataOnPasswordSignUp("123456");
        loginPage.changePhoneCode("(+598) Uruguay");
        loginPage.inputDataOnConfirmPasswordSignUp("123456");
        loginPage.clickSignUpButton();
        verifyEquals(loginPage.getValidatePhoneEmailSignUp(),"Số điện thoại không hợp lệ.");
    }
    @Test
    public void TC_03_SingUp_With_Existed_Phone(){
        loginPage.inputDataOnFirstNameSignUp(firstName);
        loginPage.inputDataOnLastNameSignUp(lastName);
        loginPage.inputDataOnPhoneEmailSignUp("0936709449");
        loginPage.inputDataOnPasswordSignUp("123456");
        loginPage.inputDataOnConfirmPasswordSignUp("123456");
        loginPage.clickSignUpButton();
        verifyEquals(loginPage.getValidatePhoneEmailSignUp(),"Tài khoản đã tồn tại trên hệ thống Hahalolo");
    }
    @Test
    public void TC_03_SingUp_With_Invalid_Phone(){
        loginPage.inputDataOnFirstNameSignUp(firstName);
        loginPage.inputDataOnLastNameSignUp(lastName);
        loginPage.inputDataOnPhoneEmailSignUp("01234");
        loginPage.inputDataOnPasswordSignUp("123456");
        loginPage.inputDataOnConfirmPasswordSignUp("123456");
        loginPage.clickSignUpButton();
        verifyEquals(loginPage.getValidatePhoneEmailSignUp(),"Tài khoản không hợp lệ.");
    }
    @Test
    public void TC_03_SingUp_With_Invalid_Email(){
        loginPage.inputDataOnFirstNameSignUp(firstName);
        loginPage.inputDataOnLastNameSignUp(lastName);
        loginPage.inputDataOnPhoneEmailSignUp("huyho@gmail.");
        loginPage.inputDataOnPasswordSignUp("123456");
        loginPage.inputDataOnConfirmPasswordSignUp("123456");
        loginPage.clickSignUpButton();
        verifyEquals(loginPage.getValidatePhoneEmailSignUp(),"Tài khoản không hợp lệ.");
    }
    @Test
    public void TC_03_SingUp_With_Existed_Email(){
        loginPage.inputDataOnFirstNameSignUp(firstName);
        loginPage.inputDataOnLastNameSignUp(lastName);
        loginPage.inputDataOnPhoneEmailSignUp("balo_04@mailinator.com");
        loginPage.inputDataOnPasswordSignUp("123456");
        loginPage.inputDataOnConfirmPasswordSignUp("123456");
        loginPage.clickSignUpButton();
        verifyEquals(loginPage.getValidatePhoneEmailSignUp(),"Tài khoản đã tồn tại trên hệ thống Hahalolo");
    }
    @Test
    public void TC_03_SingUp_With_Email_Has_Uppercase(){
        loginPage.inputDataOnFirstNameSignUp(firstName);
        loginPage.inputDataOnLastNameSignUp(lastName);
        loginPage.inputDataOnPhoneEmailSignUp(email.toUpperCase());
        loginPage.inputDataOnPasswordSignUp("123456");
        loginPage.inputDataOnConfirmPasswordSignUp("123456");
        verifyPage =loginPage.clickSignUpButton();
        verifyTrue(verifyPage.checkTitlePageVerifyEmail());
//        Assert.assertTrue(verifyPage.checkEmailDisplayOnRegisterPage(email));
    }
    @Test
    public void TC_01_SingUp_With_Blank_Password(){
        loginPage.inputDataOnFirstNameSignUp(firstName);
        loginPage.inputDataOnLastNameSignUp(lastName);
        loginPage.inputDataOnPhoneEmailSignUp(email);
        loginPage.inputDataOnPasswordSignUp("");
        loginPage.inputDataOnConfirmPasswordSignUp("123456");
        loginPage.clickSignUpButton();
        verifyEquals(loginPage.getValidatePasswordSignUp(),"Mật khẩu là bắt buộc.");
    }
    @Test
    public void TC_02_SingUp_With_Password_Less_Than_6_Chars(){
        loginPage.inputDataOnFirstNameSignUp(firstName);
        loginPage.inputDataOnLastNameSignUp(lastName);
        loginPage.inputDataOnPhoneEmailSignUp(email);
        loginPage.inputDataOnPasswordSignUp("1234");
        loginPage.inputDataOnConfirmPasswordSignUp("123456");
        loginPage.clickSignUpButton();
        verifyEquals(loginPage.getValidatePasswordSignUp(),"Giới hạn tối thiểu của Mật khẩu là 6 kí tự");
    }
    @Test
    public void TC_03_SingUp_With_Password_Less_Than_128_Chars(){
        loginPage.inputDataOnFirstNameSignUp(firstName);
        loginPage.inputDataOnLastNameSignUp(lastName);
        loginPage.inputDataOnPhoneEmailSignUp(email);
        loginPage.inputDataOnPasswordSignUp(randomPassword(130));
        loginPage.inputDataOnConfirmPasswordSignUp("123456");
        loginPage.clickSignUpButton();
        verifyEquals(loginPage.getValidatePasswordSignUp(),"Giới hạn tối thiểu của Mật khẩu là 128 kí tự");
    }
    @Test
    public void TC_04_SingUp_With_Password_Not_Same_Confirm_Pass(){
        loginPage.inputDataOnFirstNameSignUp(firstName);
        loginPage.inputDataOnLastNameSignUp(lastName);
        loginPage.inputDataOnPhoneEmailSignUp(email);
        loginPage.inputDataOnPasswordSignUp("123456");
        loginPage.inputDataOnConfirmPasswordSignUp("123457");
        loginPage.clickSignUpButton();
        verifyEquals(loginPage.getValidateConfirmPassSignUp(),"Mật khẩu xác nhận phải trùng với Mật khẩu");
    }
    @Test
    public void TC_01_SingUp_With_Blank_ConfirmPassword(){
        loginPage.inputDataOnFirstNameSignUp(firstName);
        loginPage.inputDataOnLastNameSignUp(lastName);
        loginPage.inputDataOnPhoneEmailSignUp(email);
        loginPage.inputDataOnPasswordSignUp("123456");
        loginPage.inputDataOnConfirmPasswordSignUp("");
        loginPage.clickSignUpButton();
        verifyEquals(loginPage.getValidateConfirmPassSignUp(),"Mật khẩu xác nhận là bắt buộc.");
    }
    @AfterTest
    public void closeBrowserAndDriver(){
        closeBrowserAndDriver(driver);
    }
}