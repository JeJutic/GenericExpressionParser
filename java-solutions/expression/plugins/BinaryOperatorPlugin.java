package expression.plugins;

import expression.BinaryOperator;
import expression.EXPRESSION_PRIORITY;
import expression.ExpressionComparator;

public abstract class BinaryOperatorPlugin {
    private final String opStr;
    private final boolean needsWs;

    protected BinaryOperatorPlugin(String opStr, boolean needsWs) {
        this.opStr = opStr;
        this.needsWs = needsWs;
    }

    public abstract BinaryOperator create(ExpressionComparator first, ExpressionComparator second);

    public int compareTo(EXPRESSION_PRIORITY p) {
        return create(null, null).compareTo(p);
    }

    public EXPRESSION_PRIORITY getPriority() {
        return create(null, null).getPriority();
    }

    public String getOpStr() {
        return opStr;
    }

    public boolean isNeedsWs() {
        return needsWs;
    }
}
