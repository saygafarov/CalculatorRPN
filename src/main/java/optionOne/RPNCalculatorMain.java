package optionOne;

import java.util.Scanner;

public class RPNCalculatorMain {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        ParserToRPN calculator = new ParserToRPN(scanner.nextLine());
        CalculateRPN.rpnToAnswer(calculator.parserToRPN());
        System.out.println(2.2 * 2 + 9.0 / 3 + -1);
    }
}
