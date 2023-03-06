package Service;

import Container.ExpressionParser;
import Model.Calculator;

import java.util.ArrayList;

public class CalculatorService {
    private ExpressionParser parser = ExpressionParser.getInstance();
    private Calculator calculator = new Calculator();
    public void calculations(ArrayList<String> numbers, ArrayList<String> signs){
        ArrayList<Integer> iOfOpBr = new ArrayList<>(extractIndexOfOpeningBrackets(signs));
        ArrayList<Integer> iOfClBr = new ArrayList<>(extractIndexOfClosingBrackets(signs));
        for (int i = iOfOpBr.get(iOfOpBr.size()-1)+1; i < iOfClBr.get(0)-1 ; i++) {
            if(signs.get(i).equals("/")){
                double a = Double.parseDouble(numbers.get(i - 1));
                double b = Double.parseDouble(numbers.get(i));
                numbers.set(i-1, String.valueOf(calculator.Div(a,b)));
                numbers.remove(i);
                break;
            }
        }
        for (int i = iOfOpBr.get(iOfOpBr.size()-1)+1; i < iOfClBr.get(0)-1 ; i++) {
            if(signs.get(i).equals("*")){
                double a = Double.parseDouble(numbers.get(i - 1));
                double b = Double.parseDouble(numbers.get(i));
                numbers.set(i-1, String.valueOf(calculator.Multiple(a,b)));
                numbers.remove(i);
                break;
            }
        }
    }

    private ArrayList<Integer> extractIndexOfOpeningBrackets(ArrayList<String> signs) {
        ArrayList<Integer> indexOfOpeningBrackets = new ArrayList<>();
        for (String sing: signs) {
            if (sing.equals("(")) {
                indexOfOpeningBrackets.add(signs.indexOf(sing));
            }
        }
        return indexOfOpeningBrackets;
    }
    private ArrayList<Integer> extractIndexOfClosingBrackets(ArrayList<String> signs) {
        ArrayList<Integer> indexOfClosingBrackets = new ArrayList<>();
        for (String sing: signs) {
            if (sing.equals(")")) {
                indexOfClosingBrackets.add(signs.indexOf(sing));
            }
        }
        return indexOfClosingBrackets;
    }
}
