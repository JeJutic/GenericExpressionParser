package expression.plugins;

import expression.BinaryOperator;
import expression.ExpressionComparator;
import expression.Multiply;

public class MultiplyPlugin extends BinaryOperatorPlugin {
    public MultiplyPlugin() {
        super("*", false);
    }

    @Override
    public BinaryOperator create(ExpressionComparator first, ExpressionComparator second) {
        return new Multiply(first, second);
    }
}
