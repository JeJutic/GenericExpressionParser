package expression.parser;

import expression.GenericTripleExpression;

import java.text.ParseException;

public interface GenericTripleParser {
    GenericTripleExpression parse(String expression) throws ParseException;
}
