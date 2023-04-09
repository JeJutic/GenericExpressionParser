package expression;

import expression.number_formats.NumberFormat;

import java.util.Objects;

public abstract class BinaryOperator extends ExpressionComparator {
    private final ExpressionComparator first;
    private final ExpressionComparator second;
    private final String operStr;
    private final boolean associative;
    private final boolean reversal;

    public BinaryOperator(
            ExpressionComparator first, ExpressionComparator second,
            String operStr, EXPRESSION_PRIORITY priority,
            boolean associative, boolean reversal) {
        super(priority);
        this.first = first;
        this.second = second;
        this.operStr = operStr;
        this.associative = associative;
        this.reversal = reversal;
    }

    protected abstract <E, T extends NumberFormat<E>> NumberFormat<E> apply(T a, T b);

    public <E, T extends NumberFormat<E>> NumberFormat<E> evaluate(T x, T y, T z) {
        return apply(first.evaluate(x, y, z), second.evaluate(x, y, z));
    }

    protected boolean needsLeftBracket(ExpressionComparator anyExpr) {
        return super.compareTo(anyExpr) > 0;
    }
    protected boolean needsRightBracket(ExpressionComparator anyExpr) {
        if (super.compareTo(anyExpr) < 0) {
            return false;
        }
        if (super.compareTo(anyExpr) > 0) {
            return true;
        }
        if (associative && super.getPriority() == anyExpr.getPriority()) {
            return false;
        }
        return reversal;
    }

    @Override
    public String toMiniString() {
        StringBuilder sb1 = new StringBuilder(first.toMiniString());
        if (needsLeftBracket(first)) {
            sb1.insert(0, '(');
            sb1.append(')');
        }
        sb1.append(" ").append(operStr).append(" ");
        StringBuilder sb2 = new StringBuilder(second.toMiniString());
        if (needsRightBracket(second)) {
            sb2.insert(0, '(');
            sb2.append(')');
        }
        return sb1.append(sb2).toString();
    }

    @Override
    public String toString() {
        return '(' + first.toString() + ' ' + operStr + ' ' + second.toString() + ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinaryOperator that = (BinaryOperator) o;
        return first.equals(that.first) && second.equals(that.second); // :NOTE: у одинаковых классов одинаковые опер стринги
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second, getClass());
    }
}