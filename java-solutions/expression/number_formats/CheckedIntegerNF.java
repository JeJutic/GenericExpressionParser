package expression.number_formats;

import expression.exceptions.OverflowException;

public class CheckedIntegerNF implements NumberFormat<Integer> {
    private final int val;

    public CheckedIntegerNF(int val) {
        this.val = val;
    }

    private int add(int a, int b) {
        int c = a + b;
        if ((a ^ c) < 0 && (b ^ c) < 0) {
            throw new OverflowException("Add operation");
        }
        return c;
    }

    @Override
    public CheckedIntegerNF add(NumberFormat<Integer> val) {
        return new CheckedIntegerNF(add(this.val, val.getValue()));
    }

    private int subtract(int a, int b) {
        int c = a - b;
        if ((a ^ b) < 0 && (a ^ c) < 0) {
            throw new OverflowException("Subtract operation");
        }
        return c;
    }

    @Override
    public CheckedIntegerNF subtract(NumberFormat<Integer> val) {
        return new CheckedIntegerNF(subtract(this.val, val.getValue()));
    }

    private int multiply(int a, int b) {
        if (b != 0 && a * b / b != a) {
            throw new ArithmeticException("Overflow in Multiply operation");
        }
        if (b == -1 && a == Integer.MIN_VALUE) {
            throw new OverflowException("Multiply operation");
        }
        return a * b;
    }

    @Override
    public CheckedIntegerNF multiply(NumberFormat<Integer> val) {
        return new CheckedIntegerNF(multiply(this.val, val.getValue()));
    }

    private int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        if (a == Integer.MIN_VALUE && b == -1) {
            throw new OverflowException("Division operation");
        }
        return a / b;
    }

    @Override
    public CheckedIntegerNF divide(NumberFormat<Integer> val) {
        return new CheckedIntegerNF(divide(this.val, val.getValue()));
    }

    @Override
    public CheckedIntegerNF mod(NumberFormat<Integer> val) {
        if (val.getValue() == 0) {
            throw new ArithmeticException("Division by zero in mod operation");
        }
        return new CheckedIntegerNF(this.val % val.getValue());
    }

    private int negate(int a) {
        if (a == Integer.MIN_VALUE) {
            throw new OverflowException("Negate operation");
        }
        return -a;
    }

    @Override
    public CheckedIntegerNF negate() {
        return new CheckedIntegerNF(negate(val));
    }

    @Override
    public CheckedIntegerNF valueOf(int val) {
        return new CheckedIntegerNF(val);
    }

    @Override
    public Integer getValue() {
        return val;
    }

    @Override
    public int compareTo(Integer o) {
        return Integer.valueOf(val).compareTo(o);
    }
}
