package model.parser;

import model.Expression;

public class ExpressionParserService implements ExpressionParser {

    @Override
    public Expression parseString(Expression strExpression) throws Exception {
        StringBuilder sbStack = new StringBuilder(), sbOut = new StringBuilder();
        char symbol, tmpSymbol;

        for (int i = 0; i < strExpression.getExpression().length(); i++) {
            symbol = strExpression.getExpression().charAt(i);
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

        strExpression.setExpression(sbOut.toString());
        return strExpression;
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

}
