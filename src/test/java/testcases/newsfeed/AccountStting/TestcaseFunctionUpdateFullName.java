package testcases.newsfeed.AccountStting;

import CommonHelper.DriverBrowser.BrowserDriver;
import CommonHelper.DriverBrowser.DriverManager;
import CommonHelper.Function.AbstractTest;
import CommonHelper.Function.PageGenerator;
import CommonHelper.GlobalVariables;
import Newsfeed.HeaderMenu.UserSetting.PageObject.GeneralSetting;
import Newsfeed.TabFeed.NewsFeedTab;
import StartingApp.Login.LoginNewsfeed;
import com.google.inject.internal.cglib.proxy.$Dispatcher;
import org.openqa.selenium.WebDriver;

public class TestcaseFunctionUpdateFullName extends AbstractTest {

    String fullName;
    String account = "balo04@mailinator.com";
    String passWord = "123456";
    LoginNewsfeed loginNewsfeedPage;
    NewsFeedTab newsFeedHomePage;
    GeneralSetting  accountGeneralSetting;
    WebDriver driver;
    DriverManager driverManager;
    public void Precondition(String browserName){
       driverManager = BrowserDriver.getBrowser(browserName);
       driver = driverManager.getDriver(GlobalVariables.URL_NEWS_FEED_LOGIN);
       loginNewsfeedPage = PageGenerator.createLoginNewsfeedPage(driver);

       log.info("Precondition step 1.1 - Login Newsfeed - Enter username");
       loginNewsfeedPage.enterDataOnDynamicTextField("",account);

       log.info("Precondition step 1.2 - Lgin Newsfeed - Enter password");
       loginNewsfeedPage.enterDataOnDynamicTextField("",passWord);

       log.info("Precondition step 1.3 - Login Newsfeed - Click Login Button");
       loginNewsfeedPage.clickLoginButton();
       newsFeedHomePage = PageGenerator.getNewsFeedPage(driver);

       fullName = newsFeedHomePage.getFullNameDisplayOnMyAccount();

        log.info("Precondition step 2.1 - AccountSetting page - Click Account Setting on menu");

        newsFeedHomePage.clickItemOnSettingMenu(driver,"");
        accountGeneralSetting = PageGenerator.createAccountSettingGeneralTab(driver);

        log.info("Precondition step 2.2 - AccountSetting page - Verify full name display correct");
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(),fullName);

        accountGeneralSetting.clickEditButton();
    }

    public void TC01_Negative_Validation_FirstName(){
        log.info("Step 1 - Validation - Blank");
        log.info("Step 1.1 - Clear first name");
        accountGeneralSetting.clearDataOnFullNameFunction("");
        log.info("Step 1.2 - Click button Save Changes");
        accountGeneralSetting.clickButtonSave();
        log.info("Step 1.2 - Check error message");
        verifyEquals(accountGeneralSetting.getErrorValidationMessage(),"");

        log.info("Step 2 - Validation - All whitespace");
        log.info("Step 2.1 - Input first name");
        accountGeneralSetting.enterDataOnFullNameFunction("");
        log.info("Step 2.2 - Click button Save Changes");
        accountGeneralSetting.clickButtonSave();
        log.info("Step 2.3 - Check error message");
        verifyEquals(accountGeneralSetting.getErrorValidationMessage(),"");

        log.info("Step 1 - Validation - Number");
        accountGeneralSetting.enterDataOnFullNameFunction("");
        accountGeneralSetting.clickButtonSave();
        verifyEquals(accountGeneralSetting.getErrorValidationMessage(),"");

        log.info("Step 1 - Validation - Alpha number");
        accountGeneralSetting.enterDataOnFullNameFunction("");
        accountGeneralSetting.clickButtonSave();
        verifyEquals(accountGeneralSetting.getErrorValidationMessage(),"");

        log.info("Step 1 - Validation - 2 whitespace on middle");
        accountGeneralSetting.enterDataOnFullNameFunction("");
        accountGeneralSetting.clickButtonSave();
        verifyEquals(accountGeneralSetting.getErrorValidationMessage(),"");

        log.info("Step 1 - Validation -Script Code");
        accountGeneralSetting.enterDataOnFullNameFunction("");
        accountGeneralSetting.clickButtonSave();
        verifyEquals(accountGeneralSetting.getErrorValidationMessage(),"");

        log.info("Step 1 - Validation - Character");
        accountGeneralSetting.enterDataOnFullNameFunction("");
        accountGeneralSetting.clickButtonSave();
        verifyEquals(accountGeneralSetting.getErrorValidationMessage(),"");

        log.info("Step 1 - Validation - More than 5 word");
        accountGeneralSetting.enterDataOnFullNameFunction("");
        accountGeneralSetting.clickButtonSave();
        verifyEquals(accountGeneralSetting.getErrorValidationMessage(),"");

        log.info("Step 1 - Validation - More than 126 character");
        accountGeneralSetting.enterDataOnFullNameFunction("");
        accountGeneralSetting.clickButtonSave();
        verifyEquals(accountGeneralSetting.getErrorValidationMessage(),"");
    }
    public void TC02_Positive_Validation_FirstName() {
        log.info("Step 1 - Enter a First Name");
        accountGeneralSetting.enterDataOnFullNameFunction("");
        accountGeneralSetting.clickButtonSave();
        verifyTrue(accountGeneralSetting.checkFormConfirmPasswordIsDisplay());
        accountGeneralSetting.enterConfirmPassword();
        accountGeneralSetting.clickConfirmButton();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
    }

    public void TC02_Positive_Validation_FirstName() {
        accountGeneralSetting.clickEditButton();
        log.info("Step 1 - Enter a First Name");
        accountGeneralSetting.enterDataOnFullNameFunction("");
        accountGeneralSetting.clickButtonSave();
        verifyTrue(accountGeneralSetting.checkFormConfirmPasswordIsDisplay());
        accountGeneralSetting.enterConfirmPassword();
        accountGeneralSetting.clickConfirmButton();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
    }

    public void TC02_Positive_Validation_FirstName() {
        accountGeneralSetting.clickEditButton();
        log.info("Step 1 - Enter a First Name");
        accountGeneralSetting.enterDataOnFullNameFunction("");
        accountGeneralSetting.clickButtonSave();
        verifyTrue(accountGeneralSetting.checkFormConfirmPasswordIsDisplay());
        accountGeneralSetting.enterConfirmPassword();
        accountGeneralSetting.clickConfirmButton();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
    }

    public void TC03_Positive_Validation_FirstName_Uppercase() {
        accountGeneralSetting.clickEditButton();
        log.info("Step 1 - Enter a First Name");
        accountGeneralSetting.enterDataOnFullNameFunction("");
        accountGeneralSetting.clickButtonSave();
        verifyTrue(accountGeneralSetting.checkFormConfirmPasswordIsDisplay());
        accountGeneralSetting.enterConfirmPassword();
        accountGeneralSetting.clickConfirmButton();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
    }

    public void TC04_Positive_Validation_FirstName_LowerCase() {
        accountGeneralSetting.clickEditButton();
        log.info("Step 1 - Enter a First Name");
        accountGeneralSetting.enterDataOnFullNameFunction("");
        accountGeneralSetting.clickButtonSave();
        verifyTrue(accountGeneralSetting.checkFormConfirmPasswordIsDisplay());
        accountGeneralSetting.enterConfirmPassword();
        accountGeneralSetting.clickConfirmButton();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
    }

    public void TC05_Positive_Validation_FirstName_Whitespace_On_First() {
        accountGeneralSetting.clickEditButton();
        log.info("Step 1 - Enter a First Name");
        accountGeneralSetting.enterDataOnFullNameFunction("");
        accountGeneralSetting.clickButtonSave();
        verifyTrue(accountGeneralSetting.checkFormConfirmPasswordIsDisplay());
        accountGeneralSetting.enterConfirmPassword();
        accountGeneralSetting.clickConfirmButton();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
    }

    public void TC06_Positive_Validation_FirstName_Whitespace_On_Last() {
        accountGeneralSetting.clickEditButton();
        log.info("Step 1 - Enter a First Name");
        accountGeneralSetting.enterDataOnFullNameFunction("");
        accountGeneralSetting.clickButtonSave();
        verifyTrue(accountGeneralSetting.checkFormConfirmPasswordIsDisplay());
        accountGeneralSetting.enterConfirmPassword();
        accountGeneralSetting.clickConfirmButton();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
    }

    public void TC07_Negative_Validation_Middle() {
        accountGeneralSetting.clickEditButton();
        log.info("Step 1 - Validation - Number");
        accountGeneralSetting.enterDataOnFullNameFunction("");
        accountGeneralSetting.clickButtonSave();
        verifyEquals(accountGeneralSetting.getErrorValidationMessage(),"");

        log.info("Step 1 - Validation - Alpha number");
        accountGeneralSetting.enterDataOnFullNameFunction("");
        accountGeneralSetting.clickButtonSave();
        verifyEquals(accountGeneralSetting.getErrorValidationMessage(),"");

        log.info("Step 1 - Validation - 2 whitespace on middle");
        accountGeneralSetting.enterDataOnFullNameFunction("");
        accountGeneralSetting.clickButtonSave();
        verifyEquals(accountGeneralSetting.getErrorValidationMessage(),"");

        log.info("Step 1 - Validation -Script Code");
        accountGeneralSetting.enterDataOnFullNameFunction("");
        accountGeneralSetting.clickButtonSave();
        verifyEquals(accountGeneralSetting.getErrorValidationMessage(),"");

        log.info("Step 1 - Validation - Character");
        accountGeneralSetting.enterDataOnFullNameFunction("");
        accountGeneralSetting.clickButtonSave();
        verifyEquals(accountGeneralSetting.getErrorValidationMessage(),"");

        log.info("Step 1 - Validation - More than 5 word");
        accountGeneralSetting.enterDataOnFullNameFunction("");
        accountGeneralSetting.clickButtonSave();
        verifyEquals(accountGeneralSetting.getErrorValidationMessage(),"");

        log.info("Step 1 - Validation - More than 126 character");
        accountGeneralSetting.clearDataOnFullNameFunction("");
        accountGeneralSetting.clickButtonSave();
        verifyEquals(accountGeneralSetting.getErrorValidationMessage(),"");
    }
    public void TC06_Positive_Validation_MiddleName() {
        log.info("Step 1 - Enter a Middle Name");
        accountGeneralSetting.enterDataOnFullNameFunction("");
        accountGeneralSetting.clickButtonSave();
        verifyTrue(accountGeneralSetting.checkFormConfirmPasswordIsDisplay());
        accountGeneralSetting.enterConfirmPassword();
        accountGeneralSetting.clickConfirmButton();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
    }

    public void TC06_Positive_Validation_MiddleName_Blank() {
        accountGeneralSetting.clickEditButton();
        log.info("Step 1 - Enter a Middle Name");
        accountGeneralSetting.enterDataOnFullNameFunction("");
        accountGeneralSetting.clickButtonSave();
        verifyTrue(accountGeneralSetting.checkFormConfirmPasswordIsDisplay());
        accountGeneralSetting.enterConfirmPassword();
        accountGeneralSetting.clickConfirmButton();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
    }
    public void TC06_Positive_Validation_MiddleName_Contains_Whitespace() {
        accountGeneralSetting.clickEditButton();
        log.info("Step 1 - Enter a Middle Name");
        accountGeneralSetting.enterDataOnFullNameFunction("");
        accountGeneralSetting.clickButtonSave();
        verifyTrue(accountGeneralSetting.checkFormConfirmPasswordIsDisplay());
        accountGeneralSetting.enterConfirmPassword();
        accountGeneralSetting.clickConfirmButton();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
    }

    public void TC03_Positive_Validation_MiddleName_Uppercase() {
        accountGeneralSetting.clickEditButton();
        log.info("Step 1 - Enter a First Name");
        accountGeneralSetting.enterDataOnFullNameFunction("");
        accountGeneralSetting.clickButtonSave();
        verifyTrue(accountGeneralSetting.checkFormConfirmPasswordIsDisplay());
        accountGeneralSetting.enterConfirmPassword();
        accountGeneralSetting.clickConfirmButton();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
    }

    public void TC04_Positive_Validation_MiddleName_LowerCase() {
        accountGeneralSetting.clickEditButton();
        log.info("Step 1 - Enter a First Name");
        accountGeneralSetting.enterDataOnFullNameFunction("");
        accountGeneralSetting.clickButtonSave();
        verifyTrue(accountGeneralSetting.checkFormConfirmPasswordIsDisplay());
        accountGeneralSetting.enterConfirmPassword();
        accountGeneralSetting.clickConfirmButton();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
    }

    public void TC05_Positive_Validation_MiddleName_Whitespace_On_First() {
        accountGeneralSetting.clickEditButton();
        log.info("Step 1 - Enter a First Name");
        accountGeneralSetting.enterDataOnFullNameFunction("");
        accountGeneralSetting.clickButtonSave();
        verifyTrue(accountGeneralSetting.checkFormConfirmPasswordIsDisplay());
        accountGeneralSetting.enterConfirmPassword();
        accountGeneralSetting.clickConfirmButton();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
    }

    public void TC06_Positive_Validation_MiddleName_Whitespace_On_Last() {
        accountGeneralSetting.clickEditButton();
        log.info("Step 1 - Enter a First Name");
        accountGeneralSetting.enterDataOnFullNameFunction("");
        accountGeneralSetting.clickButtonSave();
        verifyTrue(accountGeneralSetting.checkFormConfirmPasswordIsDisplay());
        accountGeneralSetting.enterConfirmPassword();
        accountGeneralSetting.clickConfirmButton();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
    }

    public void TC01_Negative_Validation_FirstName(){
        log.info("Step 1 - Validation - Blank");
        accountGeneralSetting.clearDataOnFullNameFunction("");
        accountGeneralSetting.clickButtonSave();
        verifyEquals(accountGeneralSetting.getErrorValidationMessage(),"");

        log.info("Step 1 - Validation - All whitespace");
        accountGeneralSetting.enterDataOnFullNameFunction("");
        accountGeneralSetting.clickButtonSave();
        verifyEquals(accountGeneralSetting.getErrorValidationMessage(),"");

        log.info("Step 1 - Validation - Number");
        accountGeneralSetting.enterDataOnFullNameFunction("");
        accountGeneralSetting.clickButtonSave();
        verifyEquals(accountGeneralSetting.getErrorValidationMessage(),"");

        log.info("Step 1 - Validation - Alpha number");
        accountGeneralSetting.enterDataOnFullNameFunction("");
        accountGeneralSetting.clickButtonSave();
        verifyEquals(accountGeneralSetting.getErrorValidationMessage(),"");

        log.info("Step 1 - Validation - 2 whitespace on middle");
        accountGeneralSetting.enterDataOnFullNameFunction("");
        accountGeneralSetting.clickButtonSave();
        verifyEquals(accountGeneralSetting.getErrorValidationMessage(),"");

        log.info("Step 1 - Validation -Script Code");
        accountGeneralSetting.enterDataOnFullNameFunction("");
        accountGeneralSetting.clickButtonSave();
        verifyEquals(accountGeneralSetting.getErrorValidationMessage(),"");

        log.info("Step 1 - Validation - Character");
        accountGeneralSetting.enterDataOnFullNameFunction("");
        accountGeneralSetting.clickButtonSave();
        verifyEquals(accountGeneralSetting.getErrorValidationMessage(),"");

        log.info("Step 1 - Validation - More than 5 word");
        accountGeneralSetting.enterDataOnFullNameFunction("");
        accountGeneralSetting.clickButtonSave();
        verifyEquals(accountGeneralSetting.getErrorValidationMessage(),"");

        log.info("Step 1 - Validation - More than 126 character");
        accountGeneralSetting.enterDataOnFullNameFunction("");
        accountGeneralSetting.clickButtonSave();
        verifyEquals(accountGeneralSetting.getErrorValidationMessage(),"");
    }
    public void TC02_Positive_Validation_FirstName() {
        log.info("Step 1 - Enter a First Name");
        accountGeneralSetting.enterDataOnFullNameFunction("");
        accountGeneralSetting.clickButtonSave();
        verifyTrue(accountGeneralSetting.checkFormConfirmPasswordIsDisplay());
        accountGeneralSetting.enterConfirmPassword();
        accountGeneralSetting.clickConfirmButton();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
    }

    public void TC02_Positive_Validation_FirstName() {
        accountGeneralSetting.clickEditButton();
        log.info("Step 1 - Enter a First Name");
        accountGeneralSetting.enterDataOnFullNameFunction("");
        accountGeneralSetting.clickButtonSave();
        verifyTrue(accountGeneralSetting.checkFormConfirmPasswordIsDisplay());
        accountGeneralSetting.enterConfirmPassword();
        accountGeneralSetting.clickConfirmButton();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
    }

    public void TC02_Positive_Validation_FirstName() {
        accountGeneralSetting.clickEditButton();
        log.info("Step 1 - Enter a First Name");
        accountGeneralSetting.enterDataOnFullNameFunction("");
        accountGeneralSetting.clickButtonSave();
        verifyTrue(accountGeneralSetting.checkFormConfirmPasswordIsDisplay());
        accountGeneralSetting.enterConfirmPassword();
        accountGeneralSetting.clickConfirmButton();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
    }

    public void TC03_Positive_Validation_FirstName_Uppercase() {
        accountGeneralSetting.clickEditButton();
        log.info("Step 1 - Enter a First Name");
        accountGeneralSetting.enterDataOnFullNameFunction("");
        accountGeneralSetting.clickButtonSave();
        verifyTrue(accountGeneralSetting.checkFormConfirmPasswordIsDisplay());
        accountGeneralSetting.enterConfirmPassword();
        accountGeneralSetting.clickConfirmButton();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
    }

    public void TC04_Positive_Validation_FirstName_LowerCase() {
        accountGeneralSetting.clickEditButton();
        log.info("Step 1 - Enter a First Name");
        accountGeneralSetting.enterDataOnFullNameFunction("");
        accountGeneralSetting.clickButtonSave();
        verifyTrue(accountGeneralSetting.checkFormConfirmPasswordIsDisplay());
        accountGeneralSetting.enterConfirmPassword();
        accountGeneralSetting.clickConfirmButton();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
    }

    public void TC05_Positive_Validation_FirstName_Whitespace_On_First() {
        accountGeneralSetting.clickEditButton();
        log.info("Step 1 - Enter a First Name");
        accountGeneralSetting.enterDataOnFullNameFunction("");
        accountGeneralSetting.clickButtonSave();
        verifyTrue(accountGeneralSetting.checkFormConfirmPasswordIsDisplay());
        accountGeneralSetting.enterConfirmPassword();
        accountGeneralSetting.clickConfirmButton();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
    }

    public void TC06_Positive_Validation_FirstName_Whitespace_On_Last() {
        accountGeneralSetting.clickEditButton();
        log.info("Step 1 - Enter a First Name");
        accountGeneralSetting.enterDataOnFullNameFunction("");
        accountGeneralSetting.clickButtonSave();
        verifyTrue(accountGeneralSetting.checkFormConfirmPasswordIsDisplay());
        accountGeneralSetting.enterConfirmPassword();
        accountGeneralSetting.clickConfirmButton();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
    }
}
