package testcases.newsfeed;

import PostGenrate.NewsFeedHomepage;
import BusinessDashboard;
import UserSetting.GeneralSettingPageObject;
import Handnote.UserHandNotePageObject;
import Login.LoginPageObject;
import actions.common.DriverBrowser.BrowserDriver;
import actions.common.DriverBrowser.DriverManager;
import actions.common.Function.AbstractTest;
import actions.common.Function.PageGenerator;
import actions.common.GlobalVariables;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class CheckRedirectCorrectLink extends AbstractTest {
    DriverManager driverManager;
    WebDriver driver;
    LoginPageObject loginPage;
    NewsFeedHomepage newsfeedPage;
    String titlePage;
    BusinessDashboard businessPage;
    UserHandNotePageObject handNotePage;
    GeneralSettingPageObject accountSettingGeneral;


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
