package expression;

import expression.number_formats.NumberFormat;

public class Mod extends BinaryOperator {

    public Mod(ExpressionComparator first, ExpressionComparator second) {
        super(first, second, "mod", EXPRESSION_PRIORITY.MOD, false, true);
    }

    @Override
    protected <E, T extends NumberFormat<E>> NumberFormat<E> apply(T a, T b) {
        return a.mod(b);
    }
}
