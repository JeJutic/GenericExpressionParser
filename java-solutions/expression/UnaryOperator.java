package expression;

import expression.number_formats.NumberFormat;

abstract public class UnaryOperator extends ExpressionComparator {
    private final ExpressionComparator inner;
    private final String operStr;

    protected UnaryOperator(ExpressionComparator inner, String operStr) {
        super(EXPRESSION_PRIORITY.UNARY_OPERATOR);
        this.inner = inner;
        this.operStr = operStr;
    }

    protected abstract <E> NumberFormat<E> apply(NumberFormat<E> a);

    @Override
    public <E, T extends NumberFormat<E>> NumberFormat<E> evaluate(T x, T y, T z) {
        return apply(inner.evaluate(x, y, z));
    }

    @Override
    public String toMiniString() {
        return operStr +
                (super.compareTo(inner) > 0 ? '(' : ' ') +
                inner.toMiniString() +
                (super.compareTo(inner) > 0 ? ")" : "");
    }

    @Override
    public String toString() {
        return operStr + '(' + inner.toString() + ')';
    }
}
