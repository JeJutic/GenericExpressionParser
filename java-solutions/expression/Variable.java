package expression;

import expression.number_formats.NumberFormat;

import java.util.Objects;

public class Variable extends ExpressionComparator {
    private static final EXPRESSION_PRIORITY priority = EXPRESSION_PRIORITY.VARIABLE_AND_CONST;
    private static final String[] varNames = {"x", "y", "z"};
    private final int varId;
    // if any operation has a substring with var name, then vars in text should be surrounded with ws

    public Variable(String name) {
        super(priority);
        if (Objects.equals(name, varNames[0])) {
            varId = 0;
        } else if (Objects.equals(name, varNames[1])) {
            varId = 1;
        } else if (Objects.equals(name, varNames[2])) {
            varId = 2;
        } else {
            throw new RuntimeException(
                    "Variable isn't one of " + varNames[0] + ' ' + varNames[1] + ' ' + varNames[2]
            );
        }
    }

    public static String[] getVarNames() {
        return varNames;
    }

    @Override
    public <E, T extends NumberFormat<E>> NumberFormat<E> evaluate(T x, T y, T z) {
        if (varId == 0) {
            return x;
        } else if (varId == 1) {
            return y;
        } else if (varId == 2) {
            return z;
        }
        throw new RuntimeException();
    }

    @Override
    public String toMiniString() {
        return varNames[varId];
    }

    @Override
    public String toString() {
        return varNames[varId];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Variable variable = (Variable) o;
        return varId == variable.varId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(varId);
    }
}
