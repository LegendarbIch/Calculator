package Service;

import Container.ExpressionParser;
import Model.Calculator;

import java.util.ArrayList;

public class CalculatorService {
    private final ExpressionParser parser = ExpressionParser.getInstance();

    public ArrayList<String> getNumbers() {
        return numbers;
    }

    public ArrayList<String> getSigns() {
        return signs;
    }

    private ArrayList<String> numbers;
    private ArrayList<String> signs;

    private static CalculatorService instance;
    public static synchronized CalculatorService getInstance() {
        if (instance == null) {
            instance = new CalculatorService();
        }
        return instance;
    }
    private CalculatorService() {

    }
    private final Calculator calculator = new Calculator();
    private ArrayList<Integer> openBr;
    private ArrayList<Integer> closeBr;
    private final char[] operands = new char[] {'/', '*', '-', '+'};
    public void calculations(ArrayList<String> numbers, ArrayList<String> signs){
        this.numbers = numbers;
        this.signs = signs;
        closeBr = new ArrayList<>(extractIndexOfClosingBrackets());
        openBr = new ArrayList<>(extractIndexOfOpeningBrackets());
//        while(open.size() != 0 || close.size() != 0) {
            CalculationsInBrackets();
//            open.remove(open.size()-1);
//            close.remove(0);


    }
    private void CalculationsInBrackets() {
        int open = openBr.get(openBr.size() - 1) + 1;
        int close = closeBr.get(0);
        for (int sing = open; sing < close; sing++) {
            int operand = 0;
            for (int i = open; i < close; i++) {
                if (signs.get(i).equals(String.valueOf(operands[operand]))) {
                    double a = Double.parseDouble(numbers.get(i - 1));
                    double b = Double.parseDouble(numbers.get(i));
                    switch (String.valueOf(operands[operand])) {
                        case ("/") -> numbers.set(i - 1, String.valueOf(calculator.Div(a, b)));
                        case ("*") -> numbers.set(i - 1, String.valueOf(calculator.Multiple(a, b)));
                        case ("+") -> numbers.set(i - 1, String.valueOf(calculator.Sum(a, b)));
                        case ("-") -> numbers.set(i - 1, String.valueOf(calculator.Sub(a, b)));
                        default -> {
                        }
                    }
                    numbers.remove(i);
                    signs.remove(i);
                    close--;
                    break;
                }
            }
            operand++;
        }
    }

    private ArrayList<Integer> extractIndexOfOpeningBrackets() {
        ArrayList<Integer> indexOfOpeningBrackets = new ArrayList<>();
        for (String sing: signs) {
            if (sing.equals("(")) {
                indexOfOpeningBrackets.add(signs.indexOf(sing));
            }
        }
        return indexOfOpeningBrackets;
    }
    private ArrayList<Integer> extractIndexOfClosingBrackets() {
        ArrayList<Integer> indexOfClosingBrackets = new ArrayList<>();
        for (String sing: signs) {
            if (sing.equals(")")) {
                indexOfClosingBrackets.add(signs.indexOf(sing));
            }
        }
        return indexOfClosingBrackets;
    }
}
