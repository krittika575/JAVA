import java.rmi.Naming;
import java.util.Scanner;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            CalculatorInterface calculator = (CalculatorInterface) Naming.lookup("rmi://localhost:5000/calc");

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter two numbers:");
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            System.out.println("Addition: " + calculator.add(x, y));
            System.out.println("Subtraction: " + calculator.subtract(x, y));
            System.out.println("Multiplication: " + calculator.multiply(x, y));
            try {
                System.out.println("Division: " + calculator.divide(x, y));
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
