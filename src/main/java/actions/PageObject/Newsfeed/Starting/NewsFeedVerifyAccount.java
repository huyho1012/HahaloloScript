package actions.PageObject.Newsfeed.Starting;

import actions.PageObject.Newsfeed.PageFeed.NewsFeedHomepage;
import actions.common.Function.AbstractPage;
import actions.common.Function.PageGenerator;
import actions.common.GlobalVariables;
import interfaces.Newsfeed.StartWeb.VerificationAccountPageUI;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class NewsFeedVerifyAccount extends AbstractPage {
    WebDriver driver;
    public NewsFeedVerifyAccount(WebDriver webDriver){
        driver = webDriver;
    }

    public Boolean checkAccountDisplayOnRegisterPage(String account) {
        waitElementToVisible(driver, VerificationAccountPageUI.CONTENT_VERIFY);
        return getTextOfElement(driver, VerificationAccountPageUI.CONTENT_VERIFY).contains(account);
    }

    public Boolean checkTitlePageVerifyEmail() {
        waitElementToVisible(driver, VerificationAccountPageUI.TITLE_VERIFY_ACCOUNT_PAGE_BY,"email");
        return getTextOfElement(driver, VerificationAccountPageUI.TITLE_VERIFY_ACCOUNT_PAGE_BY,"email").contains("Xác minh tài khoản bằng email");
    }

    public Boolean checkTitlePageVerifyPhone() {
        waitElementToVisible(driver, VerificationAccountPageUI.TITLE_VERIFY_ACCOUNT_PAGE_BY,"phone");
        return getTextOfElement(driver, VerificationAccountPageUI.TITLE_VERIFY_ACCOUNT_PAGE_BY,"phone").contains("Xác minh tài khoản bằng điện thoại");
    }

    public void inputVerifyDataOnField(String verifyCode) {
        waitElementToVisible(driver, VerificationAccountPageUI.VERIFY_CODE_TEXT_BOX);
        sendKeyToElement(driver, VerificationAccountPageUI.VERIFY_CODE_TEXT_BOX,verifyCode);
    }

    public NewsFeedHomepage clickVerifyButton() {
        waitElementToClickAble(driver, VerificationAccountPageUI.VERIFY_BUTTON);
        clickToElement(driver, VerificationAccountPageUI.VERIFY_BUTTON);
        setTimeDelay(1);
        return PageGenerator.getNewsFeedPage(driver);
    }

    public String getVerifyCode() {
        waitElementToVisible(driver, VerificationAccountPageUI.VERIFY_MESSAGE_CODE);
        return getTextOfElement(driver, VerificationAccountPageUI.VERIFY_MESSAGE_CODE);
    }
    public String getVerificationAccountCode(String emailAddress) {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        openNewWindow(driver, GlobalVariables.URL_MAILINATOR);
        waitElementToVisible(driver, GlobalVariables.MAIl_SEARCH_BOX);
        sendKeyToElement(driver, GlobalVariables.MAIl_SEARCH_BOX, emailAddress);
        clickToElement(driver, GlobalVariables.SEARCH_BOX);
        clickToElement(driver, GlobalVariables.EMAIL_VERIFY_ACCOUNT);
        switchToFrameOrIFrame(driver, GlobalVariables.FRAME_BODY_MESSAGE);
        waitElementToVisible(driver, GlobalVariables.VERIFY_CODE_VALUE);
        String code = getTextOfElement(driver, GlobalVariables.VERIFY_CODE_VALUE);
        driver.close();
        driver.switchTo().window(tabs.get(0));
        return code;
    }
}
