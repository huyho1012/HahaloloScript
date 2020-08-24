package testcases.newsfeed.AccountStting;

import CommonHelper.DriverBrowser.BrowserDriver;
import CommonHelper.DriverBrowser.DriverManager;
import CommonHelper.Function.AbstractTest;
import CommonHelper.Function.PageGenerator;
import CommonHelper.GlobalVariables;
import Newsfeed.HeaderMenu.GeneralSettting.GeneralSetting;
import Newsfeed.TabFeed.NewsFeedTab;
import StartingApp.Login.LoginNewsfeed;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

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

        log.info("Precondition step 2.3- AccountSetting page - Open Edit Full Name Function");
        accountGeneralSetting.clickIconEditFullName(driver);
    }

    @Test
    public void TC01_FirstName_Check_Validation_Negative(){
        log.info("Step 1 - First name is blank");
        accountGeneralSetting.removeValueOnFieldOnFullName(driver,"firstName");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyEquals(accountGeneralSetting.getErrMesFieldOnFullName(driver,"firstName"),"");

        log.info("Step 2 -  First name contains all whitespace");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"firstName","    ");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyEquals(accountGeneralSetting.getErrMesFieldOnFullName(driver,"firstName"),"");

        log.info("Step 3 - First name contains Number");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"firstName","123456");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyEquals(accountGeneralSetting.getErrMesFieldOnFullName(driver,"firstName"),"Tên không chứa số.");

        log.info("Step 4 - First name contains Alpha number");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"firstName","Huy12");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyEquals(accountGeneralSetting.getErrMesFieldOnFullName(driver,"firstName"),"Tên không chứa số.");

        log.info("Step 5 - First name contains 2 whitespace on middle");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"firstName","Quốc  Huy");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyEquals(accountGeneralSetting.getErrMesFieldOnFullName(driver,"firstName"),"Tên không được nhập quá 2 kí tự trắng.");

        log.info("Step 6 - First name contains Script Code");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"firstName",GlobalVariables.SCRIPT_CODE);
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyEquals(accountGeneralSetting.getErrMesFieldOnFullName(driver,"firstName"),"Tên không chứa ký tự đặc biệt.");

        log.info("Step 7 - First name contains HTML Code");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"firstName",GlobalVariables.SCRIPT_CODE);
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyEquals(accountGeneralSetting.getErrMesFieldOnFullName(driver,"firstName"),"Tên không chứa ký tự đặc biệt.");

        log.info("Step 8 - First name contains special character");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"firstName","Q@uang Huy");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyEquals(accountGeneralSetting.getErrMesFieldOnFullName(driver,"firstName"),"Tên không chứa ký tự đặc biệt.");

        log.info("Step 9 -  First name have more than 5 word");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"firstName","Doãn Huỳnh Quốc");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyEquals(accountGeneralSetting.getErrMesFieldOnFullName(driver,"firstName"),"");

        log.info("Step 10 -  First name have more than 128 character");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"firstName",randomSentence(129));
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyEquals(accountGeneralSetting.getErrMesFieldOnFullName(driver,"firstName"),"");

        accountGeneralSetting.refreshPage(driver);
        accountGeneralSetting.clickIconEditFullName(driver);
    }

    @Test
    public void TC02_LastName_Check_Validation_Negative(){
        log.info("Step 1 - Last name is blank");
        accountGeneralSetting.removeValueOnFieldOnFullName(driver,"lastName");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyEquals(accountGeneralSetting.getErrMesFieldOnFullName(driver,"lastName"),"Họ là bắt buộc.");

        log.info("Step 2 -  Last name contains all whitespace");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"lastName","    ");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyEquals(accountGeneralSetting.getErrMesFieldOnFullName(driver,"lastName"),"Họ là bắt buộc.");

        log.info("Step 3 - Last name contains Number");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"lastName","123456");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyEquals(accountGeneralSetting.getErrMesFieldOnFullName(driver,"lastName"),"Họ không chứa số.");

        log.info("Step 4 - Last name contains Alpha number");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"lastName","Huy12");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyEquals(accountGeneralSetting.getErrMesFieldOnFullName(driver,"lastName"),"Họ không chứa số.");

        log.info("Step 5 - Last name contains 2 whitespace on middle");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"lastName","Hồ  Doãn");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyEquals(accountGeneralSetting.getErrMesFieldOnFullName(driver,"lastName"),"Họ không được nhập quá 2 kí tự trắng.");

        log.info("Step 6 - Last name contains Script Code");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"lastName",GlobalVariables.SCRIPT_CODE);
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyEquals(accountGeneralSetting.getErrMesFieldOnFullName(driver,"lastName"),"Họ không chứa ký tự đặc biệt.");

        log.info("Step 7 - Last name contains HTML Code");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"lastName",GlobalVariables.HTML_CODE);
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyEquals(accountGeneralSetting.getErrMesFieldOnFullName(driver,"lastName"),"Họ không chứa ký tự đặc biệt.");

        log.info("Step 8 - Last name contains special character");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"lastName","Hồ D@ãn");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyEquals(accountGeneralSetting.getErrMesFieldOnFullName(driver,"lastName"),"Họ không chứa ký tự đặc biệt.");

        log.info("Step 9 - Last name have more than 5 word");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"lastName","Doãn Quốc Huỳnh Huy");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyEquals(accountGeneralSetting.getErrMesFieldOnFullName(driver,"lastName"),"");

        log.info("Step 10 - Last name have more than 128 character");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"lastName",randomSentence(129));
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyEquals(accountGeneralSetting.getErrMesFieldOnFullName(driver,"lastName"),"");

        accountGeneralSetting.refreshPage(driver);
        accountGeneralSetting.clickIconEditFullName(driver);
    }
    @Test
    public void TC03_Middle_Check_Validation_Negative(){
        log.info("Step 1 - Middle name contains Number");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"middleName","123456");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyEquals(accountGeneralSetting.getErrMesFieldOnFullName(driver,"middleName"),"Chữ lót không chứa số.");

        log.info("Step 2 - Middle name contains Alpha number");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"middleName","Huy12");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyEquals(accountGeneralSetting.getErrMesFieldOnFullName(driver,"middleName"),"Chữ lót không chứa số.");

        log.info("Step 3 - Middle name contains Script Code");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"middleName",GlobalVariables.SCRIPT_CODE);
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyEquals(accountGeneralSetting.getErrMesFieldOnFullName(driver,"lastName"),"Chữ lót không chứa ký tự đặc biệt.");

        log.info("Step 4 - Last name contains HTML Code");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"middleName",GlobalVariables.HTML_CODE);
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyEquals(accountGeneralSetting.getErrMesFieldOnFullName(driver,"lastName"),"Chữ lót không chứa ký tự đặc biệt.");

        log.info("Step 5 - Last name contains special character");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"middleName","D@ãn");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyEquals(accountGeneralSetting.getErrMesFieldOnFullName(driver,"lastName"),"Chữ lót không chứa ký tự đặc biệt.");

        log.info("Step 6 - Middle name have more than 5 word");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"middleName","Doãn Quốc Huỳnh Hoàng");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyEquals(accountGeneralSetting.getErrMesFieldOnFullName(driver,"middleName"),"");

        log.info("Step 7 - Middle name have more than 128 character");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"middleName",randomSentence(129));
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyEquals(accountGeneralSetting.getErrMesFieldOnFullName(driver,"middleName"),"");
        accountGeneralSetting.refreshPage(driver);
        accountGeneralSetting.clickIconEditFullName(driver);
    }
    @Test
    public void TC04_FirstName_Check_Validation_Positive() {
        log.info("Step 1 - First Name - Uppercase");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"firstName","QUÔC HUY");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyTrue(accountGeneralSetting.checkConfirmPasswordPopupIsDisplay());
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"confirmPwd","123456");
        accountGeneralSetting.clickToConfirmButtonOnPopup();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
        accountGeneralSetting.clickIconEditFullName(driver);

        log.info("Step 2 - First Name - Lowercase");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"firstName","quoc huy");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyTrue(accountGeneralSetting.checkConfirmPasswordPopupIsDisplay());
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"confirmPwd","123456");
        accountGeneralSetting.clickToConfirmButtonOnPopup();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
        accountGeneralSetting.clickIconEditFullName(driver);

        log.info("Step 3 - First Name - Whitespace on first");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"firstName","  Huy");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyTrue(accountGeneralSetting.checkConfirmPasswordPopupIsDisplay());
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"confirmPwd","123456");
        accountGeneralSetting.clickToConfirmButtonOnPopup();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
        accountGeneralSetting.clickIconEditFullName(driver);

        log.info("Step 4 - First Name - Whitespace on last");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"firstName","Huy  ");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyTrue(accountGeneralSetting.checkConfirmPasswordPopupIsDisplay());
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"confirmPwd","123456");
        accountGeneralSetting.clickToConfirmButtonOnPopup();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
        accountGeneralSetting.clickIconEditFullName(driver);

        log.info("Step 5 - First Name -  Valid");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"firstName","Huy");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyTrue(accountGeneralSetting.checkConfirmPasswordPopupIsDisplay());
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"confirmPwd","123456");
        accountGeneralSetting.clickToConfirmButtonOnPopup();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
    }
    @Test
    public void TC05_LastName_Check_Validation_Positive() {
        log.info("Step 1 - Last Name - Uppercase");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"lastName","HỒ DOÃN");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyTrue(accountGeneralSetting.checkConfirmPasswordPopupIsDisplay());
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"confirmPwd","123456");
        accountGeneralSetting.clickToConfirmButtonOnPopup();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
        accountGeneralSetting.clickIconEditFullName(driver);

        log.info("Step 2 - Last Name - Lowercase");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"lastName","hồ doãn");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyTrue(accountGeneralSetting.checkConfirmPasswordPopupIsDisplay());
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"confirmPwd","123456");
        accountGeneralSetting.clickToConfirmButtonOnPopup();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
        accountGeneralSetting.clickIconEditFullName(driver);

        log.info("Step 3 - Last Name - Whitespace on first");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"lastName","  Hồ");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyTrue(accountGeneralSetting.checkConfirmPasswordPopupIsDisplay());
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"confirmPwd","123456");
        accountGeneralSetting.clickToConfirmButtonOnPopup();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
        accountGeneralSetting.clickIconEditFullName(driver);

        log.info("Step 4 - Last Name - Whitespace on last");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"lastName","Hồ  ");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyTrue(accountGeneralSetting.checkConfirmPasswordPopupIsDisplay());
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"confirmPwd","123456");
        accountGeneralSetting.clickToConfirmButtonOnPopup();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
        accountGeneralSetting.clickIconEditFullName(driver);

        log.info("Step 5 - Last Name - Valid");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"lastName","Hồ");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyTrue(accountGeneralSetting.checkConfirmPasswordPopupIsDisplay());
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"confirmPwd","123456");
        accountGeneralSetting.clickToConfirmButtonOnPopup();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");

    }
    @Test
    public void TC05_Middle_Name_Check_Validation_Positive() {
        log.info("Step 1 - Middle Name - Blank");
        accountGeneralSetting.removeValueOnFieldOnFullName(driver,"middleName");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyTrue(accountGeneralSetting.checkConfirmPasswordPopupIsDisplay());
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"confirmPwd","123456");
        accountGeneralSetting.clickToConfirmButtonOnPopup();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
        accountGeneralSetting.clickIconEditFullName(driver);

        log.info("Step 1 - Middle Name - Whitespace");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"middleName" ,"      ");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyTrue(accountGeneralSetting.checkConfirmPasswordPopupIsDisplay());
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"confirmPwd","123456");
        accountGeneralSetting.clickToConfirmButtonOnPopup();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
        accountGeneralSetting.clickIconEditFullName(driver);

        log.info("Step 1 - Middle Name - Uppercase");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"middleName","DOÃN QUỐC");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyTrue(accountGeneralSetting.checkConfirmPasswordPopupIsDisplay());
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"confirmPwd","123456");
        accountGeneralSetting.clickToConfirmButtonOnPopup();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
        accountGeneralSetting.clickIconEditFullName(driver);

        log.info("Step 2 - Middle Name - Lowercase");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"middleName","doãn quốc");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyTrue(accountGeneralSetting.checkConfirmPasswordPopupIsDisplay());
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"confirmPwd","123456");
        accountGeneralSetting.clickToConfirmButtonOnPopup();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
        accountGeneralSetting.clickIconEditFullName(driver);

        log.info("Step 3 - Middle Name - Whitespace on first");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"middleName","  doãn quốc");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyTrue(accountGeneralSetting.checkConfirmPasswordPopupIsDisplay());
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"confirmPwd","123456");
        accountGeneralSetting.clickToConfirmButtonOnPopup();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
        accountGeneralSetting.clickIconEditFullName(driver);

        log.info("Step 4 - Middle Name - Whitespace on last");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"middleName","Doãn quốc  ");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyTrue(accountGeneralSetting.checkConfirmPasswordPopupIsDisplay());
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"confirmPwd","123456");
        accountGeneralSetting.clickToConfirmButtonOnPopup();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
        accountGeneralSetting.clickIconEditFullName(driver);

        log.info("Step 5 - Middle Name - Valid");
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"middleName","Doãn Quốc");
        accountGeneralSetting.clickToButtonSaveChangeOfFullName(driver);
        verifyTrue(accountGeneralSetting.checkConfirmPasswordPopupIsDisplay());
        accountGeneralSetting.inputValueToFieldOnFullName(driver,"confirmPwd","123456");
        accountGeneralSetting.clickToConfirmButtonOnPopup();
        verifyEquals(accountGeneralSetting.getFullNameIsDisplay(), "");
    }
}
