package expression;

import expression.number_formats.NumberFormat;

public class Add extends BinaryOperator {
    private static final String operStr = "+";
    private static final EXPRESSION_PRIORITY priority = EXPRESSION_PRIORITY.ADD;
    private static final boolean associative = true;
    private static final boolean reversal = false;

    public Add(ExpressionComparator first, ExpressionComparator second) {
        super(first, second, operStr, priority, associative, reversal);
    }

    @Override
    protected <E, T extends NumberFormat<E>> NumberFormat<E> apply(T a, T b) {
        return a.add(b);
    }
}
