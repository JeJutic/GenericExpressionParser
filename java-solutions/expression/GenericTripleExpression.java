package expression;

import expression.number_formats.NumberFormat;

public interface GenericTripleExpression {
    <E, T extends NumberFormat<E>> NumberFormat<E> evaluate(T x, T y, T z);
}
