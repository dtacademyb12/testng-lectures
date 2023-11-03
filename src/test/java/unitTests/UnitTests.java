package unitTests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTests {



    @Test
    public void test1(){
        Calculator calculator = new Calculator();
        int result = calculator.add(5, 7);
        Assert.assertEquals(result, 12);
    }

    @Test (groups = "smoke")
    public void test2(){
        Calculator calculator = new Calculator();
        int result = calculator.add(0, 0);
        Assert.assertEquals(result, 0);
    }

    @Test (groups = "smoke")
    public void test3(){
        Calculator calculator = new Calculator();
        int result = calculator.add(-1, -1);
        Assert.assertEquals(result, -2);
    }


    @Test
    public void test4(){
        Calculator calculator = new Calculator();
        int result = calculator.multiply(5, 6);
        Assert.assertEquals(result, 30);
    }

    @Test
    public void test5(){
        Calculator calculator = new Calculator();
        int result = calculator.multiply(245386564, 245386564);
        Assert.assertEquals(result, 60214565791726100L);
    }

    @Test
    public void testDivideFunction(){
        Calculator calculator = new Calculator();
        int result = calculator.divide(10, 5);
        Assert.assertEquals(result, 2);
    }

    @Test
    public void testDivideFunction2(){
        Calculator calculator = new Calculator();
        int result = calculator.divide(10, 0);
        Assert.assertEquals(result, 0);
    }
}
