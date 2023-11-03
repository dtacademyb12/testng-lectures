package unitTests;

public class Calculator {


    public int add(int a, int b){
       return a + b;
    }

    public int multiply(int a, int b){
        return a * b;
    }

    public int divide(int i, int i1) {
        if(i1 == 0){
            return 0;
        }
        return i / i1;
    }
}
