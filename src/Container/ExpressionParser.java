package Container;

import java.util.ArrayList;

public class ExpressionParser implements Parser{
    private ArrayList<String> numbers = new ArrayList<>();
    private ArrayList<String> operationSymbols = new ArrayList<>();
    @Override
    public void parseString(String str) {
        ArrayList<String> digit = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                digit.add(String.valueOf(c));
                if (i == str.length()-1) {
                    appendNumber(digit);
                }
            } else {
                appendNumber(digit);
                digit.clear();
                operationSymbols.add(String.valueOf(c));
            }

        }
    }
    public void appendNumber(ArrayList<String> digit) {
        if (!digit.isEmpty()) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < digit.size(); j++) {
                s.append(digit.get(j));
            }
            numbers.add(s.toString());
        }
    }
    public ArrayList<String> getNumbers() {
        return numbers;
    }

    public ArrayList<String> getOperationSymbols() {
        return operationSymbols;
    }

}
