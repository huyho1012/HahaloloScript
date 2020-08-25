package testcases.newsfeed.PostFunction;

import Business.Business.Dashboard.BusinessDashboard;
import CommonHelper.DriverBrowser.BrowserDriver;
import CommonHelper.DriverBrowser.DriverManager;
import CommonHelper.Function.AbstractTest;
import CommonHelper.Function.PageGenerator;
import CommonHelper.GlobalVariables;
import Newsfeed.Editor.ExperiencePost.Feed.NewsFeedExperience;
import Newsfeed.Flight.NewsFeedFlight;
import Newsfeed.Hotel.NewsFeedHotel;
import Newsfeed.PersonalWall.Handnote.UserHandNotePageObject;
import Newsfeed.PersonalWall.TimeLine.PersonalTimelinePage;
import Newsfeed.Shop.NewsFeedShopping;
import Newsfeed.TabFeed.NewsFeedTab;

import Newsfeed.Tour.NewsFeedTour;
import StartingApp.Login.LoginNewsfeed;
import Newsfeed.HeaderMenu.GeneralSettting.GeneralSetting;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import sun.jvm.hotspot.debugger.Page;

public class CheckRedirectCorrectLink extends AbstractTest {

    String userName = GlobalVariables.FEED_EMAIL_ACCOUNT;
    String passWord = GlobalVariables.FEED_EMAIL_PASSWORD;
    String newsfeedURL = GlobalVariables.URL_NEWS_FEED_LOGIN;
    String currentTab;

    DriverManager driverManager;
    WebDriver driver;
    LoginNewsfeed loginNewsfeedPage;
    NewsFeedTab newsfeedPage;
    UserHandNotePageObject handNotePage;
    PersonalTimelinePage perTimeLinePage;
    GeneralSetting accountSettingGeneral;
    BusinessDashboard businessDashboard;
    NewsFeedExperience experienceTab;
    NewsFeedHotel hotelTab;
    NewsFeedFlight flightTab;
    NewsFeedTour tourTab;
    NewsFeedShopping shoppingTab;


    @Parameters("browser")
    @BeforeClass
    public void getBrowser(String browserName){
        log.info("Precondition - Step 01 - Create Driver Browser");
        driverManager = BrowserDriver.getBrowser(browserName);

        log.info("Precondition - Step 02 - Open web browser and go to Newsfeed Login");
        driver= driverManager.getDriver(newsfeedURL);
        loginNewsfeedPage = PageGenerator.createLoginNewsfeedPage(driver);

        log.info("Precondition - Step 03 - Login account");
        loginNewsfeedPage.doActionLogin(driver,userName,passWord);
        newsfeedPage = PageGenerator.getNewsFeedPage(driver);

        log.info("Precondition - Step 04 - Verify Login successfully");
        verifyTrue(newsfeedPage.checkLoginSuccess());

        log.info("Precondition - Step 05 - Check language default display and change language to VI");
        newsfeedPage.changeLanguageDisplayToVietnamese();
        currentTab= driver.getWindowHandle();
    }

    @Test
    public void TC01_Check_Redirect_Tab_When_User_Click_To_Item_on_Nav_Menu() {
        log.info("Step 1 - Verify user stay on Newsfeed tab");
        verifyEquals(newsfeedPage.getTitlePage(driver),"Bảng tin | Hahalolo");

        log.info("Step 2 - Redirect to Experience tab");
        newsfeedPage.clickToNavTabOnNewsfeed("Trải nghiệm");
        experienceTab = PageGenerator.createTabExperienceFeed(driver);
        verifyEquals(experienceTab.getTitlePage(driver),"Trải nghiệm | Hahalolo");

        log.info("Step 3.1 - Redirect to Hotel tab");
        experienceTab.clickToNavTabOnNewsfeed("Khách sạn");
        hotelTab = PageGenerator.createTabHotelFeed(driver);
        verifyEquals(hotelTab.getTitlePage(driver),"Khách sạn | Hahalolo");

        log.info("Step 4.1 - Redirect to Shopping tab");
        hotelTab.clickToNavTabOnNewsfeed("Mua sắm");
        shoppingTab = PageGenerator.createTabShopFeed(driver);
        verifyEquals(shoppingTab.getTitlePage(driver),"Mua sắm | Hahalolo");

        log.info("Step 5.1  - Redirect to Tour tab");
        newsfeedPage.clickToNavTabOnNewsfeed("Tour");
        tourTab = PageGenerator.createTabTourFeed(driver);
        verifyEquals(tourTab.getTitlePage(driver),"Tour | Hahalolo");

        log.info("Step 6.1  - Redirect to Flight tab");
        tourTab.clickToNavTabOnNewsfeed("Vé máy bay");
        flightTab = PageGenerator.createTabFlightFeed(driver);
        verifyEquals(flightTab.getTitlePage(driver),"Vé máy bay | Hahalolo");

        log.info("Step 7.1  - Redirect to Newsfeed tab");
        flightTab.clickToNavTabOnNewsfeed("Bảng tin");
        newsfeedPage = PageGenerator.createTabNewsfeed(driver);
        verifyEquals(newsfeedPage.getTitlePage(driver),"Bảng tin | Hahalolo");
    }

    @Test
    public void TC02_Check_Go_To_Direct_Link_When_User_Click_To_Item_On_Helper_Menu(){
        log.info("Step 1 - Verify user stay on Newsfeed tab");
        newsfeedPage.checkLoginSuccess();

        log.info("Step 2 - Click to Halo's Official");
        newsfeedPage.clickFunctionOnHelping(driver,"about");

        log.info("Step 3 - Click to Halo's Terms");
        newsfeedPage.clickFunctionOnHelping(driver,"terms");
        verifyEquals(newsfeedPage.getCurrentUrl(driver), "Điều khoản dịch vụ của HAHALOLO – Trung tâm hỗ trợ");
        newsfeedPage.closeAllWindowExceptParentWindow(driver,currentTab);

        log.info("Step 4 - Click to Halo's Terms");
        newsfeedPage.clickFunctionOnHelping(driver,"help");
        verifyEquals(newsfeedPage.getCurrentUrl(driver), "Trung tâm hỗ trợ");
        newsfeedPage.closeAllWindowExceptParentWindow(driver,currentTab);
    }

    @Test
    public void TC03_Check_Redirect_Link_When_User_Click_Avatar(){
        log.info("Step 1 - Click To Avatar");
        newsfeedPage.clickToAvatarUser(driver);
        perTimeLinePage = PageGenerator.getPersonalTimeLinePage(driver);

        log.info("Step 2 - Verify Go to Personal Wall success");
        verifyTrue(perTimeLinePage.checkTimeLinePersonalIsDisplay(""));
    }
    @Test
    public void TC04_Check_Redirect_Link_When_User_Click_Homepage(){
        log.info("Step 1 - Click To Homepage");
        perTimeLinePage.goToNewsfeedHomePage(driver);
        newsfeedPage = PageGenerator.getNewsFeedPage(driver);

        log.info("Step 2 - Verify Go to Homepage success");
        verifyTrue(newsfeedPage.checkLoginSuccess());
    }

    @Test
    public void TC02_Check_Go_To_Direct_Link_When_User_Click_To_Item_On_Menu_Setting() {
        log.info("Step 1  - Redirect to Handnote Tour");
        newsfeedPage.clickItemOnSettingMenu(driver, "ic-handnotes-c");
        handNotePage = PageGenerator.createUserHandNotePage(driver);
        verifyTrue(handNotePage.checkHandnoteTourTabIsDisplay(driver));

        log.info("Step 2  - Redirect to Account Setting");
        handNotePage.clickItemOnSettingMenu(driver,"ic-cog-c");
        accountSettingGeneral = PageGenerator.createAccountSettingGeneralTab(driver);
        verifyTrue(accountSettingGeneral.checkGeneralAccountSettingTabIsDisplay(driver));

        log.info("Step 3  - Redirect to Account Setting");
        accountSettingGeneral.clickItemOnSettingMenu(driver,"ic-business-c");
        businessDashboard = PageGenerator.getBusinessDashboardPage(driver);
        verifyTrue(businessDashboard.checkBussinessDashboardPageIsDisplay(driver));

        log.info("Step 3  - Logout account");
        businessDashboard.clickItemOnSettingMenu(driver,"ic-logout-c");
        loginNewsfeedPage = PageGenerator.createLoginNewsfeedPage(driver);
        verifyTrue(loginNewsfeedPage.checkLoginNewsfeedPageIsDisplay());

    }



    @AfterTest(alwaysRun = true)
    public void closeTestcase(){
        closeBrowserAndDriver(driver);
    }
}
