package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class DataProviderAnnotation {




    @Test (dataProvider = "searchTerms")
    public void testGoogleSearchPageTitle(String searchTerm){

        WebDriver driver = new ChromeDriver();

        try {

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            driver.get("https://www.google.com/");


            driver.findElement(By.name("q")).sendKeys(searchTerm, Keys.ENTER);

            String actual = driver.getTitle();

            Assert.assertEquals(actual, searchTerm + " - Google Search");
        }finally {
            driver.quit();
        }


    }



     @DataProvider (name = "searchTerms")
     public Object[][] feedData(){

        return new Object[][] {
                {"chicken"},
                {"chic-fil-a"},
                {"999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999"},
                {"1;DROP TABLE users"},
                {"ご"},
                {"አማርኛ"}

        };
     }
}
