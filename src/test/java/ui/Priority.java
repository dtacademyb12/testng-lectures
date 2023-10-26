package ui;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;


@Test // Test annotation can be applied on class level which means all methods will receive that annotation
public class Priority {

    @Test (priority = 2, enabled = false, description = "positiveLogin")
    public void test_x(){
        System.out.println("Test x");
    }

    @Ignore // equivalent to @Test(enabled=false)
    public void test_y(){
        System.out.println("Test y");
    }

    @Test (priority = -1000)
    public void test_a(){
        System.out.println("Test a");
    }

    @Test (priority = -1)  // same priorities are determined alphabetically
    public void test_f(){
        System.out.println("Test f");
    }

    @Test // no priority means 0
    public void test_k(){
        System.out.println("Test k");
    }

    @Test (priority = -1)
    public void test_z(){
        System.out.println("Test z");
    }



}
