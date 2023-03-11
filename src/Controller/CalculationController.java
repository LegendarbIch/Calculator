package Controller;

import Model.Calculator.CalculatorService;
import Model.Parser.ExpressionParserService;

import java.util.Scanner;

public class CalculationController {
    private final CalculatorService calculatorService;
    private final ExpressionParserService expressionParserService;
    private final WriteController writeController;
    private String str;
    public CalculationController(CalculatorService calculatorService, ExpressionParserService expressionParserService){
        this.calculatorService = calculatorService;
        this.expressionParserService = expressionParserService;
        this.writeController = new WriteController();
    }

    public void setExpressionString() {
        Scanner keyboard = new Scanner(System.in);
        this.str = keyboard.nextLine();
    }
    public Double calculateTheExpression() throws Exception {
        String parsedString = expressionParserService.parseString(str);
        writeController.WriteToFile(str + " = ");
        writeController.WriteToFile(String.valueOf(calculatorService.calculate(parsedString)));
        return calculatorService.calculate(parsedString);
    }

}
