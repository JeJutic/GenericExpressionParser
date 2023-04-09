package expression.number_formats;

public class UncheckedIntegerNF implements NumberFormat<Integer> {
    private final int val;

    public UncheckedIntegerNF(int val) {
        this.val = val;
    }

    @Override
    public UncheckedIntegerNF add(NumberFormat<Integer> val) {
        return new UncheckedIntegerNF(this.val + val.getValue());
    }

    @Override
    public UncheckedIntegerNF subtract(NumberFormat<Integer> val) {
        return new UncheckedIntegerNF(this.val - val.getValue());
    }

    @Override
    public UncheckedIntegerNF multiply(NumberFormat<Integer> val) {
        return new UncheckedIntegerNF(this.val * val.getValue());
    }

    @Override
    public UncheckedIntegerNF divide(NumberFormat<Integer> val) {
        return new UncheckedIntegerNF(this.val / val.getValue());
    }

    @Override
    public UncheckedIntegerNF mod(NumberFormat<Integer> val) {
        return new UncheckedIntegerNF(this.val % val.getValue());
    }

    @Override
    public UncheckedIntegerNF negate() {
        return new UncheckedIntegerNF(-val);
    }

    @Override
    public UncheckedIntegerNF valueOf(int val) {
        return new UncheckedIntegerNF(val);
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
