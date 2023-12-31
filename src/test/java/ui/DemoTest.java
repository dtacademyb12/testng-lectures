package ui;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DemoTest {


    WebDriver driver;

    @BeforeMethod
   public void setupTest(){
       driver = new ChromeDriver();

       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

       driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
   }

   @AfterMethod
   public void cleanUp(){
       driver.quit();
   }



    @Test
    public void positiveLogin(){

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);

        Assert.assertEquals(driver.getTitle(), "Web Orders");


    }


    @Test
    public void negativeLoginWithInvalidUsername(){



        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("InvalidUser", Keys.TAB, "test", Keys.ENTER);

        Assert.assertNotEquals(driver.getTitle(), "Web Orders");



    }

    @Test
    public void negativeLoginWithInvalidPassword(){



        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "invalid", Keys.ENTER);

        Assert.assertNotEquals(driver.getTitle(), "Web Orders");



    }

    @Test
    public void negativeLoginWithNoCredentials(){



        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("", Keys.TAB, "", Keys.ENTER);

        Assert.assertNotEquals(driver.getTitle(), "Web Orders");



    }


}
