package actions.common.DriverBrowser;

import common.Function.AbstractPage;
import org.openqa.selenium.WebDriver;
import common.Function.AbstractTest;
public abstract class DriverManager extends AbstractPage {
    protected WebDriver driver;
    AbstractTest test;
    protected abstract void createDriver();
    public void quitDriver(){
        if(driver!= null){
            driver.close();
            driver = null;
        }
    }
    public WebDriver getDriver(String urlPage){
        if(driver == null){
            createDriver();
        }
        driver.get(urlPage);
        setImplicitWait(driver);
        driver.manage().window().maximize();

        return driver;
    }
}
