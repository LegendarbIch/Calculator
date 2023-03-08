package View;

import Container.ExpressionParser;
import Service.CalculatorService;

import java.util.Scanner;

public class Menu {
    Scanner keyboard = new Scanner(System.in);
    CalculatorService calculatorService = CalculatorService.getInstance();
    ExpressionParser expressionParser = ExpressionParser.getInstance();
    public void drawExpression() throws Exception {
        System.out.println("Введи выражение: ");
        String str = keyboard.nextLine();
        System.out.println(expressionParser.parseString(str));
//        calculatorService.calculations(expressionParser.getNumbers(), expressionParser.getOperationSymbols());
//        System.out.println(calculatorService.getNumbers() + "\n" + calculatorService.getSigns());
    }
}
