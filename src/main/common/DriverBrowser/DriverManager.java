package common.DriverBrowser;
import common.GeneralHandler.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class DriverManager extends AbstractPage {
    protected WebDriver driver;
    protected abstract void createDriver();
    public void quitDriver(){
        if(driver!= null){
            driver.close();
            driver = null;
        }
    }
    public WebDriver getDriver(){
        if(driver == null){
            createDriver();
        }
        return driver;
    }
}
