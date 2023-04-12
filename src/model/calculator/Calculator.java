package model.calculator;

import model.Expression;

public interface Calculator {
    double calculate(Expression expression) throws Exception;
}
