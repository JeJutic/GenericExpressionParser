package expression;

import java.util.Comparator;
import java.util.Set;

public enum EXPRESSION_PRIORITY implements Comparator<EXPRESSION_PRIORITY> {
    NONE,
    SET,
    CLEAR(Set.of(SET)),
    ADD,
    SUBTRACT(Set.of(ADD)),
    MULTIPLY,
    DIVIDE(Set.of(MULTIPLY)),
    MOD,
    UNARY_OPERATOR,
    VARIABLE_AND_CONST;

    private final Set<EXPRESSION_PRIORITY> sameLevel;

    EXPRESSION_PRIORITY(Set<EXPRESSION_PRIORITY> sameLevel) {
        this.sameLevel = sameLevel;
    }

    EXPRESSION_PRIORITY() {
        this(Set.of());
    }

    public boolean hasSameLevel(EXPRESSION_PRIORITY a) {
        return sameLevel.contains(a);
    }

    @Override
    public int compare(EXPRESSION_PRIORITY o1, EXPRESSION_PRIORITY o2) {
        if (o1.hasSameLevel(o2) || o2.hasSameLevel(o1)) {
            return 0;
        } else {
            return o1.compareTo(o2);
        }
    }
}
