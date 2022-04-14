package optionOne;

import java.util.Scanner;

public class RPNCalculatorMain {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws CalculationException {

        ParserToRPN calculator = new ParserToRPN(scanner.nextLine());
        CalculateRPN.rpnToAnswer(calculator.parserToRPN());

    }
}
