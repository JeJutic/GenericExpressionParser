package expression;

import expression.number_formats.NumberFormat;

public class Abs extends UnaryOperator {

    public Abs(ExpressionComparator inner) {
        super(inner, "abs");
    }

    @Override
    protected <E> NumberFormat<E> apply(NumberFormat<E> a) {
        if (a.compareTo(a.valueOf(0).getValue()) < 0) {
            return a.negate();
        }
        return a;
    }
}
