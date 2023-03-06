package Service;

import Container.ExpressionParser;
import Model.Calculator;

import java.util.ArrayList;

public class CalculatorService {
    private ExpressionParser parser = new ExpressionParser();
    private Calculator calculator = new Calculator();
    public Double calculations(ArrayList<String> numbers, ArrayList<String> signs){
        ArrayList<Integer> iOfOpBr = new ArrayList<>(extractIndexOfOpeningBrackets(signs));
        ArrayList<Integer> iOfClBr = new ArrayList<>(extractIndexOfClosingBrackets(signs));
        for (int i = iOfOpBr.get(iOfOpBr.size()-1); i < iOfClBr.get(0) ; i++) {

        }
        return 0.0;
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
