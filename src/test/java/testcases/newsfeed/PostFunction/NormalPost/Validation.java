package testcases.newsfeed.PostFunction.NormalPost;

import actions.PageObject.Newsfeed.PageFeed.NewsFeedHomepage;
import actions.PageObject.Newsfeed.PageFeed.PostFunction.NormalPostEditor;
import actions.PageObject.Newsfeed.Starting.NewsFeedLogin;
import actions.common.DriverBrowser.BrowserDriver;
import actions.common.DriverBrowser.DriverManager;
import actions.common.Function.AbstractTest;
import actions.common.Function.PageGenerator;
import actions.common.GlobalVariables;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Validation extends AbstractTest {
    WebDriver driver;
    DriverManager driverManager;
    NewsFeedLogin newsFeedLoginPage;
    NewsFeedHomepage newsFeedHomepage;
    NormalPostEditor editorTab;


    @BeforeTest
    public void preconditionTest(String browserName){
        driverManager = BrowserDriver.getBrowser(browserName);
        driver = driverManager.getDriver(GlobalVariables.URL_NEWS_FEED_LOGIN);
        newsFeedLoginPage =  PageGenerator.getLoginPage(driver);

    }
    @Test
    public void Share_Button_01_Check_Status_Button_When_User_No_Input(){
        log.info("Check Button Share Post - Step 01 - Open Post Normal Editor");
        newsFeedHomepage.clickToNormalPostFunction();
        editorTab = PageGenerator.openNormalPostEditor(driver);

        log.info("Check Share Post button - Step 02 - Check form Editor post display");
        verifyTrue(editorTab.checkCreatePostModalIsDisplay(driver));

        log.info("Check Share Post button - Step 03 - Check status");
//        verifyFalse(editorTab.checkButtonSharePostIsEnable());
    }
    @Test
    public void Share_Button_02_Check_Status_Button_When_Clear_Data(){
        log.info("Input data into Editor");

//        log.info("Check Share Post button - Step 03 - Check status");
//        verifyFalse(editorTab.checkButtonSharePostIsEnable());
//
//        log.info("Check Button Share Post - Step 05 - Close Post Normal Editor");
//        editorTab.closeNormalPostEditor();
//        editorTab.checkCssShareButton();
    }
}
