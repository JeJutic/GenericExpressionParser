package expression.plugins;

import expression.BinaryOperator;
import expression.ExpressionComparator;
import expression.Mod;

public class ModPlugin extends BinaryOperatorPlugin {
    public ModPlugin() {
        super("mod", true);
    }

    @Override
    public BinaryOperator create(ExpressionComparator first, ExpressionComparator second) {
        return new Mod(first, second);
    }
}
