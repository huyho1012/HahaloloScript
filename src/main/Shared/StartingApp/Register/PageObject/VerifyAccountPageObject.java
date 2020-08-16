package StartingApp.Register.PageObject;

import CommonHelper.Function.AbstractPage;
import CommonHelper.Function.PageGenerator;
import CommonHelper.GlobalVariables;
import Newsfeed.TabFeed.NewsFeedTabPageObject;
import StartingApp.Register.RegisterPageUI;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class VerifyAccountPageObject extends AbstractPage {
    WebDriver driver;
    public VerifyAccountPageObject(WebDriver webDriver){
        driver = webDriver;
    }

    public Boolean checkAccountDisplayOnRegisterPage(String account) {
        waitElementToVisible(driver, RegisterPageUI.CONTENT_VERIFY);
        return getTextOfElement(driver, RegisterPageUI.CONTENT_VERIFY).contains(account);
    }

    public Boolean checkTitlePageVerifyEmail() {
        waitElementToVisible(driver, RegisterPageUI.TITLE_VERIFY_ACCOUNT_PAGE_BY,"email");
        return getTextOfElement(driver, RegisterPageUI.TITLE_VERIFY_ACCOUNT_PAGE_BY,"email").contains("Xác minh tài khoản bằng email");
    }

    public Boolean checkTitlePageVerifyPhone() {
        waitElementToVisible(driver, RegisterPageUI.TITLE_VERIFY_ACCOUNT_PAGE_BY,"phone");
        return getTextOfElement(driver, RegisterPageUI.TITLE_VERIFY_ACCOUNT_PAGE_BY,"phone").contains("Xác minh tài khoản bằng điện thoại");
    }

    public void inputVerifyDataOnField(String verifyCode) {
        waitElementToVisible(driver, RegisterPageUI.VERIFY_CODE_TEXT_BOX);
        sendKeyToElement(driver, RegisterPageUI.VERIFY_CODE_TEXT_BOX,verifyCode);
    }

    public NewsFeedTabPageObject clickVerifyButton() {
        waitElementToClickAble(driver, RegisterPageUI.VERIFY_BUTTON);
        clickToElement(driver, RegisterPageUI.VERIFY_BUTTON);
        setTimeDelay(1);
        return PageGenerator.getNewsFeedPage(driver);
    }

    public String getVerifyCode() {
        waitElementToVisible(driver, RegisterPageUI.VERIFY_MESSAGE_CODE);
        return getTextOfElement(driver, RegisterPageUI.VERIFY_MESSAGE_CODE);
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
