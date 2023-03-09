package Model.Calculator;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class CalculatorService implements Calculator {

    @Override
    public double calculate(String strExpression) throws Exception {
        double dA, dB;
        String sTmp;
        Deque<Double> stack = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(strExpression);
        while(st.hasMoreTokens()) {
            try {
                sTmp = st.nextToken().trim();
                if (1 == sTmp.length() && isOperand(sTmp.charAt(0))) {
                    if (stack.size() < 2) {
                        throw new Exception("Неверное количество данных в стеке для операции " + sTmp);
                    }
                    dB = stack.pop();
                    dA = stack.pop();
                    switch (sTmp.charAt(0)) {
                        case '+' -> dA += dB;
                        case '-' -> dA -= dB;
                        case '/' -> dA /= dB;
                        case '*' -> dA *= dB;
                        case '%' -> dA %= dB;
                        case '^' -> dA = Math.pow(dA, dB);
                        default -> throw new Exception("Недопустимая операция " + sTmp);
                    }
                    stack.push(dA);
                } else {
                    dA = Double.parseDouble(sTmp);
                    stack.push(dA);
                }
            } catch (Exception e) {
                throw new Exception("Недопустимый символ в выражении");
            }
        }

        if (stack.size() > 1) {
            throw new Exception("Количество операторов не соответствует количеству операндов");
        }

        return stack.pop();
    }
    public boolean isOperand(char c) {
        return switch (c) {
            case '-', '+', '*', '/', '^' -> true;
            default -> false;
        };
    }
}
