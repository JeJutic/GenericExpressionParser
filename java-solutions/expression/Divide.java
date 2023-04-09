package expression;

import expression.number_formats.NumberFormat;

public class Divide extends BinaryOperator {
    private static final String operStr = "/";
    private static final EXPRESSION_PRIORITY priority = EXPRESSION_PRIORITY.DIVIDE;
    private static final boolean associative = false;
    private static final boolean reversal = true;

    public Divide(ExpressionComparator first, ExpressionComparator second) {
        super(first, second, operStr, priority, associative, reversal);
    }

    @Override
    protected <E, T extends NumberFormat<E>> NumberFormat<E> apply(T a, T b) {
        return a.divide(b);
    }
}
