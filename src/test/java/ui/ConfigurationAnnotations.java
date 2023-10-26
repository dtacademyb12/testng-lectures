package ui;

import org.testng.annotations.*;

public class ConfigurationAnnotations {

    @BeforeSuite
    public void setupSuite(){
        System.out.println("Before Suite");
    }

    @AfterSuite
    public void tearDownSuite(){
        System.out.println("After Suite");
    }

    @BeforeTest
    public void setupTestSubcategory(){
        System.out.println("Before the test subcategory");
    }

    @AfterTest
    public void tearDownTestSubcategory(){
        System.out.println("After the test subcategory");
    }

    @BeforeClass
    public void setupClass(){
        System.out.println("Before class");
    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("After class");
    }

    @BeforeMethod
    public void setupEachTest(){
        System.out.println("Before each test method");
    }

    @AfterMethod
    public void tearDownEachTestMethod(){
        System.out.println("After each test method");
    }



    @Test
    public void test1(){
        System.out.println("Test 1");
    }

    @Test
    public void test2(){
        System.out.println("Test 2");
    }

    @Test
    public void test3(){
        System.out.println("Test 3");
    }
}
