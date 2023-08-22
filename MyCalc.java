package mycalculator;
import java.util.Scanner;
import java.util.InputMismatchException;

public class MyCalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = readInt("Write your int number 1:", scanner);
        int b = readInt("Write your int number 2:", scanner);
        char operation = readOperation(scanner);

        int result = calculate(a, b, operation);
        System.out.println("Result: " + result);

        scanner.close();
    }

    private static int readInt(String message, Scanner scanner) {
        int num = 0;

        while (true) {
            System.out.println(message);
            try {
                num = scanner.nextInt();
                break; // Выход из цикла, если введено целое число
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Очистка ввода
            }
        }

        return num;
    }

    private static char readOperation(Scanner scanner) {
        System.out.println("Write your sign ( * / - + )");
        String sign = scanner.next();

        if (sign.length() == 1) {
            return sign.charAt(0);
        } else {
            System.out.println("Invalid sign. Defaulting to addition (+).");
            return '+';
        }
    }

    private static int calculate(int a, int b, char operation) {
        switch (operation) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '/':
                return a / b;
            case '*':
                return a * b;
            default:
                System.out.println("Unsupported operation. Defaulting to addition (+).");
                return a + b;
        }
    }
}
