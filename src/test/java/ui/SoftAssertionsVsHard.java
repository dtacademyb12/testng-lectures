package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class SoftAssertionsVsHard {




    @Test
    public void testOrder(){


        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);


        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(driver.getTitle(), "Web OrdersVGHVCC");

        driver.findElement(By.linkText("Order")).click();

        softAssert.assertEquals(
                driver.findElement(
                        By.xpath("//label[@for='ctl00_MainContent_fmwOrder_ddlProduct']")).getText(), "Product:  *");

        softAssert.assertEquals(
                driver.findElement(
                        By.xpath("//label[@for='ctl00_MainContent_fmwOrder_txtQuantity']")).getText(), "Quantity:*");

        softAssert.assertEquals(
                driver.findElement(
                        By.xpath("//label[@for='ctl00_MainContent_fmwOrder_txtName']")).getText(), "Customer name:*");


       softAssert.assertAll();
    }

}
