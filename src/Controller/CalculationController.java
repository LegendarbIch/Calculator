package Controller;

import Model.Calculator.CalculatorService;
import Model.Parser.ExpressionParserService;

import java.util.Scanner;

public class CalculationController {
    private final CalculatorService calculatorService;
    private final ExpressionParserService expressionParserService;
    private String str;
    public CalculationController(CalculatorService calculatorService, ExpressionParserService expressionParserService){
        this.calculatorService = calculatorService;
        this.expressionParserService = expressionParserService;
    }

    public void setExpressionString() {
        Scanner keyboard = new Scanner(System.in);
        this.str = keyboard.nextLine();
    }
    public Double calculateTheExpression() throws Exception {
        String parsedString = expressionParserService.parseString(str);
        return calculatorService.calculate(parsedString);
    }

}
