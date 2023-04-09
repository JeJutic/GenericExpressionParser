package expression.plugins;

import expression.Abs;
import expression.ExpressionComparator;
import expression.UnaryOperator;

public class AbsPlugin extends UnaryOperatorPlugin {

    public AbsPlugin() {
        super("abs", true);
    }

    @Override
    public UnaryOperator create(ExpressionComparator inner) {
        return new Abs(inner);
    }
}
