package expression.generic;

import expression.GenericTripleExpression;
import expression.number_formats.*;
import expression.parser.ExpressionParser;

import java.text.ParseException;
import java.util.Objects;

public class GenericTabulator implements Tabulator {

    <E> Object[][][] solve(GenericTripleExpression expr, NumberFormat<E> origin,
                           int x1, int y1, int z1,
                           int xd, int yd, int zd) {
        Object[][][] res = new Object[xd + 1][yd + 1][zd + 1];
        for (int i = 0; i <= xd; i++) {
            for (int j = 0; j <= yd; j++) {
                for (int k = 0; k <= zd; k++) {
                    NumberFormat<E> x = origin.valueOf(x1 + i);
                    NumberFormat<E> y = origin.valueOf(y1 + j);
                    NumberFormat<E> z = origin.valueOf(z1 + k);

                    try {
                        res[i][j][k] = expr.evaluate(x, y, z).getValue();
                    } catch (ArithmeticException e) {
                        res[i][j][k] = null;
                    }
                }
            }
        }
        return res;
    }

    @Override
    public Object[][][] tabulate(
            String mode, String expression, int x1, int x2, int y1, int y2, int z1, int z2
    ) {
        GenericTripleExpression expr;
        try {
            expr = new ExpressionParser().parse(expression);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid expression: " + e.getMessage());
        }
        if (x2 < x1 || y2 < y1 || z2 < z1) {
            throw new IllegalArgumentException("Range of calculations isn't valid: " +
                    (x2 < x1 ? x2 + " < " + x1 + " " : "") +
                    (y2 < y1 ? y2 + " < " + y1 + " " : "") +
                    (z2 < z1 ? z2 + " < " + z1 : "")
            );
        }
        int xd = x2 - x1 + 1;
        int yd = y2 - y1 + 1;
        int zd = z2 - z1 + 1;
        if (Objects.equals(mode, "i")) {
            return solve(expr, new CheckedIntegerNF(0), x1, y1, z1, xd, yd, zd);
        } else if (Objects.equals(mode, "bi")) {
            return solve(expr, new BigIntegerNF(0), x1, y1, z1, xd, yd, zd);
        } else if (Objects.equals(mode, "d")) {
            return solve(expr, new DoubleNF(0), x1, y1, z1, xd, yd, zd);
        } else if (Objects.equals(mode, "u")) {
            return solve(expr, new UncheckedIntegerNF(0), x1, y1, z1, xd, yd, zd);
        } else if (Objects.equals(mode, "l")) {
            return solve(expr, new UncheckedLongNF(0), x1, y1, z1, xd, yd, zd);
        } else if (Objects.equals(mode, "s")) {
            return solve(expr, new UncheckedShortNF(0), x1, y1, z1, xd, yd, zd);
        } else {
            throw new IllegalArgumentException("Unknown mode: " + mode);
        }
    }
}
