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
import Newsfeed.PersonalWall.About.Common.PersonalAbout;
import Newsfeed.PersonalWall.Friends.PersonalFriend;
import Newsfeed.PersonalWall.Handnote.UserHandNotePageObject;
import Newsfeed.PersonalWall.Photo.PersonalPhoto;
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

public class CheckRedirectCorrectLink extends AbstractTest {

    String userName = GlobalVariables.FEED_EMAIL_ACCOUNT;
    String passWord = GlobalVariables.FEED_EMAIL_PASSWORD;
    String newsfeedURL = GlobalVariables.URL_NEWS_FEED_LOGIN;
    String currentTab;
    String fullName;
    String titleTab;

    // Khai báo  và khởi tạo Page generator
    DriverManager driverManager;
    WebDriver driver;
    LoginNewsfeed loginNewsfeedPage;
    NewsFeedTab newsfeedPage;
    UserHandNotePageObject handNotePage;
    PersonalTimelinePage perTimeLinePage;
    PersonalAbout perAboutPage;
    PersonalFriend  perFriendPage;
    PersonalPhoto perPhoto;
    GeneralSetting accountSettingGeneral;
    BusinessDashboard businessDashboard;
    NewsFeedExperience experienceTab;
    NewsFeedHotel hotelTab;
    NewsFeedFlight flightTab;
    NewsFeedTour tourTab;
    NewsFeedShopping shoppingTab;


    @Parameters("browser")
    @BeforeClass
    public void getBrowser(String browserName) {
        log.info("Precondition - Step 01 - Create Driver Browser");
        driverManager = BrowserDriver.getBrowser(browserName);

        log.info("Precondition - Step 02 - Open web browser and go to Newsfeed Login");
        driver = driverManager.getDriver(newsfeedURL);
        loginNewsfeedPage = PageGenerator.createLoginNewsfeedPage(driver);

        log.info("Precondition - Step 03 - Login account");
        loginNewsfeedPage.doActionLogin(driver, userName, passWord);
        newsfeedPage = PageGenerator.getNewsFeedPage(driver);

        log.info("Precondition - Step 04 - Verify Login successfully");
        verifyTrue(newsfeedPage.checkLoginSuccess(driver));

        log.info("Precondition - Step 05 - Check language default display and change language to VI");
        newsfeedPage.changeLanguageDisplayToVietnamese();
        log.info("Precondition - Step 05 - Store Full name on My account");
        fullName = newsfeedPage.getFullNameDisplayOnMyAccount(driver);
    }
//    @Test
//    public void TC01_Check_Redirect_Tab_When_User_Click_To_Item_on_Nav_Menu() {
//        log.info("Step 1 - Verify user stay on Newsfeed tab");
//        verifyEquals(newsfeedPage.getTitlePage(driver),"Bảng tin | Hahalolo");
//
//        log.info("Step 2 - Redirect to Experience tab");
//        newsfeedPage.setTimeDelay(1);
//        newsfeedPage.clickToNavTabOnNewsfeed(driver,"Trải nghiệm");
//        experienceTab = PageGenerator.createTabExperienceFeed(driver);
//        verifyEquals(experienceTab.getTitlePage(driver),"Trải nghiệm | Hahalolo");
//
//        log.info("Step 3.1 - Redirect to Hotel tab");
//        experienceTab.setTimeDelay(1);
//        experienceTab.clickToNavTabOnNewsfeed(driver,"Khách sạn");
//        hotelTab = PageGenerator.createTabHotelFeed(driver);
//        verifyEquals(hotelTab.getTitlePage(driver),"Khách sạn | Hahalolo");
//
//        log.info("Step 4.1 - Redirect to Shopping tab");
//        hotelTab.setTimeDelay(1);
//        hotelTab.clickToNavTabOnNewsfeed(driver,"Mua sắm");
//        shoppingTab = PageGenerator.createTabShopFeed(driver);
//        verifyEquals(shoppingTab.getTitlePage(driver),"Mua sắm | Hahalolo");
//
//        log.info("Step 5.1  - Redirect to Tour tab");
//        shoppingTab.setTimeDelay(1);
//        shoppingTab.clickToNavTabOnNewsfeed(driver,"Tour");
//        tourTab = PageGenerator.createTabTourFeed(driver);
//        verifyEquals(tourTab.getTitlePage(driver),"Tour | Hahalolo");
//
//        log.info("Step 6.1  - Redirect to Flight tab");
//        tourTab.setTimeDelay(1);
//        tourTab.clickToNavTabOnNewsfeed(driver,"Vé máy bay");
//        flightTab = PageGenerator.createTabFlightFeed(driver);
//        verifyEquals(flightTab.getTitlePage(driver),"Vé máy bay | Hahalolo");
//
//        log.info("Step 7.1  - Redirect to Newsfeed tab");
//        flightTab.setTimeDelay(1);
//        flightTab.clickToNavTabOnNewsfeed(driver,"Bảng tin");
//        newsfeedPage = PageGenerator.createTabNewsfeed(driver);
//        verifyEquals(newsfeedPage.getTitlePage(driver),"Bảng tin | Hahalolo");
//    }

    @Test
    public void TC02_Check_Go_To_Direct_Link_When_User_Click_To_Item_On_Helper_Menu(){
        newsfeedPage.setTimeDelay(2);
        log.info("Step 3 - Click to Halo's Terms");
        newsfeedPage.clickFunctionOnHelping(driver,"terms");
        verifyEquals(newsfeedPage.getTitleOfTabByChoose(driver,titleTab),"Điều khoản dịch vụ của HAHALOLO – Trung tâm hỗ trợ");

        log.info("Step 4 - Click to Halo's Help");
        newsfeedPage.clickFunctionOnHelping(driver,"help");
        verifyEquals(newsfeedPage.getTitleOfTabByChoose(driver,titleTab), "Trung tâm hỗ trợ");
        newsfeedPage = PageGenerator.getNewsFeedPage(driver);

        log.info("Step 2 - Click to Halo's Official");
        newsfeedPage.clickFunctionOnHelping(driver,"about");
        verifyEquals(newsfeedPage.getTitleOfTabByChoose(driver,titleTab), "Dòng thời gian - Trang cá nhân | Hahalolo");
        newsfeedPage = PageGenerator.getNewsFeedPage(driver);
    }

    @Test
    public void TC03_Check_Redirect_Link_When_User_Click_Avatar(){
        log.info("Step 1 - Click To Avatar");
        newsfeedPage.clickToAvatarUser(driver);
        perTimeLinePage = PageGenerator.getPersonalTimeLinePage(driver);

        log.info("Step 2 - Verify Go to Personal Wall success");
        verifyTrue(perTimeLinePage.checkTimeLinePersonalIsDisplay(fullName));
    }
    @Test
    public void TC04_Check_Redirect_Link_When_User_Click_Homepage(){
        log.info("Step 1 - Click To Homepage");
        perTimeLinePage.goToNewsfeedHomePage(driver);
        newsfeedPage = PageGenerator.getNewsFeedPage(driver);
        log.info("Step 2 - Verify Go to Homepage success");
        newsfeedPage.setTimeDelay(1);
        verifyTrue(newsfeedPage.checkLoginSuccess(driver));
    }
    @Test
    public void TC05_Check_Go_To_Direct_Link_When_User_Click_To_Item_On_Menu_Setting() {
        log.info("Step 1  - Redirect to Handnote Tour");
        newsfeedPage.setTimeDelay(1);
        newsfeedPage.clickItemOnSettingMenu(driver, "ic-handnotes-c");
        handNotePage = PageGenerator.createUserHandNotePage(driver);
        verifyTrue(handNotePage.checkHandnoteTourTabIsDisplay(fullName));

        log.info("Step 2  - Redirect to Account Setting");
        newsfeedPage.setTimeDelay(1);
        handNotePage.clickItemOnSettingMenu(driver, "ic-cog-c");
        accountSettingGeneral = PageGenerator.createAccountSettingGeneralTab(driver);
        verifyTrue(accountSettingGeneral.checkGeneralAccountSettingTabIsDisplay(driver, fullName));

        log.info("Step 3  - Redirect to Business Account");
        newsfeedPage.setTimeDelay(1);
        newsfeedPage.clickItemOnSettingMenu(driver, "ic-business-c");
        businessDashboard = PageGenerator.getBusinessDashboardPage(driver);
        verifyTrue(businessDashboard.checkDashboardPageIsDisplayCaseHaveBusiness(driver, titleTab));
        log.info("Step 4  - Logout account");
        businessDashboard.clickItemOnSettingMenu(driver, "ic-logout-c");
        loginNewsfeedPage = PageGenerator.createLoginNewsfeedPage(driver);
        verifyTrue(loginNewsfeedPage.checkLoginNewsfeedPageIsDisplay());
    }
    @Test
    public void TC06_Check_Go_To_Direct_Link_When_User_Click_To_Item_On_Footer() {
        loginNewsfeedPage.doActionLogin(driver,userName, passWord);
        newsfeedPage = PageGenerator.getNewsFeedPage(driver);
        newsfeedPage.setTimeDelay(3);
        log.info("Step 1  - Redirect to Cookies");
        newsfeedPage.clickToItemOnFooter(driver,"attr: {href: cookies}");
        verifyEquals(newsfeedPage.getTitleOfTabByChoose(driver,titleTab),"Chính sách Cookies – Trung tâm hỗ trợ");
        System.out.println("TabID Coo: " + currentTab);
        newsfeedPage = PageGenerator.getNewsFeedPage(driver);
        newsfeedPage.setTimeDelay(3);

        log.info("Step 1  - Redirect to Term");
        newsfeedPage.clickToItemOnFooter(driver,"attr: {href: terms}");
        verifyEquals(newsfeedPage.getTitleOfTabByChoose(driver,titleTab),"Điều khoản dịch vụ của HAHALOLO – Trung tâm hỗ trợ");
        newsfeedPage = PageGenerator.getNewsFeedPage(driver);
        newsfeedPage.setTimeDelay(1);

        log.info("Step 1  - Redirect to Privacy");
        newsfeedPage.clickToItemOnFooter(driver,"attr: {href: privacy}");
        verifyEquals(newsfeedPage.getTitleOfTabByChoose(driver,titleTab),"Chính sách dữ liệu và quyền riêng tư – Trung tâm hỗ trợ");
        newsfeedPage = PageGenerator.getNewsFeedPage(driver);
        newsfeedPage.setTimeDelay(1);

        log.info("Step 1  - Redirect to Recruitment");
        newsfeedPage.clickToItemOnFooter(driver,"recruit");
        verifyEquals(newsfeedPage.getTitleOfTabByChoose(driver,titleTab),"KÊNH TUYỂN DỤNG CÔNG TY HAHALOLO – Phát triển với quy mô toàn cầu, Hahalolo đang tuyển dụng số lượng lớn cùng nhiều vị trí và mức lương hấp dẫn.");
        newsfeedPage = PageGenerator.getNewsFeedPage(driver);
        newsfeedPage.setTimeDelay(1);

        log.info("Step 1  - Redirect to Help Center");
        newsfeedPage.clickToItemOnFooter(driver,"attr: {href: help}");
        verifyEquals(newsfeedPage.getTitleOfTabByChoose(driver,titleTab),"Trung tâm hỗ trợ");
        newsfeedPage = PageGenerator.getNewsFeedPage(driver);
        newsfeedPage.setTimeDelay(1);

        log.info("Step 2 - Click to Hahalolo - About (Hahalolo's Official");
        newsfeedPage.clickToItemOnFooter(driver,"href: about");
        verifyEquals(newsfeedPage.getTitleOfTabByChoose(driver,titleTab), "Dòng thời gian - Trang cá nhân | Hahalolo");
        perTimeLinePage = PageGenerator.getPersonalTimeLinePage(driver);
    }
    @Test
    public void TC07_Click_To_Tab_On_My_Account(){
        log.info("Step 1  - Redirect to page when click edit profile");
        perTimeLinePage.setTimeDelay(1);
        perTimeLinePage.goToNewsfeedHomePage(driver);
        newsfeedPage = PageGenerator.getNewsFeedPage(driver);

        newsfeedPage.clickEditProfile();
        perAboutPage = PageGenerator.getPersonalAboutBasicInfo(driver);
        verifyTrue(perAboutPage.checkPageAboutIsDisplay(driver,fullName));
        verifyEquals(perAboutPage.getTitlePage(driver),"Giới thiệu - Trang cá nhân | Hahalolo");
        perAboutPage.goToNewsfeedHomePage(driver);
        newsfeedPage = PageGenerator.getNewsFeedPage(driver);

        log.info("Step 2  - Redirect to page when click About");
        newsfeedPage.clickToTabDisplayOnMyAccountWidget(driver, "ic ic-about-c");
        perAboutPage = PageGenerator.getPersonalAboutBasicInfo(driver);
        verifyTrue(perAboutPage.checkPageAboutIsDisplay(driver,fullName));
        verifyEquals(perAboutPage.getTitlePage(driver),"Giới thiệu - Trang cá nhân | Hahalolo");


        log.info("Step 3  - Redirect to page when click Photo");
        perAboutPage.goToNewsfeedHomePage(driver);
        newsfeedPage = PageGenerator.getNewsFeedPage(driver);
        newsfeedPage.clickToTabDisplayOnMyAccountWidget(driver,"ic ic-photos-c");
        perPhoto = PageGenerator.getPersonalPhoto(driver);
        verifyTrue(perPhoto.checkPagePerAboutIsDisplay(driver,fullName));
        verifyEquals(perPhoto.getTitlePage(driver),"Hình ảnh - Trang cá nhân | Hahalolo");

        perPhoto.goToNewsfeedHomePage(driver);
        newsfeedPage = PageGenerator.getNewsFeedPage(driver);

        log.info("Step 4  - Redirect to page when click Friend");
        newsfeedPage.clickToTabDisplayOnMyAccountWidget(driver,"ic ic-friends-c");
        perFriendPage = PageGenerator.getPersonalFriendTab(driver);
        verifyTrue(perFriendPage.checkPerFriendIsDisplay(driver,fullName));
        verifyEquals(perFriendPage.getTitlePage(driver),"Bạn bè - Trang cá nhân | Hahalolo");
        perFriendPage.goToNewsfeedHomePage(driver);
        newsfeedPage = PageGenerator.getNewsFeedPage(driver);

    }
    @AfterTest(alwaysRun = true)
    public void closeTestcase(){
        closeBrowserAndDriver(driver);
    }
}
