package testcases.newsfeed.StartIngApp;

import PageObject.newsfeed.Starting.NewsFeed_Login;
import PageObject.newsfeed.Starting.NewsFeed_VerifyAccount;
import common.Function.AbstractTest;
import common.Global_Constant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class SignUpTestcase extends AbstractTest {
    WebDriver driver;
    NewsFeed_VerifyAccount verifyPage;
    NewsFeed_Login loginPage;
    public String email ="huy.hodoan"+randomEmail()+"@mailinantor.com";
    @BeforeClass
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","browserDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(Global_Constant.URL_NEWS_FEED_LOGIN);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Global_Constant.LONG_TIME_OUT, TimeUnit.SECONDS);
        loginPage = new NewsFeed_Login(driver);
    }
    @BeforeMethod
    public void checkLanguageDisplay(){
        loginPage.checkLanguageButton();
    }
    @Test
    public void TC_01_SingUp_With_Blank_First_Name(){
        loginPage.inputDataOnFirstNameSignUp("");
        loginPage.inputDataOnLastNameSignUp("Hồ");
        loginPage.inputDataOnPhoneEmailSignUp(email);
        loginPage.inputDataOnPasswordSignUp("123456");
        loginPage.inputDataOnConfirmPasswordSignUp("123456");
        loginPage.clickSignUpButton();
        Assert.assertEquals(loginPage.getValidateFirstNameSignUp(),"Tên là bắt buộc.");
    }
    @Test
    public void TC_02_SingUp_With_First_Name_Contains_Number_Char(){
        loginPage.inputDataOnFirstNameSignUp("12345647");
        loginPage.inputDataOnLastNameSignUp("Hồ");
        loginPage.inputDataOnPhoneEmailSignUp(email);
        loginPage.inputDataOnPasswordSignUp("123456");
        loginPage.inputDataOnConfirmPasswordSignUp("123456");
        loginPage.clickSignUpButton();
        Assert.assertEquals(loginPage.getValidateFirstNameSignUp(),"Tên không chứa số.");
    }
    @Test
    public void TC_03_SingUp_With_First_Name_Contains_Alpha_Number_Char(){
        loginPage.inputDataOnFirstNameSignUp("Huy12");
        loginPage.inputDataOnLastNameSignUp("Hồ");
        loginPage.inputDataOnPhoneEmailSignUp(email);
        loginPage.inputDataOnPasswordSignUp("123456");
        loginPage.inputDataOnConfirmPasswordSignUp("123456");
        loginPage.clickSignUpButton();
        Assert.assertEquals(loginPage.getValidateFirstNameSignUp(),"Tên không chứa số.");
    }
    @Test
    public void TC_04_SingUp_With_First_Name_Contains_Special_Char(){
        loginPage.inputDataOnFirstNameSignUp("H@ang @anh");
        loginPage.inputDataOnLastNameSignUp("Hồ");
        loginPage.inputDataOnPhoneEmailSignUp(email);
        loginPage.inputDataOnPasswordSignUp("123456");
        loginPage.inputDataOnConfirmPasswordSignUp("123456");
        loginPage.clickSignUpButton();
        Assert.assertEquals(loginPage.getValidateFirstNameSignUp(),"Tên không chứa ký tự đặc biệt.");
    }
    @Test
    public void TC_05_SingUp_With_First_Name_Contains_All_WhiteSpace_Char(){
        loginPage.inputDataOnFirstNameSignUp("           ");
        loginPage.inputDataOnLastNameSignUp("Hồ");
        loginPage.inputDataOnPhoneEmailSignUp(email);
        loginPage.inputDataOnPasswordSignUp("123456");
        loginPage.inputDataOnConfirmPasswordSignUp("123456");
        loginPage.clickSignUpButton();
        Assert.assertEquals(loginPage.getValidateFirstNameSignUp(),"Tên là bắt buộc.");
    }
    @Test
    public void TC_06_SingUp_With_First_Name_Contains_Script_Code(){
        loginPage.inputDataOnFirstNameSignUp(Global_Constant.SCRIPT_CODE);
        loginPage.inputDataOnLastNameSignUp("Hồ");
        loginPage.inputDataOnPhoneEmailSignUp(email);
        loginPage.inputDataOnPasswordSignUp("123456");
        loginPage.inputDataOnConfirmPasswordSignUp("123456");
        loginPage.clickSignUpButton();
        Assert.assertEquals(loginPage.getValidateFirstNameSignUp(),"Tên không chứa ký tự đặc biệt.");
    }
    @Test
    public void TC_07_SingUp_With_First_Name_Contains_HTML_Code(){
        loginPage.inputDataOnFirstNameSignUp(Global_Constant.HTML_CODE);
        loginPage.inputDataOnLastNameSignUp("Hồ");
        loginPage.inputDataOnPhoneEmailSignUp(email);
        loginPage.inputDataOnPasswordSignUp("123456");
        loginPage.inputDataOnConfirmPasswordSignUp("123456");
        loginPage.clickSignUpButton();
        Assert.assertEquals(loginPage.getValidateFirstNameSignUp(),"Tên không chứa ký tự đặc biệt.");
    }

    @Test
    public void TC_01_SingUp_With_Blank_Last_Name(){
        loginPage.inputDataOnFirstNameSignUp("Huy");
        loginPage.inputDataOnLastNameSignUp("");
        loginPage.inputDataOnPhoneEmailSignUp(email);
        loginPage.inputDataOnPasswordSignUp("123456");
        loginPage.inputDataOnConfirmPasswordSignUp("123456");
        loginPage.clickSignUpButton();
        Assert.assertEquals(loginPage.getValidateLastNameSignUp(),"Họ là bắt buộc.");
    }
    @Test
    public void TC_02_SingUp_With_Last_Name_Contains_Number_Char(){
        loginPage.inputDataOnFirstNameSignUp("Huy");
        loginPage.inputDataOnLastNameSignUp("123456");
        loginPage.inputDataOnPhoneEmailSignUp(email);
        loginPage.inputDataOnPasswordSignUp("123456");
        loginPage.inputDataOnConfirmPasswordSignUp("123456");
        loginPage.clickSignUpButton();
        Assert.assertEquals(loginPage.getValidateLastNameSignUp(),"Họ không chứa số.");
    }
    @Test
    public void TC_03_SingUp_With_Last_Name_Contains_Alpha_Number_Char(){
        loginPage.inputDataOnFirstNameSignUp("Huy");
        loginPage.inputDataOnLastNameSignUp("Hồ 12");
        loginPage.inputDataOnPhoneEmailSignUp(email);
        loginPage.inputDataOnPasswordSignUp("123456");
        loginPage.inputDataOnConfirmPasswordSignUp("123456");
        loginPage.clickSignUpButton();
        Assert.assertEquals(loginPage.getValidateLastNameSignUp(),"Họ không chứa số.");
    }
    @Test
    public void TC_04_SingUp_With_Last_Name_Contains_Special_Char(){
        loginPage.inputDataOnFirstNameSignUp("Huy");
        loginPage.inputDataOnLastNameSignUp("H@ang");
        loginPage.inputDataOnPhoneEmailSignUp(email);
        loginPage.inputDataOnPasswordSignUp("123456");
        loginPage.inputDataOnConfirmPasswordSignUp("123456");
        loginPage.clickSignUpButton();
        Assert.assertEquals(loginPage.getValidateLastNameSignUp(),"Họ không chứa ký tự đặc biệt.");
    }
    @Test
    public void TC_05_SingUp_With_Last_Name_Contains_All_WhiteSpace_Char(){
        loginPage.inputDataOnFirstNameSignUp("Huy");
        loginPage.inputDataOnLastNameSignUp("       ");
        loginPage.inputDataOnPhoneEmailSignUp(email);
        loginPage.inputDataOnPasswordSignUp("123456");
        loginPage.inputDataOnConfirmPasswordSignUp("123456");
        loginPage.clickSignUpButton();
        Assert.assertEquals(loginPage.getValidateLastNameSignUp(),"Họ là bắt buộc.");
    }
    @Test
    public void TC_06_SingUp_With_Last_Name_Contains_Script_Code(){
        loginPage.inputDataOnFirstNameSignUp("Huy");
        loginPage.inputDataOnLastNameSignUp(Global_Constant.SCRIPT_CODE);
        loginPage.inputDataOnPhoneEmailSignUp(email);
        loginPage.inputDataOnPasswordSignUp("123456");
        loginPage.inputDataOnConfirmPasswordSignUp("123456");
        loginPage.clickSignUpButton();
        Assert.assertEquals(loginPage.getValidateLastNameSignUp(),"Họ không chứa ký tự đặc biệt.");
    }
    @Test
    public void TC_07_SingUp_With_Last_Name_Contains_HTML_Code(){
        loginPage.inputDataOnFirstNameSignUp("Huy");
        loginPage.inputDataOnLastNameSignUp(Global_Constant.HTML_CODE);
        loginPage.inputDataOnPhoneEmailSignUp(email);
        loginPage.inputDataOnPasswordSignUp("123456");
        loginPage.inputDataOnConfirmPasswordSignUp("123456");
        loginPage.clickSignUpButton();
        Assert.assertEquals(loginPage.getValidateLastNameSignUp(),"Họ không chứa ký tự đặc biệt.");
    }
    @Test
    public void TC_01_SingUp_With_Phone_Email_Blank(){
        loginPage.inputDataOnFirstNameSignUp("Huy");
        loginPage.inputDataOnLastNameSignUp("Hồ");
        loginPage.inputDataOnPhoneEmailSignUp("");
        loginPage.inputDataOnPasswordSignUp("123456");
        loginPage.inputDataOnConfirmPasswordSignUp("123456");
        loginPage.clickSignUpButton();
        Assert.assertEquals(loginPage.getValidatePhoneEmailSignUp(),"Tài khoản là bắt buộc.");
    }
    @Ignore
    public void TC_02_SingUp_With_Phone_Other_Area(){
        loginPage.inputDataOnFirstNameSignUp("Huy");
        loginPage.inputDataOnLastNameSignUp("Hồ");
        loginPage.inputDataOnPhoneEmailSignUp("0936709449");
        loginPage.inputDataOnPasswordSignUp("123456");
        loginPage.changePhoneCode("(+598) Uruguay");
        loginPage.inputDataOnConfirmPasswordSignUp("123456");
        loginPage.clickSignUpButton();
        Assert.assertEquals(loginPage.getValidatePhoneEmailSignUp(),"Số điện thoại không hợp lệ.");
    }
    @Test
    public void TC_03_SingUp_With_Existed_Phone(){
        loginPage.inputDataOnFirstNameSignUp("Huy");
        loginPage.inputDataOnLastNameSignUp("Hồ");
        loginPage.inputDataOnPhoneEmailSignUp("0936709449");
        loginPage.inputDataOnPasswordSignUp("123456");
        loginPage.inputDataOnConfirmPasswordSignUp("123456");
        loginPage.clickSignUpButton();
        Assert.assertEquals(loginPage.getValidatePhoneEmailSignUp(),"Tài khoản đã tồn tại trên hệ thống Hahalolo");
    }
    @Test
    public void TC_03_SingUp_With_Invalid_Phone(){
        loginPage.inputDataOnFirstNameSignUp("Huy");
        loginPage.inputDataOnLastNameSignUp("Hồ");
        loginPage.inputDataOnPhoneEmailSignUp("01234");
        loginPage.inputDataOnPasswordSignUp("123456");
        loginPage.inputDataOnConfirmPasswordSignUp("123456");
        loginPage.clickSignUpButton();
        Assert.assertEquals(loginPage.getValidatePhoneEmailSignUp(),"Tài khoản không hợp lệ.");
    }
    @Test
    public void TC_03_SingUp_With_Invalid_Email(){
        loginPage.inputDataOnFirstNameSignUp("Huy");
        loginPage.inputDataOnLastNameSignUp("Hồ");
        loginPage.inputDataOnPhoneEmailSignUp("huyho@gmail.");
        loginPage.inputDataOnPasswordSignUp("123456");
        loginPage.inputDataOnConfirmPasswordSignUp("123456");
        loginPage.clickSignUpButton();
        Assert.assertEquals(loginPage.getValidatePhoneEmailSignUp(),"Tài khoản không hợp lệ.");
    }
    @Test
    public void TC_03_SingUp_With_Existed_Email(){
        loginPage.inputDataOnFirstNameSignUp("Huy");
        loginPage.inputDataOnLastNameSignUp("Hồ");
        loginPage.inputDataOnPhoneEmailSignUp("balo_04@mailinator.com");
        loginPage.inputDataOnPasswordSignUp("123456");
        loginPage.inputDataOnConfirmPasswordSignUp("123456");
        loginPage.clickSignUpButton();
        Assert.assertEquals(loginPage.getValidatePhoneEmailSignUp(),"Tài khoản đã tồn tại trên hệ thống Hahalolo");
    }
    @Test
    public void TC_03_SingUp_With_Email_Has_Uppercase(){
        loginPage.inputDataOnFirstNameSignUp("Huy");
        loginPage.inputDataOnLastNameSignUp("Hồ");
        loginPage.inputDataOnPhoneEmailSignUp(email.toUpperCase());
        loginPage.inputDataOnPasswordSignUp("123456");
        loginPage.inputDataOnConfirmPasswordSignUp("123456");
        loginPage.clickSignUpButton();
        verifyPage = new NewsFeed_VerifyAccount(driver);
        Assert.assertTrue(verifyPage.checkTitlePageVerifyEmail());
//        Assert.assertTrue(verifyPage.checkEmailDisplayOnRegisterPage(email));
    }
    @Test
    public void TC_01_SingUp_With_Blank_Password(){
        loginPage.inputDataOnFirstNameSignUp("Huy");
        loginPage.inputDataOnLastNameSignUp("Hồ");
        loginPage.inputDataOnPhoneEmailSignUp(email);
        loginPage.inputDataOnPasswordSignUp("");
        loginPage.inputDataOnConfirmPasswordSignUp("123456");
        loginPage.clickSignUpButton();
        Assert.assertEquals(loginPage.getValidatePasswordSignUp(),"Mật khẩu là bắt buộc.");
    }
    @Test
    public void TC_02_SingUp_With_Password_Less_Than_6_Chars(){
        loginPage.inputDataOnFirstNameSignUp("Huy");
        loginPage.inputDataOnLastNameSignUp("Hồ");
        loginPage.inputDataOnPhoneEmailSignUp(email);
        loginPage.inputDataOnPasswordSignUp("1234");
        loginPage.inputDataOnConfirmPasswordSignUp("123456");
        loginPage.clickSignUpButton();
        Assert.assertEquals(loginPage.getValidatePasswordSignUp(),"Giới hạn tối thiểu của Mật khẩu là 6 kí tự");
    }
    @Test
    public void TC_03_SingUp_With_Password_Less_Than_128_Chars(){
        loginPage.inputDataOnFirstNameSignUp("Huy");
        loginPage.inputDataOnLastNameSignUp("Hồ");
        loginPage.inputDataOnPhoneEmailSignUp(email);
        loginPage.inputDataOnPasswordSignUp(randomPassword(130));
        loginPage.inputDataOnConfirmPasswordSignUp("123456");
        loginPage.clickSignUpButton();
        Assert.assertEquals(loginPage.getValidatePasswordSignUp(),"Giới hạn tối thiểu của Mật khẩu là 128 kí tự");
    }
    @Test
    public void TC_04_SingUp_With_Password_Not_Same_Confirm_Pass(){
        loginPage.inputDataOnFirstNameSignUp("Huy");
        loginPage.inputDataOnLastNameSignUp("Hồ");
        loginPage.inputDataOnPhoneEmailSignUp(email);
        loginPage.inputDataOnPasswordSignUp("123456");
        loginPage.inputDataOnConfirmPasswordSignUp("123457");
        loginPage.clickSignUpButton();
        Assert.assertEquals(loginPage.getValidateConfirmPassSignUp(),"Mật khẩu xác nhận phải trùng với Mật khẩu");
    }
    @Test
    public void TC_01_SingUp_With_Blank_ConfirmPassword(){
        loginPage.inputDataOnFirstNameSignUp("Huy");
        loginPage.inputDataOnLastNameSignUp("Hồ");
        loginPage.inputDataOnPhoneEmailSignUp(email);
        loginPage.inputDataOnPasswordSignUp("123456");
        loginPage.inputDataOnConfirmPasswordSignUp("");
        loginPage.clickSignUpButton();
        Assert.assertEquals(loginPage.getValidateConfirmPassSignUp(),"Mật khẩu xác nhận là bắt buộc.");
    }
    @AfterTest
    public void closeBrowserAndDriver(){
        closeBrowserAndDriver(driver);
    }
}