package testcases.newsfeed;

import CommonHelper.DriverBrowser.BrowserDriver;
import CommonHelper.DriverBrowser.DriverManager;
import CommonHelper.Function.AbstractTest;
import CommonHelper.Function.PageGenerator;
import CommonHelper.GlobalVariables;
import Newsfeed.TabFeed.NewsFeedTabPageObject;

import StartingApp.Login.LoginNewsfeed;
import Newsfeed.UserSetting.PageObject.GeneralSettingPageObject;
import Handnote.UserHandNotePageObject;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class CheckRedirectCorrectLink extends AbstractTest {
    String currentTab;

    DriverManager driverManager;
    WebDriver driver;
    LoginNewsfeed loginNewsfeedPage;
    NewsFeedTabPageObject newsfeedPage;
    UserHandNotePageObject handNotePage;
    GeneralSettingPageObject accountSettingGeneral;


    @Parameters("browser")
    @BeforeClass
    public void getBrowser(String browserName){
        log.info("Precondition - Step 01 - Open browser");
        driverManager = BrowserDriver.getBrowser(browserName);
        log.info("Precondition - Step 02 - Login with account");
        driver= driverManager.getDriver(GlobalVariables.URL_NEWS_FEED_LOGIN);
        loginNewsfeedPage = PageGenerator.createLoginNewsfeedPage(driver);
        loginNewsfeedPage.enterUsernameToLogin(GlobalVariables.FEED_EMAIL_ACCOUNT);
        loginNewsfeedPage.enterPasswordToLogin(GlobalVariables.FEED_EMAIL_PASSWORD);
        loginNewsfeedPage.clickLoginButton();
        newsfeedPage = PageGenerator.getNewsFeedPage(driver);
        log.info("Precondition - Step 03 - Check language default display and change language to VI");
        newsfeedPage.changeLanguageDisplay();
        currentTab= driver.getWindowHandle();
    }
//    @Test
//    public void TC01_switchToTabFeedOnMenu() {
//        newsfeedPage.changeLanguageDisplay();
//        newsfeedPage.clickToElementOnMenu(driver, "Trải nghiệm");
//        experiencePage = PageGenerator.getExperienceFeed(driver);
//        verifyTrue(experiencePage.checkExperienceTabSelected());
//        experiencePage.clickToElementOnMenu(driver, "Khách sạn");
//        hotelPage = PageGenerator.getHotelFeed(driver);
//        verifyTrue(hotelPage.checkHotelTabSelected());
//        hotelPage.clickToElementOnMenu(driver, "Tour");
//        tourPage = PageGenerator.getTourFeed(driver);
//        verifyTrue(tourPage.checkTourTabSelected());
//        tourPage.clickToElementOnMenu(driver, "Mua sắm");
//        shopPage = PageGenerator.getShoppingFeed(driver);
//        verifyEquals(shopPage.getTitle("Mua sắm"),"Mua sắm | Hahalolo");
//        shopPage.clickToElementOnMenu(driver, "Vé máy bay");
//        flightPage = PageGenerator.getFlightFeed(driver);
//        verifyEquals(flightPage.checkFlightTabSelected(),"Tìm kiếm chuyến bay cho hành trình của bạn!");
//        flightPage.clickToElementOnMenu(driver,"Bảng tin");
//        newsfeedPage = PageGenerator.getNewsFeed(driver);
//        verifyTrue(newsfeedPage.checkNewsFeedTabSelected());
//    }
//    @Test
//    public void TC02_switchToSettingFunctionOnHeader() {
//        newsfeedPage.clickItemOnSettingMenu(driver, "Sổ tay");
//        handNotePage = PageGenerator.createUserHandnotePage(driver);
//        handNotePage.clickItemOnSettingMenu(driver,"Thiết lập tài khoản");
//        accountSettingGeneral = PageGenerator.createAccountSettingGeneralTab(driver);
//        accountSettingGeneral.clickItemOnSettingMenu(driver,"Tài khoản kinh doanh");
//        businessPage = PageGenerator.getBusinessDashboardPage(driver);
//        businessPage.switchToAnotherWindowByID(driver,titlePage);
//        businessPage.clickItemOnSettingMenu(driver,"Đăng xuất");
//        loginPage = PageGenerator.getLoginPage(driver);
//
//    }
//    @Test
//    public void TC03_Check_Action_On_Helping_Menu(){
//
//        newsfeedPage.clickFunctionOnHelping(driver,"Điều khoản");
//        newsfeedPage.switchToAnotherWindowByID(driver,titlePage);
//        driver.switchTo().window(titlePage);
//        newsfeedPage.clickFunctionOnHelping(driver,"Trung tâm hỗ trợ");
//        newsfeedPage.switchToAnotherWindowByID(driver,titlePage);
//        driver.switchTo().window(titlePage);
//        newsfeedPage.clickFunctionOnHelping(driver,"Giới thiệu");
//    }

    @AfterTest(alwaysRun = true)
    public void closeTestcase(){
        closeBrowserAndDriver(driver);
    }
}
