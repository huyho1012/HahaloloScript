package testcases.newsfeed.NewsfeedTab.PostFunction.NormalPost;

import actions.PageObject.newsfeed.PageFeed.NewsFeedHomepage;
import actions.PageObject.newsfeed.Starting.NewsFeedLogin;
import actions.common.DriverBrowser.BrowserDriver;
import actions.common.DriverBrowser.DriverManager;
import actions.common.Function.PageGenerator;
import actions.common.GlobalVariables;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Validation {
    WebDriver driver;
    DriverManager driverManager;
    NewsFeedLogin newsFeedLoginPage;
    NewsFeedHomepage newsFeedHomepage;


    @BeforeTest
    public void preconditionTest(String browserName){
        driverManager = BrowserDriver.getBrowser(browserName);
        driver = driverManager.getDriver(GlobalVariables.URL_NEWS_FEED_LOGIN);
        newsFeedLoginPage =  PageGenerator.getLoginPage(driver);
        newsFeedHomepage = newsFeedLoginPage.LoginPage();

    }
    @Test
    public void NormalPost_01_Check_Button_Share_Post_With_No_Input(){
        log.info("Check Button Share Post - Step 01 - Open Post Normal Editor");
        newsFeedPage.clickToNormalPostFunction();
        postPage = PageGenerator.openNormalPostEditor(driver);

        log.info("Check Share Post button - Step 02 - Check form Editor post display");
        verifyTrue(postPage.checkCreatePostModalIsDisplay());

        log.info("Check Share Post button - Step 03 - Check status");
        verifyFalse(postPage.checkButtonSharePostIsEnable());

        log.info("Check Button Share Post - Step 05 - Close Post Normal Editor");
        postPage.closeNormalPostEditor();
    }
}
