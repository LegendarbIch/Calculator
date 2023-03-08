package Container;

import java.util.ArrayList;

public class ExpressionParser implements Parser{
    private final ArrayList<String> numbers = new ArrayList<>();
    private final ArrayList<String> operationSymbols = new ArrayList<>();

    private static ExpressionParser instance;
    public static synchronized ExpressionParser getInstance() {
        if (instance == null) {
            instance = new ExpressionParser();
        }
        return instance;
    }
    private ExpressionParser() {

    }

    @Override
    public String parseString(String strExpression) throws Exception {
        StringBuilder sbStack = new StringBuilder(""), sbOut = new StringBuilder("");
        char symbol, tmpSymbol;

        for (int i = 0; i < strExpression.length(); i++) {
            symbol = strExpression.charAt(i);
            if (isOperand(symbol)) {
                while (sbStack.length() > 0) {
                    tmpSymbol = sbStack.substring(sbStack.length()-1).charAt(0);
                    if (isOperand(tmpSymbol) && (operandPriority(symbol) <= operandPriority(tmpSymbol))) {
                        sbOut.append(" ").append(tmpSymbol).append(" ");
                        sbStack.setLength(sbStack.length()-1);
                    } else {
                        sbOut.append(" ");
                        break;
                    }
                }
                sbOut.append(" ");
                sbStack.append(symbol);
            } else if ('(' == symbol) {
                sbStack.append(symbol);
            } else if (')' == symbol) {
                tmpSymbol = sbStack.substring(sbStack.length()-1).charAt(0);
                while ('(' != tmpSymbol) {
                    if (sbStack.length() < 1) {
                        throw new Exception("Ошибка разбора скобок. Проверьте правильность выражения.");
                    }
                    sbOut.append(" ").append(tmpSymbol);
                    sbStack.setLength(sbStack.length()-1);
                    tmpSymbol = sbStack.substring(sbStack.length()-1).charAt(0);
                }
                sbStack.setLength(sbStack.length()-1);
            } else {
                // Если символ не оператор - добавляем в выходную последовательность
                sbOut.append(symbol);
            }
        }

        // Если в стеке остались операторы, добавляем их в входную строку
        while (sbStack.length() > 0) {
            sbOut.append(" ").append(sbStack.substring(sbStack.length()-1));
            sbStack.setLength(sbStack.length()-1);
        }

        return  sbOut.toString();
    }
    public boolean isOperand(char c) {
        return switch (c) {
            case '-', '+', '*', '/', '^' -> true;
            default -> false;
        };
    }
    public byte operandPriority(char op) {
        return switch (op) {
            case '^' -> 3;
            case '*', '/', '%' -> 2;
            default -> 1;
        };
    }
    @Deprecated
    public void parseStringInArrays(String str) {
        ArrayList<String> digit = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                digit.add(String.valueOf(c));
                if (i == str.length()-1) {
                    appendNumber(digit);
                }
            } else {
                appendNumber(digit);
                digit.clear();
                operationSymbols.add(String.valueOf(c));
            }

        }
    }

    public void appendNumber(ArrayList<String> digit) {
        if (!digit.isEmpty()) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < digit.size(); j++) {
                s.append(digit.get(j));
            }
            numbers.add(s.toString());
        }
    }
    public ArrayList<String> getNumbers() {
        return numbers;
    }

    public ArrayList<String> getOperationSymbols() {
        return operationSymbols;
    }

}
