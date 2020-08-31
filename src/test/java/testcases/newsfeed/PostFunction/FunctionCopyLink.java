package testcases.newsfeed.PostFunction;

import CommonHelper.DriverBrowser.BrowserDriver;
import CommonHelper.DriverBrowser.DriverManager;
import CommonHelper.Function.AbstractTest;
import CommonHelper.Function.PageGenerator;
import CommonHelper.GlobalVariables;
import Newsfeed.PersonalWall.About.OverviewTab.OverviewPageObject;
import Newsfeed.PersonalWall.TimeLine.PersonalTimelinePage;
import Newsfeed.TabFeed.NewsFeedTab;
import StartingApp.Login.LoginNewsfeed;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class FunctionCopyLink extends AbstractTest {
    DriverManager driverManager;
    WebDriver driver;

    LoginNewsfeed loginNewsfeedPage;
    NewsFeedTab newsfeedPage;
    PersonalTimelinePage personalTimeline;
    OverviewPageObject perOverviewPage;


    @Parameters("browser")
    @BeforeTest
    public void Precondition(String browserName){
        driverManager = BrowserDriver.getBrowser(browserName);
        log.info("Precondition - Step 01 - Open Browser");
        driver = driverManager.getDriver(GlobalVariables.URL_NEWS_FEED_LOGIN);
        loginNewsfeedPage= PageGenerator.createLoginNewsfeedPage(driver);
        log.info("Precondition - Step 02 - Enter Username");
        loginNewsfeedPage.enterDataOnDynamicTextField("identity",GlobalVariables.FEED_EMAIL_ACCOUNT);
        log.info("Precondition - Step 03 - Enter Password");
        loginNewsfeedPage.enterDataOnDynamicTextField("password", GlobalVariables.FEED_EMAIL_PASSWORD);
        log.info("Precondition - Step 04 - Click Login button");
        loginNewsfeedPage.clickLoginButton();
        newsfeedPage = PageGenerator.createTabNewsfeed(driver);
        newsfeedPage.clickToUserHomePage(driver);
        personalTimeline = PageGenerator.getPersonalTimeLinePage(driver);
    }
    @Test
    public void Test_Copy_Link(){
        personalTimeline.copyLinkUserProfile(driver);
        personalTimeline.openNewWindow(driver,getContentToClipBoard());
        personalTimeline.clickToTabOnPersonalMenu(driver,"userAboutPath");
    }
}
