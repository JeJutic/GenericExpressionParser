package expression;

import expression.number_formats.NumberFormat;

public class Multiply extends BinaryOperator {
    private static final String operStr = "*";
    private static final EXPRESSION_PRIORITY priority = EXPRESSION_PRIORITY.MULTIPLY;
    private static final boolean associative = true;
    private static final boolean reversal = true;

    public Multiply(ExpressionComparator first, ExpressionComparator second) {
        super(first, second, operStr, priority, associative, reversal);
    }

    @Override
    protected <E, T extends NumberFormat<E>> NumberFormat<E> apply(T a, T b) {
        return a.multiply(b);
    }
}
