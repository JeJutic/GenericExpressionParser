package expression.plugins;

import expression.Add;
import expression.BinaryOperator;
import expression.ExpressionComparator;

public class AddPlugin extends BinaryOperatorPlugin {
    public AddPlugin() {
        super("+", false);
    }

    @Override
    public BinaryOperator create(ExpressionComparator first, ExpressionComparator second) {
        return new Add(first, second);
    }
}
