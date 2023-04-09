package expression;

public abstract class ExpressionComparator implements GenericTripleExpression, ToMiniString {
    private final EXPRESSION_PRIORITY priority;

    protected ExpressionComparator(EXPRESSION_PRIORITY priority) {
        this.priority = priority;
    }

    public EXPRESSION_PRIORITY getPriority() {
        return priority;
    }

    public int compareTo(EXPRESSION_PRIORITY p) {
        return priority.compare(priority, p);
    }

    public int compareTo(ExpressionComparator a) {
        return compareTo(a.getPriority());
    }
}
