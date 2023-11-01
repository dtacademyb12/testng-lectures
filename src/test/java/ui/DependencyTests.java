package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DependencyTests {

    WebDriver driver;


     @BeforeClass (alwaysRun = true) // this ensures that before and after methods are run during group tests
                                    // the default behaviour is they don't run
     public void setup(){
         driver = new ChromeDriver();

         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

         driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
     }

     @AfterClass (alwaysRun = true)
     public void tearDown(){
         driver.quit();
     }


    @Test (groups = {"smoke","login"})
    public void login(){


        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "testsvcghc", Keys.ENTER);

        Assert.assertEquals(driver.getTitle(), "Web Orders");
    }

    @Test (dependsOnMethods = "login")
    public void verifyLinks(){

        List<WebElement> elements = driver.findElements(By.xpath("//ul[@id='ctl00_menu']//a"));
        if(elements.isEmpty()){
            throw new UnsupportedOperationException("List is empty");
        }
        elements.forEach(s -> Assert.assertTrue(s.isDisplayed()));
    }

    @Test (dependsOnMethods = {"login", "verifyLinks"})
    public void verifyUserInfo(){
       Assert.assertTrue(driver.findElement(By.xpath("//div[@class='login_info']")).isDisplayed());
    }

}
