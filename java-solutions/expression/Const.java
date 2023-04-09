package expression;

import expression.number_formats.NumberFormat;

import java.util.Objects;

public class Const extends ExpressionComparator implements GenericTripleExpression {
    private static final EXPRESSION_PRIORITY priority = EXPRESSION_PRIORITY.VARIABLE_AND_CONST;
    private final Number val;

    private Const(Number val) {
        super(priority);
        this.val = val;
    }

    public Const(int val) {
        this((Number) val);
    }

    @Override
    public <E, T extends NumberFormat<E>> NumberFormat<E> evaluate(T x, T y, T z) {
        return x.valueOf((int) val);
    }

    @Override
    public String toString() {
        return val.toString();
    }

    @Override
    public String toMiniString() {
        return val.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Const aConst = (Const) o;
        return val.equals(aConst.val);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }
}
