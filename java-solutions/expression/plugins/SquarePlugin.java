package expression.plugins;

import expression.ExpressionComparator;
import expression.Square;
import expression.UnaryOperator;

public class SquarePlugin extends UnaryOperatorPlugin {
    public SquarePlugin() {
        super("square", true);
    }

    @Override
    public UnaryOperator create(ExpressionComparator inner) {
        return new Square(inner);
    }
}
