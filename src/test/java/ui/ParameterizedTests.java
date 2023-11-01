package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class ParameterizedTests {


    // DATA-DRIVEN TESTING: running the same test with multiple set of data, usually fed from external sources

    @Parameters ({"username", "password"})
    @Test
    public void negativeLogin(String user, String pass){

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(user, Keys.TAB, pass, Keys.ENTER);

        Assert.assertNotEquals(driver.getTitle(), "Web Orders");

    }



}
