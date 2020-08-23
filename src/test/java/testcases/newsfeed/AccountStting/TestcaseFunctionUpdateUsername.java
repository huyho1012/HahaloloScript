package testcases.newsfeed.AccountStting;

import CommonHelper.DriverBrowser.BrowserDriver;
import CommonHelper.DriverBrowser.DriverManager;
import CommonHelper.Function.AbstractTest;
import CommonHelper.Function.PageGenerator;
import CommonHelper.GlobalVariables;
import Newsfeed.HeaderMenu.UserSetting.PageObject.GeneralSetting;
import Newsfeed.PersonalWall.About.OverviewTab.OverviewPageObject;
import Newsfeed.TabFeed.NewsFeedTab;
import StartingApp.Login.LoginNewsfeed;
import StartingApp.Register.VerifyAccountPageObject;
import org.openqa.selenium.WebDriver;

public class TestcaseFunctionUpdateUsername extends AbstractTest {
    DriverManager driverManager;
    WebDriver driver;
    LoginNewsfeed loginNewsfeedPage;
    NewsFeedTab newsFeedHomePage;
    GeneralSetting accountGeneralSetting;
    VerifyAccountPageObject verifyAccountPage;
    OverviewPageObject overviewPage;
    String account = "balo_04@mailinator.com";
    String passWord = "123456";

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

        log.info("Precondition step 2.1 - AccountSetting page - Click Account Setting on menu");

        newsFeedHomePage.clickItemOnSettingMenu(driver,"");
        accountGeneralSetting = PageGenerator.createAccountSettingGeneralTab(driver);

        log.info("Step 1 - Click Edit Username");
        accountGeneralSetting.clickButtonEditUserName();
    }

    public void TC_01_CheckValidationOfUser_Negative_Case(){

        log.info("Step 3 - Enter UserName blank");
        accountGeneralSetting.clickButtonEditUserName();
        accountGeneralSetting.clearDataOfFieldOnUserNameFunction();
        verifyTrue(accountGeneralSetting.checkStatusOfButtonSaveChangeUserName());

        log.info("Step 4 - Enter UserName whit all whitespace");
        accountGeneralSetting.inputDataOfFieldOnUserNameFunction("  ");
        verifyTrue(accountGeneralSetting.checkStatusOfButtonSaveChangeUserName());
        verifyEquals(accountGeneralSetting.getMessageOfUsername() ,"Phải có ít nhất 5 kí tự");

        log.info("Step 5 - Enter UserName contain whitespace on middle");
        accountGeneralSetting.clickButtonEditUserName();
        accountGeneralSetting.inputDataOfFieldOnUserNameFunction("huy hodoan");
        verifyTrue(accountGeneralSetting.checkStatusOfButtonSaveChangeUserName());
        verifyEquals(accountGeneralSetting.getMessageOfUsername() ,"Có chứa ký tự không hợp lệ.");

        log.info("Step 6 - Enter UserName contain diots on end");
        accountGeneralSetting.clickButtonEditUserName();
        accountGeneralSetting.inputDataOfFieldOnUserNameFunction("huyhodoan.");
        verifyTrue(accountGeneralSetting.checkStatusOfButtonSaveChangeUserName());
        verifyEquals(accountGeneralSetting.getMessageOfUsername() ,"Có chứa ký tự đặc biệt không đúng chỗ");

        log.info("Step 7 - Enter UserName contain special character");
        accountGeneralSetting.clickButtonEditUserName();
        accountGeneralSetting.inputDataOfFieldOnUserNameFunction("huyhodo@an");
        verifyTrue(accountGeneralSetting.checkStatusOfButtonSaveChangeUserName());
        verifyEquals(accountGeneralSetting.getMessageOfUsername() ,"Có chứa ký tự không hợp lệ.");

        log.info("Step 8 - Enter UserName less than 5 character");
        accountGeneralSetting.clickButtonEditUserName();
        accountGeneralSetting.inputDataOfFieldOnUserNameFunction("");
        verifyEquals(accountGeneralSetting.getMessageOfUsername() ,"Phải có ít nhất 5 kí tự   ");
        verifyTrue(accountGeneralSetting.checkStatusOfButtonSaveChangeUserName());

        log.info("Step 9 - Enter UserName contain exceed 50 characters");
        accountGeneralSetting.clickButtonEditUserName();
        accountGeneralSetting.inputDataOfFieldOnUserNameFunction("");
        verifyEquals(accountGeneralSetting.getUserIdentityNameDisplay(driver) ," Tên người dùng vượt số ký tự tối đa cho phép");
        verifyTrue(accountGeneralSetting.checkStatusOfButtonSaveChangeUserName());

        log.info("Step 10 - Enter UserName contain script code");
        accountGeneralSetting.clickButtonEditUserName();
        accountGeneralSetting.inputDataOfFieldOnUserNameFunction(GlobalVariables.SCRIPT_CODE);
        verifyEquals(accountGeneralSetting.getUserIdentityNameDisplay(driver) ,"  Có chứa ký tự không hợp lệ.");
        verifyTrue(accountGeneralSetting.checkStatusOfButtonSaveChangeUserName());

        log.info("Step 11 - Enter UserName contain HTML code");
        accountGeneralSetting.clickButtonEditUserName();
        accountGeneralSetting.inputDataOfFieldOnUserNameFunction(GlobalVariables.HTML_CODE);
        verifyEquals(accountGeneralSetting.getUserIdentityNameDisplay(driver) ,"  Có chứa ký tự không hợp lệ.");
        verifyTrue(accountGeneralSetting.checkStatusOfButtonSaveChangeUserName());

        log.info("Step 12 - Enter UserName contain marks");

        accountGeneralSetting.inputDataOfFieldOnUserNameFunction("Huyhô");
        verifyEquals(accountGeneralSetting.getUserIdentityNameDisplay(driver) ,"  Có chứa ký tự không hợp lệ.");
        verifyTrue(accountGeneralSetting.checkStatusOfButtonSaveChangeUserName());
    }

    public void TC_02_Update_UserName_With_InvalidData() {
        log.info("Step 2 - Enter UserName valid");
        accountGeneralSetting.inputDataOfFieldOnUserNameFunction("huyhodoan");
        verifyEquals(accountGeneralSetting.getMessageOfUsername(), "Tên người dùng khả dụng");
        accountGeneralSetting.clickButtonSaveChangeUsername();
        verifyEquals(accountGeneralSetting.getUserIdentityNameDisplay(driver), "huyhodoan");
    }


    public void TC_03_Update_UserName_With_Data_Has_Uppercase() {
        accountGeneralSetting.clickButtonEditUserName();
        log.info("Step 2 - Enter UserName valid");
        accountGeneralSetting.inputDataOfFieldOnUserNameFunction("HuyhoDoan");
        verifyEquals(accountGeneralSetting.getMessageOfUsername(), "Tên người dùng khả dụng");
        accountGeneralSetting.clickButtonSaveChangeUsername();
        verifyEquals(accountGeneralSetting.getUserIdentityNameDisplay(driver), "huyhodoan");
    }

    public void TC_04_Update_UserName_With_Data_Has_Contains_All_Number() {
        accountGeneralSetting.clickButtonEditUserName();
        log.info("Step 2 - Enter UserName valid");
        accountGeneralSetting.inputDataOfFieldOnUserNameFunction("123456789");
        verifyEquals(accountGeneralSetting.getMessageOfUsername(), "Tên người dùng khả dụng");
        accountGeneralSetting.clickButtonSaveChangeUsername();
        verifyEquals(accountGeneralSetting.getUserIdentityNameDisplay(driver), "123456789");
    }

    public void TC_05_Update_UserName_With_Data_Has_Contains_Alpha_Number(){
        accountGeneralSetting.clickButtonEditUserName();
        log.info("Step 2 - Enter UserName valid");
        accountGeneralSetting.inputDataOfFieldOnUserNameFunction("huyhodoan1210");
        verifyEquals(accountGeneralSetting.getMessageOfUsername(), "Tên người dùng khả dụng");
        accountGeneralSetting.clickButtonSaveChangeUsername();
        verifyEquals(accountGeneralSetting.getUserIdentityNameDisplay(driver), "huyhodoan1210");
    }

    public void TC_05_Update_UserName_With_Data_Has_Contains_Diots_On_Middle(){
        accountGeneralSetting.clickButtonEditUserName();
        log.info("Step 2 - Enter UserName valid");
        accountGeneralSetting.inputDataOfFieldOnUserNameFunction("huy.hodoan.1210");
        verifyEquals(accountGeneralSetting.getMessageOfUsername(), "Tên người dùng khả dụng");
        accountGeneralSetting.clickButtonSaveChangeUsername();
        verifyEquals(accountGeneralSetting.getUserIdentityNameDisplay(driver), "huy.hodoan.1210");

        accountGeneralSetting.clickItemOnSettingMenu(driver,"logout");
        loginNewsfeedPage = PageGenerator.createLoginNewsfeedPage(driver);
        loginNewsfeedPage.checkLoginNewsfeedPageIsDisplay();
    }

    public void checkDefaultUsernameAndUpdateValidUsernameCaseNewAccount(){
        loginNewsfeedPage.enterDataOnDynamicTextField("firstname", "");
        loginNewsfeedPage.enterDataOnDynamicTextField("lastname", "");
        loginNewsfeedPage.enterDataOnDynamicTextField("email", "");
        loginNewsfeedPage.enterDataOnDynamicTextField("password", "");
        loginNewsfeedPage.enterDataOnDynamicTextField("confirmpassword", "");
        loginNewsfeedPage.clickSignUpButton();
        verifyAccountPage = PageGenerator.createVerifyAccountPage(driver);
        verifyTrue(verifyAccountPage.checkTitlePageVerifyEmail());
        verifyEquals(verifyAccountPage.getAccountDisplayOnRegisterPage(), "");
        String code = verifyAccountPage.copyVerifyCodeOnMail("");
        verifyAccountPage.inputVerifyDataOnField(code);
        verifyAccountPage.clickVerifyButton();
        newsFeedHomePage = PageGenerator.getNewsFeedPage(driver);
        newsFeedHomePage.clickItemOnSettingMenu(driver, "accoutsetting");
        accountGeneralSetting = PageGenerator.createAccountSettingGeneralTab(driver);
        verifyEquals(accountGeneralSetting.checkUserNameIsDisplay(),"");
        accountGeneralSetting.clickButtonEditUserName();
        accountGeneralSetting.inputDataOfFieldOnUserNameFunction("huy.hodoan.1210");
        verifyEquals(accountGeneralSetting.getMessageOfUsername(), "Tên người dùng khả dụng");
        accountGeneralSetting.clickButtonSaveChangeUsername();
        verifyEquals(accountGeneralSetting.getUserIdentityNameDisplay(driver), "huy.hodoan.1210");
        String urlUserName = accountGeneralSetting.getUserIdentityNameDisplay(driver);

        accountGeneralSetting.clickItemOnSettingMenu(driver,"about");
        overviewPage = PageGenerator.getPersonalOverviewTab(driver);

        verifyEquals(overviewPage.getCurrentUrl(driver),urlUserName);




    }

}
