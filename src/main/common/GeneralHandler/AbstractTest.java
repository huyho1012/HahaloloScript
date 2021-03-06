package common.GeneralHandler;

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
import java.util.Date;
import java.util.Random;

public class AbstractTest  extends AbstractPage {
    protected final Log log;
    protected final LoremIpsum lorem;

    protected AbstractTest() {
        log = LogFactory.getLog(getClass());
        lorem  = new LoremIpsum();
    }


    private boolean checkTrue(boolean condition) {
        boolean pass = true;
        try {
            if (condition == true) {
                log.info(" -------------------------- PASSED -------------------------- ");
            } else {
                log.info(" -------------------------- FAILED -------------------------- ");
            }
            Assert.assertTrue(condition);
        } catch (Throwable e) {
            pass = false;

            // Add lỗi vào ReportNG
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyTrue(boolean condition) {
        return checkTrue(condition);
    }

    private boolean checkFailed(boolean condition) {
        boolean pass = true;
        try {
            if (condition == false) {
                log.info(" -------------------------- PASSED -------------------------- ");
            } else {
                log.info(" -------------------------- FAILED -------------------------- ");
            }
            Assert.assertFalse(condition);
        } catch (Throwable e) {
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyFalse(boolean condition) {
        return checkFailed(condition);
    }

    private boolean checkEquals(Object actual, Object expected) {
        boolean pass = true;
        try {
            Assert.assertEquals(actual, expected);
            log.info(" -------------------------- PASSED -------------------------- ");
        } catch (Throwable e) {
            pass = false;
            log.info(" -------------------------- FAILED -------------------------- ");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyEquals(Object actual, Object expected) {
        return checkEquals(actual, expected);
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
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz"+ " ";
        char[] chars  = AlphaNumericString.toCharArray();
        String text = null;
        StringBuilder bd = new StringBuilder(numChar);
        Random rd = new Random();
            for (int i = 0; i < numChar; i++) {
               char c = chars[rd.nextInt(chars.length)];
               text = bd.append(c).toString();
        }
        return text;
    }
    protected Date getDateTimeNow(){
        Date date = new Date();
        return date;
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

    public void convertPostContent(String postContains){

        char c = postContains.charAt(postContains.length());

    }
}
