package expression.plugins;

import expression.BinaryOperator;
import expression.ExpressionComparator;
import expression.Subtract;

public class SubtractPlugin extends BinaryOperatorPlugin {
    public SubtractPlugin() {
        super("-", false);
    }

    @Override
    public BinaryOperator create(ExpressionComparator first, ExpressionComparator second) {
        return new Subtract(first, second);
    }
}
