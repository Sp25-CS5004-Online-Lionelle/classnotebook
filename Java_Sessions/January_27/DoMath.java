import java.util.Objects;
import java.util.Scanner;

public class DoMath {
    private static final Scanner userInputScanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nBasic Lambdas ---------------");
        demonstrateBasicLambdas();

        System.out.println("\nDefining Lambdas inside Method Call ---------------");
        demonstrateInlineLambdas();

        System.out.println("\nReferencing static methods ---------------");
        demonstrateMethodReferencesToStatic();

        System.out.println("\nReferencing non static methods ---------------");
        demonstrateMethodReferencesToNonStatic();
    }

    public static void runCalculation(Calculator calc, String operator) {
        System.out.printf("Math Operator we're using is: %s", operator);

        // Get numbers from the user
        System.out.println("\n\tEnter a number:");
        int x = userInputScanner.nextInt();

        System.out.println("\tEnter another number:");
        int y = userInputScanner.nextInt();

        // Perform the calculation
        int answer = calc.calculate(x, y);
        System.out.printf("\t%d %s %d = %d\n\n", x, operator, y, answer);
    }

    public static void demonstrateBasicLambdas() {
        /*
         * python syntax for lambdas (maybe???)
         * my_func = lambda: x, y -> x + y
         * */

        Calculator multiply = (x, y) -> {
            return x * y;
        };

        Calculator subtract = (x, y) -> x - y;

        Calculator exponent = (x, y) -> {
            int result = x;
            for (int i = 1; i < y; i++) {
                result = result * x;
            }
            return result;
        };

        runCalculation(multiply, "*");
        runCalculation(subtract, "-");
        runCalculation(exponent, "^");

//        //let the user choose the operation
//        System.out.println("GIVE ME AN OPERATOR");
//        String choice = userInputScanner.nextLine();
//
//        if (Objects.equals(choice, "*")) {
//            runCalculation(multiply, "*");
//        } else if (Objects.equals(choice, "-")) {
//            runCalculation(subtract, "-");
//        } else {
//            System.out.println("Sorry I didn't write code for the rest");
//        }
    }

    public static void demonstrateInlineLambdas() {
        // defining a lambda inside of the parenthesis
        // I didn't explicitly say it was implementing Calculator BUT...
        // the lambda has the same number of parameters and return type
        // so JVM allows it

        runCalculation((x, y) -> x + y, "+");
        runCalculation((x, y) -> x / y, "/");
    }

    public static void demonstrateMethodReferencesToStatic() {
        // the NumberCruncher class doesn't implement Calculator
        // but the multiply method has the same number & type of params
        // and the same return type as the method in the Calculator interface
        // so the JVM allows it

        runCalculation(NumberCruncher::multiply, "*");
        runCalculation(NumberCruncher::subtract, "-");
        runCalculation(NumberCruncher::exponent, "^");
    }

    public static void demonstrateMethodReferencesToNonStatic() {
        NumberCruncher numCrunch = new NumberCruncher();
        runCalculation(numCrunch::randomMath, "??");
    }
}

