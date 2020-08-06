package testcases.business;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BusinessPage {
    WebDriver driver;
    String email = "huy.test"+ Random() + "@mailinator.com";
    @BeforeTest
    public void Connection(){
        System.setProperty("webdriver.chrome.driver", "browserDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://test-newsfeed.hahalolo.com/auth/signin");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
     public void SetUpAccount(){
        driver.findElement(By.name("nv104")).sendKeys("Huy");
        driver.findElement(By.name("nv103")).sendKeys("Hồ");
        driver.findElement(By.name("nv108")).sendKeys(email);
        driver.findElement(By.name("nv109")).sendKeys("123456");
        driver.findElement(By.name("repeatPassword")).sendKeys("123456");
        driver.findElement(By.id("signUpButton")).click();
        driver.findElement(By.name("code")).sendKeys(GetCodeOnMailnator());
        driver.findElement(By.xpath("//button[@class= 'btn btn-block btn-primary']")).click();
    }
    public void GoToBusiness(){
        SetUpAccount();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//button[contains(text(),'Bỏ qua')]")).click();
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//i[@class= 'ic ic-caret-down primary']")).click();
        driver.findElement(By.xpath("//i[@class= 'ic ic-caret-down primary']//parent::span//following-sibling::div//a[position()= 3]")).click();

    }
    public int Random(){
        Random rd = new Random();
        return rd.nextInt(100);
    }
    public String GetCodeOnMailnator(){
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://www.mailinator.com/");
        driver.findElement(By.id("addOverlay")).sendKeys(email);
        driver.findElement(By.id("go-to-public")).click();
        driver.findElement(By.xpath("//a[@class = 'ng-binding']")).click();
        driver.switchTo().frame(0);
        String Code =  driver.findElement(By.xpath("//p[contains(text(),'Bạn có thể được yêu cầu nhập mã xác nhận này')]//following-sibling::h2")).getText();
        driver.close();
        driver.switchTo().window(tabs.get(0));
        return Code;
    }
    public void CopyURL(String url){
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        robot.setAutoDelay(2000);
        StringSelection ss = new StringSelection(url);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        robot.setAutoDelay(1000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.setAutoDelay(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
    // Chức năng tạo doanh nghiệp
    public void  CreateBusinessTypePersonal(){
        GoToBusiness();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.findElement(By.xpath("//a[contains(text(),'Tạo tài khoản kinh doanh')]")).click();
        List<WebElement> typeBusi = driver.findElements(By.xpath("//label[@class = 'custom-control-label']"));
        typeBusi.get(0).click();
        driver.findElement(By.name("bv104")).sendKeys("Doanh nghiệp 1 thành viên");
        driver.findElement(By.xpath("//button[contains(text(),'Hoàn thành')]")).click();
    }
    public void  CreateBusinessTypeEnterpise(){
        GoToBusiness();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.findElement(By.xpath("//a[contains(text(),'Tạo tài khoản kinh doanh')]")).click();
        List<WebElement> typeBusi = driver.findElements(By.xpath("//label[@class = 'custom-control-label']"));
        typeBusi.get(1).click();
        driver.findElement(By.name("bv104")).sendKeys("Doanh nghiệp 1 thành viên");
        driver.findElement(By.xpath("//button[contains(text(),'Hoàn thành')]")).click();
    }
    public void SendVerifyRequestWithTypeBusi(String companyName, String otherName, String abbName, String taxCode , String reprenName, String regisAddress, String code, String companyPhone, String companyEmail, String companyScope){
        System.out.println(driver);
        CreateBusinessTypeEnterpise();
        driver.findElement(By.xpath("//div[@class ='menu-container menu--scrollable']//a[position() =2]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Xác minh tài khoản kinh doanh doanh nghiệp')]")).click();
        // Tên công ty
        WebElement bv102 = driver.findElement(By.name("bv102"));
        bv102.clear();
        bv102.sendKeys(companyName);
        // Tên gọi khác
        WebElement bv103 = driver.findElement(By.name("bv103"));
        bv103.clear();
        bv103.sendKeys(otherName);
        // Tên viết tắt
        WebElement bv104 = driver.findElement(By.name("bv104"));
        bv104.clear();
        bv104.sendKeys(abbName);
        // Mã số thuế
        WebElement bv105 = driver.findElement(By.name("bv105"));
        bv105.clear();
        bv105.sendKeys(taxCode);
        // Tên người đại diện
        WebElement bv107 = driver.findElement(By.name("bv107"));
        bv107.clear();
        bv107.sendKeys(reprenName);
        // Địa chỉ đăng ký kinh doanh
        WebElement bv110 = driver.findElement(By.name("bv110"));
        bv110.clear();
        bv110.sendKeys(regisAddress);
        bv110.sendKeys(Keys.ENTER);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Điện thoại doanh nghiệp
        WebElement bv109 = driver.findElement(By.name("bv109"));
        bv109.clear();
        bv109.sendKeys(companyPhone);
        // Email doanh nghiệp
        WebElement bv108 = driver.findElement(By.name("bv108"));
        bv108.clear();
        bv108.sendKeys(companyEmail);
        // Lĩnh vực doanh nghiệp
        WebElement bv111 = driver.findElement(By.name("bv111"));
        bv111.clear();
        bv111.sendKeys(companyScope);
        // Updload File
        WebElement btnUpload = driver.findElement(By.xpath("//span[contains(text(),'Tải tệp lên')]"));
        btnUpload.click();
        CopyURL("D:\\Automation Learning\\FileUploadForAuto\\File.txt");
        driver.findElement(By.xpath("//span[contains(text(),'Gửi yêu cầu xác minh')]")).click();
        driver.findElement(By.xpath("//a[@class='btn btn-outline-secondary']//span")).click();
        System.out.println("thanh cong rồi");
    }

    @AfterTest
    public void Close(){
        driver.close();
    }
}
