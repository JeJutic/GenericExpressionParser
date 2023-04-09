package expression.plugins;

import expression.ExpressionComparator;
import expression.UnaryOperator;

public abstract class UnaryOperatorPlugin {
    private final String opStr;
    private final boolean needsWs;

    public UnaryOperatorPlugin(String opStr, boolean needsWs) {
        this.opStr = opStr;
        this.needsWs = needsWs;
    }

    public abstract UnaryOperator create(ExpressionComparator inner);

    public String getOpStr() {
        return opStr;
    }

    public boolean isNeedsWs() {
        return needsWs;
    }
}
