package optionOne;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class ParserToRPN {

    private Deque<String> stack = new ArrayDeque<>();
    private String [] tokens;
    private StringBuilder output = new StringBuilder();
    private String [] stringsRPN;

    public ParserToRPN(String in) {
        tokens = in.trim().split(" ");
    }

    private String parse() {
        System.out.println("Expression: " + Arrays.toString(tokens));
        for (String sign : tokens) {
            switch (sign) {
                case "+", "-" -> gotSymbol(sign, 1);
                case "*", "/" -> gotSymbol(sign, 2);
                default -> output.append(sign).append(" ");
            }
        }

        while (!stack.isEmpty()) {
            output.append(stack.pop()).append(" ");
        }

        System.out.println("Reverse Polish notation: " + output);
        return output.toString();
    }

    private void gotSymbol(String symbol, int priority) {
        while (!stack.isEmpty()) {
            String sign = stack.pop();

            if (sign.equals("(")) {
                stack.push(sign);
                break;
            } else {
                int position;

                if (sign.equals("+") || sign.equals("-"))
                    position = 1;
                else
                    position = 2;

                if (position < priority) {
                    stack.push(sign);
                    break;
                } else
                    output.append(sign).append(" ");
            }
        }
        stack.push(symbol);
    }

    public String[] parserToRPN() {

        return this.stringsRPN = parse().trim().split(" ");
    }

}
