import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTests {



    @Test
    public void test1(){
        Calculator calculator = new Calculator();
        int result = calculator.add(5, 7);
        Assert.assertEquals(result, 12);
    }

    @Test
    public void test2(){
        Calculator calculator = new Calculator();
        int result = calculator.add(0, 0);
        Assert.assertEquals(result, 0);
    }

    @Test
    public void test3(){
        Calculator calculator = new Calculator();
        int result = calculator.add(-1, -1);
        Assert.assertEquals(result, -2);
    }
}
