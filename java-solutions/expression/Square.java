package expression;

import expression.number_formats.NumberFormat;

public class Square extends UnaryOperator {

    public Square(ExpressionComparator inner) {
        super(inner, "square");
    }

    @Override
    protected <E> NumberFormat<E> apply(NumberFormat<E> a) {
        return a.multiply(a);
    }
}
