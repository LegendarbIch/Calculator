package View;

import Container.ExpressionParser;
import Service.CalculatorService;

import java.util.Scanner;

public class Menu {
    Scanner keyboard = new Scanner(System.in);
    CalculatorService calculatorService = CalculatorService.getInstance();
    ExpressionParser expressionParser = ExpressionParser.getInstance();
    public void drawExpression() {
        System.out.println("Введи выражение: ");
        String str = keyboard.nextLine();
        expressionParser.parseString(str);
        calculatorService.calculations(expressionParser.getNumbers(), expressionParser.getOperationSymbols());
        System.out.println(expressionParser.getNumbers() + "\n" + expressionParser.getOperationSymbols());
    }
}
