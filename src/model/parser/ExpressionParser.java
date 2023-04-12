package model.parser;

import model.Expression;

public interface ExpressionParser {
    Expression parseString(Expression strExpression) throws Exception;
}
