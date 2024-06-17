import java.util.InputMismatchException;
import java.util.Scanner;

public class SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = getValidNumber("Enter the first number: ", scanner);
        int num2 = getValidNumber("Enter the second number: ", scanner);

        int sum = calculateSum(num1, num2);

        System.out.println("The sum of the two numbers is: " + sum);

        scanner.close();
    }

    private static int getValidNumber(String prompt, Scanner scanner) {
        int num = 0;
        while (true) {
            try {
                System.out.print(prompt);
                num = scanner.nextInt();
                return num;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear the invalid input
            }
        }
    }

    private static int calculateSum(int num1, int num2) {
        return num1 + num2;
    }
}