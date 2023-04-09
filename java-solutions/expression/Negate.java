package expression;

import expression.number_formats.NumberFormat;

public class Negate extends UnaryOperator {

    public Negate(ExpressionComparator inner) {
        super(inner, "-");
    }

    @Override
    protected <E> NumberFormat<E> apply(NumberFormat<E> a) {
        return a.negate();
    }
}
