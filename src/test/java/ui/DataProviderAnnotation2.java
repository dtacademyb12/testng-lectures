package ui;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class DataProviderAnnotation2 {




    @Test (dataProvider = "dataFromCsv")
    public void testGoogleSearchPageTitle(String fullname,
                                          String street,
                                          String city,
                                          String state,
                                          String zip,
                                          String card
                                          ){

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);


        driver.findElement(By.linkText("Order")).click();

        Faker faker = new Faker();

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys(Keys.BACK_SPACE, "2");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys(fullname);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys(street);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys(city);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys(state);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(zip);

        driver.findElement(By.name("ctl00$MainContent$fmwOrder$cardList")).click();

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(card);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("08/29");


        driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();

        Assert.assertTrue(driver.findElement(By.tagName("strong")).isDisplayed());


        driver.quit();





    }



     @DataProvider
     public Object[][] feedData(){

         Faker faker = new Faker();
        return new Object[][] {
                {faker.name().fullName() , faker.address().streetAddress(),faker.address().city(), faker.address().state(), faker.address().zipCode(),faker.business().creditCardNumber().replace("-","")},
                {faker.name().fullName() , faker.address().streetAddress(),faker.address().city(), faker.address().state(), faker.address().zipCode(),faker.business().creditCardNumber().replace("-","")},
                {faker.name().fullName() , faker.address().streetAddress(),faker.address().city(), faker.address().state(), faker.address().zipCode(),faker.business().creditCardNumber().replace("-","")},
                {faker.name().fullName() , faker.address().streetAddress(),faker.address().city(), faker.address().state(), faker.address().zipCode(),faker.business().creditCardNumber().replace("-","")},
                {faker.name().fullName() , faker.address().streetAddress(),faker.address().city(), faker.address().state(), faker.address().zipCode(),faker.business().creditCardNumber().replace("-","")},
                {faker.name().fullName() , faker.address().streetAddress(),faker.address().city(), faker.address().state(), faker.address().zipCode(),faker.business().creditCardNumber().replace("-","")},
                {faker.name().fullName() , faker.address().streetAddress(),faker.address().city(), faker.address().state(), faker.address().zipCode(),faker.business().creditCardNumber().replace("-","")},
                {faker.name().fullName() , faker.address().streetAddress(),faker.address().city(), faker.address().state(), faker.address().zipCode(),faker.business().creditCardNumber().replace("-","")},
                {faker.name().fullName() , faker.address().streetAddress(),faker.address().city(), faker.address().state(), faker.address().zipCode(),faker.business().creditCardNumber().replace("-","")},
                {faker.name().fullName() , faker.address().streetAddress(),faker.address().city(), faker.address().state(), faker.address().zipCode(),faker.business().creditCardNumber().replace("-","")}

        };
     }


    @DataProvider
    public Object[][] dataFromCsv(){

        return CSVReader.readData("data.csv");
    }
}
