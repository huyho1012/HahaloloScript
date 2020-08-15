package Function;
import About.BasicInfoTab.BasicInfoPageObject;
import About.DetailsAboutYou.DetailsAboutYouPageObject;
import About.LivingPlaceTab.PlaceLivingPageObject;
import About.OverviewTab.OverviewPageObject;
import About.WorkAndEducation.WorkAndEducationPageObject;
import BackendLoginPageObject;
import backendDashboardPageObject;
import BusinessDashboard;
import BusinessOverviewPageObject;
import AccountManager.CensorAccountList;
import CensorHomePage;
import Login.CensorLogin;
import UserSetting.GeneralSettingPageObject;
import Editor.ExperiencePost.ExperiencePostPageObject;
import Editor.NormalPost.NormalPostEditor;
import Handnote.UserHandNotePageObject;
import TimeLine.PersonalTimelinePageObject;
import ForgotPassword.ForgotPassWordPageObject;
import Login.LoginPageObject;
import Register.NewsFeedVerifyAccount;
import WalletLoginPageObject;
import org.openqa.selenium.WebDriver;

public class PageGenerator {
    // Khởi tạo Newsfeed Start App
    public static LoginPageObject getLoginPage(WebDriver driver){
        return new LoginPageObject(driver);
    }
    public static ForgotPassWordPageObject getForgotPassWord (WebDriver driver){
        return  new ForgotPassWordPageObject(driver);
    }


    public static NewsFeedVerifyAccount getVerifyAccountPage (WebDriver driver){
        return new NewsFeedVerifyAccount(driver);
    }
    public static NewsFeedExperience getExperienceFeed(WebDriver driver){
        return new NewsFeedExperience(driver);
    }

    public static NewsFeedFlight getFlightFeed(WebDriver driver){
        return new NewsFeedFlight(driver);
    }
    public static NewsFeedHotel getHotelFeed(WebDriver driver){
        return new NewsFeedHotel(driver);
    }
    public static NewsFeedShopping getShoppingFeed(WebDriver driver){
        return new NewsFeedShopping(driver);
    }
    public static NewsFeedHomepage getNewsFeedPage(WebDriver driver){
        return new NewsFeedHomepage(driver);
    }
    public static NewsFeedTour getTourFeed(WebDriver driver){
        return new NewsFeedTour(driver);
    }

    public static BusinessDashboard getBusinessDashboardPage(WebDriver driver){
        return new BusinessDashboard(driver);
    }
    public static PersonalTimelinePageObject getPersonalTimeLinePage(WebDriver driver){
        return new PersonalTimelinePageObject(driver);
    }
    public static BackendLoginPageObject getLoginBackendPage(WebDriver driver){
        return new BackendLoginPageObject(driver);
    }
    // Censor
    public static backendDashboardPageObject getBackendDashboardPage(WebDriver driver){
        return new backendDashboardPageObject(driver);
    }
    public static CensorLogin getCensorLoginPage(WebDriver driver){
        return new CensorLogin(driver);
    }
    public static CensorHomePage getCensorHomePage(WebDriver driver){
        return new CensorHomePage(driver);
    }
    public static CensorAccountList getAccountManagerList(WebDriver driver){
        return new CensorAccountList(driver);
    }

    // Khởi tạo tab cho Personal Wall
    public static UserHandNotePageObject createUserHandnotePage(WebDriver driver){
        return new UserHandNotePageObject(driver);
    }

    // Hàm khảo tạo các tab Personal - About
    public static OverviewPageObject getPersonalOverviewTab(WebDriver driver){
        return new OverviewPageObject(driver);
    }
    public static WorkAndEducationPageObject getPersonalEducationTab(WebDriver driver){
        return new WorkAndEducationPageObject(driver);
    }
    public static PlaceLivingPageObject getPersonalPlaceLivingTab(WebDriver driver){
        return new PlaceLivingPageObject(driver);
    }
    public static DetailsAboutYouPageObject getPersonalDetailAboutTab(WebDriver driver){
        return new DetailsAboutYouPageObject(driver);
    }
    public static BasicInfoPageObject getPersonalAboutBasicInfo(WebDriver driver) {
        return new BasicInfoPageObject(driver);
    }

    // Hàm khảo tạo Trang Login - Wallet
    public static WalletLoginPageObject createWalletLoginPage(WebDriver driver){
        return new WalletLoginPageObject(driver);
    }

    // Account Setting


    // Business
    public static BusinessOverviewPageObject createBusinessOverviewPage(WebDriver driver){
        return new BusinessOverviewPageObject(driver);
    }

    public static GeneralSettingPageObject createAccountSettingGeneralTab(WebDriver driver) {
        return new GeneralSettingPageObject(driver);
    }

    // Hàm khởi tạo Model Editor
    public static ExperiencePostPageObject openExperienceEditor (WebDriver driver){
        return new ExperiencePostPageObject(driver);
    }
    public static NormalPostEditor openNormalPostEditor(WebDriver driver){
        return new NormalPostEditor(driver);
    }
}

