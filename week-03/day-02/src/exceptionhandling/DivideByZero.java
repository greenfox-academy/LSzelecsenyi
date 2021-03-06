package exceptionhandling;// create a function that takes a number
// divides ten with it,
// and prints the result.
// it should print "fail" if the parameter is 0

import java.util.Scanner;

public class DivideByZero {

    public static void main(String[] args) {

        divide();
    }

    public static void divide() {
        Scanner sc = new Scanner(System.in);
        int divisor = sc.nextInt();
        try {
            int result = 10 / divisor;
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("Can't divide by zero!");
        }
    }
}
