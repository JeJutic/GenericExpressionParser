package expression.plugins;

import expression.ExpressionComparator;
import expression.Negate;
import expression.UnaryOperator;

public class NegatePlugin extends UnaryOperatorPlugin {

    public NegatePlugin() {
        super("-", false);
    }

    @Override
    public UnaryOperator create(ExpressionComparator inner) {
        return new Negate(inner);
    }
}
