package testcases.newsfeed;

import CommonHelper.DriverBrowser.BrowserDriver;
import CommonHelper.DriverBrowser.DriverManager;
import CommonHelper.Function.AbstractTest;
import CommonHelper.Function.PageGenerator;
import CommonHelper.GlobalVariables;
import Newsfeed.PersonalWall.About.OverviewTab.OverviewPageObject;
import Newsfeed.PersonalWall.TimeLine.PersonalTimelinePageObject;
import Newsfeed.TabFeed.NewsFeedTabPageObject;
import StartingApp.Login.LoginNewsfeed;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Test2 extends AbstractTest {
    DriverManager driverManager;
    WebDriver driver;

    LoginNewsfeed loginNewsfeedPage;
    NewsFeedTabPageObject newsfeedPage;
    PersonalTimelinePageObject personalTimeline;
    OverviewPageObject perOverviewPage;


    @Parameters("browser")
    @BeforeTest
    public void Precondition(String browserName){
        driverManager = BrowserDriver.getBrowser(browserName);
        log.info("Precondition - Step 01 - Open Browser");
        driver = driverManager.getDriver(GlobalVariables.URL_NEWS_FEED_LOGIN);
        loginNewsfeedPage= PageGenerator.createLoginNewsfeedPage(driver);
        log.info("Precondition - Step 02 - Enter Username");
        loginNewsfeedPage.enterUsernameToLogin(GlobalVariables.FEED_EMAIL_ACCOUNT);
        log.info("Precondition - Step 03 - Enter Password");
        loginNewsfeedPage.enterPasswordToLogin(GlobalVariables.FEED_EMAIL_PASSWORD);
        log.info("Precondition - Step 04 - Click Login button");
        loginNewsfeedPage.clickLoginButton();
        newsfeedPage = PageGenerator.createNewsfeedTab(driver);
        newsfeedPage.clickToUserHomePage();
        personalTimeline = PageGenerator.getPersonalTimeLinePage(driver);
    }
    @Test
    public void Test_Copy_Link(){
        personalTimeline.copyLinkUserProfile(driver);
        personalTimeline.openNewWindow(driver,getContentToClipBoard());
        personalTimeline.clickToTabOnPersonalMenu(driver,"userAboutPath");
        a
    }
}
