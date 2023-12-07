package tdd;


public class Fibonacci {


    public static int getValueRec(int element) {
        if (element == 0 || element == 1) {
            System.out.println("Element końcowy: " + element);
            return element;
        }
            System.out.println("Kolejna liczba" + element);

        return getValue(element - 2) + getValue(element - 1);
    }

    public static Integer getValue(int value) {
        if (value == 0 || value == 1) return value;

        int result = 0;
        int firstNumber = 0;
        int secondNumber = 1;

        if (value > 1) {
            for (int i = 2; i <= value; i++) {
                result = firstNumber + secondNumber;
                firstNumber = secondNumber;
                secondNumber = result;
                System.out.println("Pierwsza liczba: " + firstNumber + "druga liczba: " + "Suma liczb: " + result);
            }
        }
        return result;
    }
}
