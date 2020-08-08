package actions.common.Function;

import de.svenjacobs.loremipsum.LoremIpsum;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.Random;
public class AbstractTest {
    protected final Log log;
    protected final LoremIpsum lorem;

    protected AbstractTest() {
        log = LogFactory.getLog(getClass());
        lorem  = new LoremIpsum();
    }
    public String randomParagraphs(int numParagraph){
        return lorem.getParagraphs(numParagraph);
    }
    protected String randomPassword(int chars) {
        String text = null;
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
        StringBuilder bd = new StringBuilder(chars);
        for (int i = 0; i < chars; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            text = bd.append(AlphaNumericString.charAt(index)).toString();
        }
        return text;
    }
    protected int randomEmail() {
        Random rd = new Random();
        return rd.nextInt(1000);
    }
    protected boolean verifyTrue(boolean condition) {
        boolean status = true;
        try {
            Assert.assertTrue(condition);
        } catch (Throwable e) {
            status = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return status;
    }
    protected boolean verifyFalse(boolean condition) {
        boolean status = true;
        try {
            Assert.assertFalse(condition);
        } catch (Throwable e) {
            status = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return status;
    }
    protected boolean verifyEquals(Object actual, Object expected) {
        boolean status = true;
        try {
            Assert.assertEquals(actual, expected);
        } catch (Throwable e) {
            status = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return status;
    }
    protected void closeBrowserAndDriver(WebDriver driver) {
        try {
            String osName = System.getProperty("os.name").toLowerCase();
            String cmd = "";
            if (driver != null) {
                driver.quit();
            }
            if (driver.toString().toLowerCase().contains("chrome")) {
                if (osName.toLowerCase().contains("mac")) {
                    cmd = "pkill chromedriver";
                } else if (osName.toLowerCase().contains("windows")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
                }
            } else if (driver.toString().toLowerCase().contains("internetexplorer")) {
                if (osName.toLowerCase().contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
                }
            } else if (driver.toString().toLowerCase().contains("firefox")) {
                if (osName.toLowerCase().contains("mac")) {
                    cmd = "pkill geckodriver";
                } else if (osName.toLowerCase().contains("windows")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
                }
            }
            Process process = Runtime.getRuntime().exec(cmd);
            process.waitFor();
        } catch (Exception e) {
        }
    }

    protected String getCurrentDay() {
        DateTime nowUTC = new DateTime();
        int day = nowUTC.getDayOfMonth();
        if (day < 10) {
            String dayValue = "0" + day;
            return dayValue;
        }
        return day + "";
    }
    protected String getCurrentMonth() {
        DateTime now = new DateTime();
        int month = now.getMonthOfYear();
        if (month < 10) {
            String monthValue = "0" + month;
            return monthValue;
        }
        return month + "";
    }

    protected String getCurrentYear() {
        DateTime now = new DateTime();
        return now.getYear() + "";
    }

    protected String getToday() {
        return getCurrentDay() + "/" + getCurrentMonth() + "/" + getCurrentYear();
    }

    protected String getFullName(String firstName, String midName, String lastName){
        return  firstName.trim() + midName.trim() + lastName.trim();
    }
    protected String getFullName(String firstName, String lastName){
        return  (lastName.trim()+ " " + firstName.trim()).trim();
    }
    protected String getBirthday(String day, String month, String year){
        return day+ "-" + month + "-" + year;
    }
}
