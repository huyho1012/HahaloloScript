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

public class CheckRedirectCorrectLink extends AbstractTest {
    String currentTab;

    DriverManager driverManager;
    WebDriver driver;
    LoginNewsfeed loginNewsfeedPage;
    NewsFeedTab newsfeedPage;
    UserHandNotePageObject handNotePage;
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
        log.info("Precondition - Step 01 - Open browser");
        driverManager = BrowserDriver.getBrowser(browserName);
        log.info("Precondition - Step 02 - Login with account");
        driver= driverManager.getDriver(GlobalVariables.URL_NEWS_FEED_LOGIN);
        loginNewsfeedPage = PageGenerator.createLoginNewsfeedPage(driver);
        loginNewsfeedPage.enterDataOnDynamicTextField("identity",GlobalVariables.FEED_EMAIL_ACCOUNT);
        loginNewsfeedPage.enterDataOnDynamicTextField("password",GlobalVariables.FEED_EMAIL_PASSWORD);
        loginNewsfeedPage.clickLoginButton();
        newsfeedPage = PageGenerator.getNewsFeedPage(driver);
        log.info("Precondition - Step 03 - Check language default display and change language to VI");
        newsfeedPage.changeLanguageDisplay();
        currentTab= driver.getWindowHandle();
    }
    @Test
    public void TC01_switchToTabFeedOnMenu() {

        log.info("Step 1 - Verify user stay on Newsfeed tab");
        verifyEquals(newsfeedPage.getTitlePage(driver),"Bảng tin | Hahalolo");

        log.info("Step 2.1 - Redirect to Experience tab");
        newsfeedPage.clickToNavTabOnNewsfeed("Trải nghiệm");
        experienceTab = PageGenerator.createTabExperienceFeed(driver);
        log.info("Step 2.2 - Verify user stay on Experience tab");
        verifyEquals(experienceTab.getTitlePage(driver),"Trải nghiệm | Hahalolo");

        log.info("Step 3.1 - Redirect to Hotel tab");
        experienceTab.clickToNavTabOnNewsfeed("Khách sạn");
        hotelTab = PageGenerator.createTabHotelFeed(driver);
        log.info("Step 3.2 - Verify user stay on Hotel tab");
        verifyEquals(hotelTab.getTitlePage(driver),"Khách sạn | Hahalolo");

        log.info("Step 4.1 - Redirect to Shopping tab");
        hotelTab.clickToNavTabOnNewsfeed("Mua sắm");
        shoppingTab = PageGenerator.createTabShopFeed(driver);
        log.info("Step 4.2 - Verify user stay on Shopping tab");
        verifyEquals(shoppingTab.getTitlePage(driver),"Mua sắm | Hahalolo");

        log.info("Step 5.1  - Redirect to Tour tab");
        newsfeedPage.clickToNavTabOnNewsfeed("Tour");
        tourTab = PageGenerator.createTabTourFeed(driver);
        log.info("Step 5.2 - Verify user stay on Tour tab");
        verifyEquals(tourTab.getTitlePage(driver),"Tour | Hahalolo");

        log.info("Step 6.1  - Redirect to Flight tab");
        tourTab.clickToNavTabOnNewsfeed("Vé máy bay");
        flightTab = PageGenerator.createTabFlightFeed(driver);
        log.info("Step 6.2 - Verify user stay on Flight tab");
        verifyEquals(flightTab.getTitlePage(driver),"Vé máy bay | Hahalolo");

        log.info("Step 7.1  - Redirect to Newsfeed tab");
        flightTab.clickToNavTabOnNewsfeed("Bảng tin");
        newsfeedPage = PageGenerator.createTabNewsfeed(driver);
        log.info("Step 7.2 - Verify user stay on Newsfeed tab");
        verifyEquals(newsfeedPage.getTitlePage(driver),"Bảng tin | Hahalolo");
    }
    @Test
    public void TC02_switchToSettingFunctionOnHeader() {
        newsfeedPage.clickItemOnSettingMenu(driver, "Sổ tay");
        handNotePage = PageGenerator.createUserHandNotePage(driver);
        handNotePage.clickItemOnSettingMenu(driver,"Thiết lập tài khoản");
        accountSettingGeneral = PageGenerator.createAccountSettingGeneralTab(driver);
        accountSettingGeneral.clickItemOnSettingMenu(driver,"Tài khoản kinh doanh");
        businessDashboard = PageGenerator.getBusinessDashboardPage(driver);
        businessDashboard.switchToAnotherWindowByID(driver,currentTab);
        businessDashboard.clickItemOnSettingMenu(driver,"Đăng xuất");
        loginNewsfeedPage = PageGenerator.createLoginNewsfeedPage(driver);

    }
    @Test
    public void TC03_Check_Action_On_Helping_Menu(){

        newsfeedPage.clickFunctionOnHelping(driver,"Điều khoản");
        newsfeedPage.switchToAnotherWindowByID(driver,currentTab);
        driver.switchTo().window(currentTab);
        newsfeedPage.clickFunctionOnHelping(driver,"Trung tâm hỗ trợ");
        newsfeedPage.switchToAnotherWindowByID(driver,currentTab);
        driver.switchTo().window(currentTab);
        newsfeedPage.clickFunctionOnHelping(driver,"Giới thiệu");
    }

    @AfterTest(alwaysRun = true)
    public void closeTestcase(){
        closeBrowserAndDriver(driver);
    }
}
