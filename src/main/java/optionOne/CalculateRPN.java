package optionOne;

import java.util.ArrayDeque;
import java.util.Deque;

public class CalculateRPN {

    private static Deque<Double> stack = new ArrayDeque<>();

    public static void rpnToAnswer(String[] parsedExpression) throws CalculationException {

        for (String symbol : parsedExpression) {
            if (isNumber(symbol)) {
                stack.push(Double.parseDouble(symbol));
            } else {
                operationSelection(symbol);
            }
        }
        showResult();
    }

    private static void operationSelection(String string) throws CalculationException {
        try {
            double tmp1 = stack.pop();
            double tmp2 = stack.pop();

            switch (string) {
                case "+" -> stack.push(tmp1 + tmp2);
                case "-" -> stack.push(tmp2 - tmp1);
                case "*" -> stack.push(tmp1 * tmp2);
                case "/" -> {
                    if (tmp1 == 0) {
                        throw new CalculationException("Second operand can't be zero in division");
                    }
                    stack.push(tmp2 / tmp1);
                }
                case "^" -> stack.push(Math.pow(tmp1, tmp2));
                default -> throw new CalculationException("Incorrect sign or number: " + "\"" + string + "\"");
            }
        } catch (CalculationException e) {
            throw new CalculationException("Incorrect sign or number: " + "\"" + string + "\"");
        }
    }

    private static boolean isNumber(String number) {
        try {
            Double.parseDouble(number);

            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static void showResult() throws CalculationException {
        if (!stack.isEmpty()) {
            System.out.println("Answer: " + stack.pop());
        } else {
            throw new CalculationException("Stack is empty.");
        }
    }
}
