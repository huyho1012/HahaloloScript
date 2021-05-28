import Interface.Register_PageUI;
import PageObject.Login_PageObject;
import PageObject.Newsfeed.Newsfeed_PageObject;
import PageObject.Register_PageObject;
import common.DriverBrowser.DriverFactory;
import common.DriverBrowser.DriverManager;
import common.GeneralHandler.AbstractTest;
import common.GeneralHandler.PageGenerator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class testcase_Login extends AbstractTest {


    WebDriver driver;
    DriverManager driverManager;
    Login_PageObject loginPage;
    Register_PageObject registerPage;
    Newsfeed_PageObject newsfeedPage;
    @Parameters("browser")
    @BeforeTest
    public void createDriverAndInitPage(String browserName){
        driverManager = DriverFactory.getBrowser(browserName);
        driver = driverManager.getDriver();
        initPage();
        openURL(driver,"https://www.hahalolo.com/auth/signin");

    }


//    @Test
//    public void checkLoginSuccess(){
//        verifyTrue(loginPage.checkPlaceholderOfFieldPasswordIsDisplayedCorrectly());
//        verifyTrue(loginPage.checkPlaceholderOfFieldUsernameIsDisplayedCorrectly());
//        loginPage.enterUsernameForLogin("0936709449");
//        loginPage.enterPasswordForLogin("20b87bis");
//        loginPage.clickToButtonLogin();
//
//    }

    @Test
    public void registerNewAccount(){
        String email = createVirtualMail();
        registerPage.enterFirstNameToRegister("Huy");
        registerPage.enterLastNameToRegister("Hồ");
        registerPage.enterUsernameToRegister(email);
        registerPage.enterPasswordToRegister("123456");
        registerPage.enterConfirmPassToRegister("123456");
        registerPage.clickToButtonRegister();
       String verifyCode =  registerPage.getVerificationCode(email);
       registerPage.enterVerifyCodeToRegister(verifyCode);
       registerPage.clickToButtonVerify();
       setTimeDelay(2);
       newsfeedPage.updateNewInfo("12","10","1992");

        setTimeDelay(2);

    }

    public void initPage(){
        loginPage = PageGenerator.createLoginNewsfeedPage(driver);
        registerPage = PageGenerator.createRegisterForm(driver);
        newsfeedPage = PageGenerator.createNewsfeedPage(driver);
    }
}
