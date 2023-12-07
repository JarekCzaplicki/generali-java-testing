package zadania;

public class Calculator {
    public int add(int... numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divine(int a, int b) {
//        if(b == 0) throw new IllegalArgumentException("Division by zero");
        return a / b;
    }
}
