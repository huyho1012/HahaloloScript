package CommonHelper.Function;

import de.svenjacobs.loremipsum.LoremIpsum;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
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
    protected String randomPassword(int numPassChar) {
        String text = null;
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
        StringBuilder bd = new StringBuilder(numPassChar);
        for (int i = 0; i < numPassChar; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            text = bd.append(AlphaNumericString.charAt(index)).toString();
        }
        return text;
    }
    protected String randomSentence(int numChar) {
        String text = null;
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz"+ " ";
        StringBuilder bd = new StringBuilder(numChar);
        for (int i = 0; i < numChar; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            text = bd.append(AlphaNumericString.charAt(index)).toString();
        }
        return text;
    }
    protected int randomNumber(int number){
        Random rd = new Random();
        return rd.nextInt(number);
    }
    protected int randomEmail() {
        Random rd = new Random();
        return rd.nextInt(10000000);
    }

    public String createVirtualMail(){
        String domainEmail = "@mailinator.com";
        String sutrix = String.valueOf(randomNumber(300000));
        String refix = "huyho";
        return  refix+sutrix+domainEmail;

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

    public String getContentToClipBoard(){
        String content;
        try {
            return content = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null).getTransferData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
