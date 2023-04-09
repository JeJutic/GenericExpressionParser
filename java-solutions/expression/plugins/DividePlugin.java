package expression.plugins;

import expression.BinaryOperator;
import expression.Divide;
import expression.ExpressionComparator;

public class DividePlugin extends BinaryOperatorPlugin {
    public DividePlugin() {
        super("/", false);
    }

    @Override
    public BinaryOperator create(ExpressionComparator first, ExpressionComparator second) {
        return new Divide(first, second);
    }
}
