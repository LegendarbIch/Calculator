package View;

import Container.ExpressionParser;

import java.util.Scanner;

public class Menu {
    Scanner keyboard = new Scanner(System.in);
    ExpressionParser expressionParser = new ExpressionParser();
    public void drawExpression() {
        System.out.println("Введи выражение: ");
        String str = keyboard.nextLine();
        expressionParser.parseString(str);
        System.out.println(expressionParser.getNumbers() + "\n" + expressionParser.getOperationSymbols());
    }
}
