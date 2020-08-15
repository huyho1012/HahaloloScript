import actions.common.Function.AbstractPage;
import backendDashboardPageUI;
import org.openqa.selenium.WebDriver;

public class backendDashboardPageObject extends AbstractPage {
    WebDriver driver;
    public backendDashboardPageObject(WebDriver webDriver){
        driver = webDriver;
    }

    public boolean verifyLoginBackEndSuccess() {
        waitElementToClickAble(driver, backendDashboardPageUI.ACCOUNT_MANAGER_FUNCTION);
        return checkIsDisplayedElement(driver, backendDashboardPageUI.ACCOUNT_MANAGER_FUNCTION);
    }

    public void clickToItemOnMenu(WebDriver driver, String functionName) {
        waitElementToClickAble(driver, backendDashboardPageUI.MENU_BACKEND_MENU_FUNCTION,functionName);
        clickToElement(driver,backendDashboardPageUI.MENU_BACKEND_MENU_FUNCTION,functionName);
    }
}
