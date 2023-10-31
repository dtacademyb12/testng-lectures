package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TimeoutAttribute {


    WebDriver driver;
    @Test (timeOut = 10000)
    public void loginWithTimeout() throws InterruptedException {
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        Thread.sleep(100000);

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "testsvcghc", Keys.ENTER);

        Assert.assertEquals(driver.getTitle(), "Web Orders");



    }
}
