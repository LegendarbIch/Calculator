package View;

import Controller.CalculationController;
import Model.Parser.ExpressionParserService;
import Model.Calculator.CalculatorService;


public class Menu {

    private final CalculationController calculationController = new CalculationController(new CalculatorService(), new ExpressionParserService());
    public void drawExpression() throws Exception {
        System.out.println("Введи выражение: ");
        calculationController.setExpressionString();
        System.out.println("Результат: " + calculationController.calculateTheExpression());

    }
}
