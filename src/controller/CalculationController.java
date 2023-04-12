package controller;

import model.Expression;
import model.calculator.CalculatorService;
import model.log.Log;
import model.log.LogService;
import model.parser.ExpressionParserService;

import java.util.Scanner;

public class CalculationController {
    private final CalculatorService calculatorService;
    private final ExpressionParserService expressionParserService;
    private String str;
    private final Log log;
    public Log getLog() {
        return log;
    }


    public CalculationController(CalculatorService calculatorService, ExpressionParserService expressionParserService){
        this.calculatorService = calculatorService;
        this.expressionParserService = expressionParserService;
        this.log = new LogService();
    }

    public void setExpressionString() {
        Scanner keyboard = new Scanner(System.in);
        this.str =  keyboard.nextLine();
    }
    public String getExpressionString() {
        return this.str;
    }
    public Double calculateTheExpression() throws Exception {
        Expression parsedString = expressionParserService.parseString(new Expression(getExpressionString()));
        double result = calculatorService.calculate(parsedString);
        log.appendEvent(str + " = " + result);
        return result;
    }

}
