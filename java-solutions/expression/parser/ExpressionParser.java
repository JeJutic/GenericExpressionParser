package expression.parser;

import expression.*;
import expression.plugins.*;

import java.text.ParseException;
import java.util.List;

public final class ExpressionParser implements GenericTripleParser {
    @Override
    public ExpressionComparator parse(String expression) throws ParseException {
        return new ExpressionToComparatorParser(
                new StringCharSource(expression),
                List.of(
                        new AddPlugin(), new SubtractPlugin(),
                        new MultiplyPlugin(), new DividePlugin(),
                        new ModPlugin()
                ),
                List.of(
                        new NegatePlugin(),
                        new AbsPlugin(), new SquarePlugin()
                )
        ).parse();
    }
}