package testcases.newsfeed;

import actions.PageObject.Business.Business.BusinessDashboard;
import actions.PageObject.Newsfeed.PageFeed.*;
import actions.PageObject.Newsfeed.Starting.NewsFeedLogin;
import actions.common.DriverBrowser.BrowserDriver;
import actions.common.DriverBrowser.DriverManager;
import actions.common.Function.AbstractTest;
import actions.common.Function.PageGenerator;
import actions.common.GlobalVariables;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CheckRedirectCorrectLink extends AbstractTest {
    DriverManager driverManager;
    WebDriver driver;
    NewsFeedLogin loginPage;
    NewsFeedExperience experiencePage;
    NewsFeedHotel hotelPage;
    NewsFeedTour tourPage;
    NewsFeedShopping shopPage;
    NewsFeedHomepage newsfeedPage;
    NewsFeedFlight flightPage;
    String titlePage;
    BusinessDashboard businessPage;
    NewsFeedAccSettingGeneral accountSettingPage;
    NewsFeedHandnoteTour handNotePage;

    @Parameters("browser")
    @BeforeClass
    public void getBrowser(String browserName){
    driverManager = BrowserDriver.getBrowser(browserName);
    driver= driverManager.getDriver(GlobalVariables.URL_NEWS_FEED_LOGIN);
    loginPage = PageGenerator.getLoginPage(driver);
    loginPage.enterDataToTextBoxField(driver,"identity",GlobalVariables.FEED_EMAIL_ACCOUNT);
    loginPage.enterDataToTextBoxField(driver,"password",GlobalVariables.FEED_EMAIL_PASSWORD);
    loginPage.clickToLoginButton();
    newsfeedPage = PageGenerator.getNewsFeedPage(driver);
    newsfeedPage.changeLanguageDisplay();
    titlePage= driver.getWindowHandle();
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
//        newsfeedPage = PageGenerator.getNewsFeed(driver);
//        newsfeedPage.clickToSettingItem(driver, "ic-handnotes-c");
//        handNotePage = PageGenerator.tourHandNotePage(driver);
//        handNotePage.clickToSettingItem(driver,"ic-cog-c");
//        accountSettingPage = PageGenerator.getAccountSettingPage(driver);
//        accountSettingPage.clickToSettingItem(driver,"ic-business-c");
//        businessPage = PageGenerator.getBusinessDashboardPage(driver);
//        titlePage = driver.getWindowHandle();
//        businessPage.switchToAnotherWindow(driver,titlePage);
//        businessPage.clickToSettingItem(driver,"ic-logout-c");
//        loginPage = PageGenerator.getLoginPage(driver);
//
//    }
    @Test
    public void TC03_Check_Action_On_Helping_Menu(){

        newsfeedPage.clickFunctionOnHelping(driver,"Điều khoản");
        newsfeedPage.switchToAnotherWindowByID(driver,titlePage);
        driver.switchTo().window(titlePage);
        newsfeedPage.clickFunctionOnHelping(driver,"Trung tâm hỗ trợ");
        newsfeedPage.switchToAnotherWindowByID(driver,titlePage);
        driver.switchTo().window(titlePage);
        newsfeedPage.clickFunctionOnHelping(driver,"Giới thiệu");
    }

//    @AfterTest(alwaysRun = true)
//    public void closeTestcase(){
//        closeBrowserAndDriver(driver);
//    }
}
